/* Variables globales */

// N�mero de palabras encontradas
wordsFound = 0;
// Array con la informaci�n de las palabras
// Cada elemento es un objeto (Word) con sus propiedades (id, word y description) y una propiedad extra que es un array, el cual contiene las ids de las posiciones de las letras en el tablero
gameWords = [];
// Segundos del juego
gameSeconds = 0;
// Inicializador de tiempo restante
countdown = undefined;
// Letras seleccionadas (array con posiciones de letras seleccionadas)
selectedLetters = [];

/* Funciones */

// Funci�n jugar


/*{
    casillero: 'html del casillero',
    words: [
    {
        id: '4',
        word: 'Code',
        description: 'lo que significa',
        cell: ['14','26','38','40']
    }
],
    gameSeconds
}*/


function play(){
    // Recoge par�metros para el juego
    // https://stackoverflow.com/questions/43895473/promise-inside-promise-whats-the-correct-way-to-return-a-variable-from-the-chi/43895627
    jQuery.ajax({
        type: 'POST',
        url:"play",
        success: function(response) {
            console.log(response);
            // Inicializa el juego
                initGame(response);
            }
        });
}

// Ejemplo petici�n Ajax a servlet
// petici�n post v�a ajax cuya a un servlet para obtener la estructura de la sopa de letras
// ser�a un post a un servlet
// ese servlet generar�a la estructura de la sopa de letras completa y devuelve
// en la respuesta se inserta la sopa de letras
function demoAjaxServletRequest(){

}

// Funci�n para comprobar las letras seleccionadas
function checkLetters(letraId) {
    let wasFound = [];
    // Recorrer todas las palabras (words) y verificar si la posici�n de esas letras forman una palabra
    for (let i = 0; i < gameWords.length; i++){
        // Palabra
        let word = gameWords[i];
        // Letras de palabra
        let letters = word.letters;
        let newWordFound = false;
        // Recorremos letras de palabra
        for(let j = 0; j < letters.length; j++){
            let letter = letters[j];
            let position = letter.Position;
            // Creamos un string positions con la columna y la fila, porque así podemos luego verificar si existe en el selectedLetterString
            let positionString = position[0]+"-"+position[1];
            //console.log(selectedLettersString);
            //console.log(selectedLettersString[0]);
            //console.log(positions);
            // Si la posici�n de la letra de la palabra que estamos recorriendo no est� en las posiciones almacenadas de las letras seleccionadas
            if(!selectedLetters.includes(positionString)){
                //console.log(word.word);
                //console.log(letter);
                //console.log("palabra no completa");
                // salimos del for porque esta palabra no está completa
                break;
            }
            // Si se ha llegado al final y tenemos todas las posiciones de las letras de la palabra
            if(j + 1 == letters.length){
                console.log("ultima letra de palabra");
                newWordFound = true;
            }
        }
        if(newWordFound == true){
            // Tachamos la palabra de la lista
            overlineWord(word);
            // Bloqueamos las posiciones de esa palabra en la sopa de letras
            blockWord(word.letters);
            // Comprobamos si ha ganado
            wordFound();
            // Dejamos constancia de que una palabra al menos fue encontrada
            wasFound.push(word.id);
        }
    }
    // Si se llegó a encontrar alguna palabra quitamos sus letras de las letras seleccionadas
    if(wasFound.length > 0){
        // Quitamos las posiciones de las letras de las palabras encontradas de la selección de letras
        for (let i = 0; i < gameWords.length; i++) {
            // Palabra
            word = gameWords[i];
            // Si la id de la palabra es una de las que se encontraron
            if(wasFound.includes(word.id)) {
                // Letras de palabra
                letters = word.letters;
                // Recorremos letras de palabra
                for (let j = 0; j < letters.length; j++) {
                    letter = letters[j];
                    position = letter.Position;
                    // Creamos un string positions con la columna y la fila, porque así podemos luego verificar si existe en el selectedLetterString
                    positionString = position[0] + "-" + position[1];
                    selectedLetters = selectedLetters.filter(item => item !== positionString);
                }
            }
        }
    }
}

// Recibe como par�metro el identificador de una palabra que est� dentro del array global gameWords
function blockWord(letters){

    let letter, position, row, col, id;
    // recorremos gameWords
    // obtenemos palabra por id
    // recorremos letras
    // bloqueamos la posici�n de la sopa de letars asignando
    // Asignando la clase letterOff
    for (let i=0;i<letters.length;i++){

        letter = letters[i];
        position = letter.Position;
        row = position[0];
        col = position[1];
        id = row+"-"+col;
        $("#"+id).addClass("letterOff");
    }

}

// Recibe elemento word con propiedades del modelo
function overlineWord(word){
    console.log(word);
    //Obtenemos palabra cuyo identificador es "Word.id"
    let palabra = document.getElementById(word.id);
    //Añadimos la clase css "tachar palabra" a palabra
    palabra.classList.add('lineThrough');
}

// Funci�n para comprobar si las letras seleccionadas forman una palabra
function lettersAreWord(){
    // Obtenemos las letras seleccionadas
    // Recorremos y obtenemos el identificador del casillero
    // Comparamos los identificadores del casillero con los identificadores asignados a las palabras
    // Si hay match devolvemos true
    // En caso contrario false
}

// Funci�n para desactivar letras seleccionadas del tablero
function disableSelectedLetters(){
    // Desactiva las letras que est�n actualmente marcadas como seleccionadas
}

// Funci�n contabilizar palabra encontrada
function wordFound(){
    // Aumenta en 1 el contador de palabras encontradas
    wordsFound = wordsFound + 1;
    checkWin();
}

// Funci�n checkWin
function checkWin(){
    // Comprueba si ya est�n encontradas todas las palabras
    if(wordsFound == gameWords.length){
        // Finalizar partida
        finishGame();
    }
}

// Funci�n mostrar victoria
function youWin(){
    // Muestra mensaje al usuario de que ha ganado
    const message = "�Enhorabuena! Has ganado.";
    renderMessage(message);
    // Renderizamos informaci�n de palabras
    renderWordDetails();
}

// Funci�n terminar la partida
function finishGame(){
    // Finaliza setInterval
    clearInterval(countdown);
    // Deshabilitamos casillero
    OnOffGame();
    // Comprueba n�mero de palabras encontradas
    if(wordsFound == gameWords.length){
        // Si el jugador ha encontrado todas le decimos que ha ganado
        youWin();
    }else{
        // En caso contrario le decimos que ha perdido
        gameOver();
    }
    // Habilitamos el bot�n para que pueda volver a jugar
    enablePlayButton();
}

// Funci�n para deshabilitar todas las casillas
function OnOffGame(){
    // Para que el jugador no pueda seguir interactuando con las casillas cuando la partida ha finalizado
    jQuery("#game").toggleClass("gameOff");
}

// Funci�n para mostrar mensaje
function renderMessage(message){
    // Recibe el par�metro de las funciones youWin y gameOver
    // Renderiza el mensaje en pantalla
    alert(message);
}

function disablePlayButton(){
    // Deshabilitar el bot�n jugar
    document.getElementById("play").disabled = true;
}

function enablePlayButton(){
    // Deshabilitar el bot�n jugar
    document.getElementById("play").disabled = false;
}

// Funci�n iniciar juego
function initGame(juego){
    // Mostrar información de juego
    if(jQuery("#gameInfo").hasClass("esconder")){
        jQuery("#gameInfo").toggleClass("esconder");
    }
    // Palabras con letras y posiciones
    gameWords = juego.words;
    // Set gameSeconds
    gameSeconds = parseInt(juego.seconds);
    // Renderizamos tablero
    renderGame(juego.casillero);
    // Si el jugador ha vuelto a comenzar otra partida habilitamos casillero
    if(jQuery("#game").hasClass("gameOff")){
        OnOffGame();
    }
    // Deshabilitar bot�n jugar
    disablePlayButton();
    // Renderizamos palabras a encontrar
    renderWords(juego.words);
    // Inicia la cuenta regresiva
    initCountdown();
    // Evento click casilla letra
    $( ".letra" ).click(function(e) {
        //console.log(e.target);
        // Almacenamos id / posiciones en selectedLetters (variable global)
        let letraId = e.target.id;
        // Marcamos o desmarcamos como seleccionada
        jQuery('#' + letraId).toggleClass('soup');
        let letraPosicion = letraId.split("-");
        // Obtenemos posiciones de la letra clicada
        let row = letraPosicion[0];
        let col = letraPosicion[1];
        // Si la letra ha sido seleccionada a�adimos a selectedLetters
        if(jQuery("#"+letraId).hasClass("soup")){
            let tempId = row+"-"+col;
            selectedLetters.push(tempId);
        }else{
            // Si la letra ha sido deseleccionada quitamos de selectedLetters
            selectedLetters = selectedLetters.filter(item => item !== letraId);
            //console.log(filtered);
        }
        //console.log("row "+row+" col "+col);

        // Comprobamos letras seleccionadas
        checkLetters(letraId);
    });
}

// Funci�n para contar el tiempo restante
function initCountdown(){
    // Cuenta regresiva con m�todo setInterval
    // El set interval se ejecuta cada 1000 milisegundos = 1 segundo
    // Vamos restando 1 segundo por ejecuci�n
    countdown = setInterval(function(){
        gameSeconds = gameSeconds - 1;
        // Muestra segundos restantes en pantalla
        renderTime(gameSeconds);
        // Si llega a 0 el jugador pierde y se deshabilitan las casillas
        if(gameSeconds == 0){
            // Finalizamos la partida
            finishGame();
        }
        }, 1000);
}

// Muestra segundos en pantalla
function renderTime(seconds){
    // Transforma segundos a minutos y segundos
    const time = secondsToTime(seconds);
    // Muestra el tiempo en pantalla
    //console.log(time);
    document.getElementById("time").innerHTML = time;
}

// Recibe segundos y devuelve minutos y segundos
function secondsToTime(seconds){
    const minutos = Math.floor(seconds / 60);
    const segundos = seconds - minutos * 60;
    const time = minutos + ":" + segundos;
    return time;
}

// Funci�n mostrar derrota
function gameOver(){
    // Muestra mensaje al usuario de que ha perdido
    const message = "Ohhh, se te ha agotado el tiempo y has perdido. ¡Ánimo! Inténtalo de nuevo.";
    renderMessage(message);
}

// Funci�n para mostrar palabras a encontrar
function renderWords(words){
    //console.log(words);
    // Obtiene listado de palabras
    const wordList = generateWordList(words,false);
    // Renderizamos listado de palabras
    document.getElementById("words").innerHTML = wordList;
}

// Renderizamos listado de palabras
function generateWordList(words,details){
    let html = "<ul>";
    let word;
    for (let i=0; i<words.length;i++){
        word = words[i];
        if(details){
            // Aplicamos identificador de word a li para posteriormente poder tacharla aplicando css
            html += '<li id="'+word.id+'"><strong>' + word.word + '</strong><br>' + word.description + '</li>';
        }else{
            // Aplicamos identificador de word a li para posteriormente poder tacharla aplicando css
            html += '<li id="'+word.id+'">' + word.word + '</li>';
        }

    }
    html += "</ul>";
    return html;
}

// Funci�n para mostrar palabras y descripciones
function renderWordDetails(){
    // Obtiene listado de palabras
    const wordList = generateWordList(gameWords,true);
    // Renderizamos listado de palabras
    document.getElementById("words").innerHTML = wordList;
}

// Funci�n para renderizar la sopa de letras
function renderGame(game){
    document.getElementById('game').innerHTML = game;
}