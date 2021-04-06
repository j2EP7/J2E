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
function checkLetters() {
    let newWordFound = false;
    // Comprueba si las letras seleccionadas forman una palabra
    newWordFound = lettersAreWord();
    if(newWordFound == true){
        // En ese caso deshabilita las casillas seleccionadas que forman la palabra
        disableSelectedLetters();
        // Y contabiliza 1 palabra m�s encontrada de las X que hay que encontrar
        wordFound();
    }
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
    disableGame();
    // Comprueba n�mero de palabras encontradas
    if(wordsFound == gameWords.length){
        // Si el jugador ha encontrado todas le decimos que ha ganado
        youWin();
    }else{
        // En caso contrario le decimos que ha perdido
        gameOver();
    }
}

// Funci�n para deshabilitar todas las casillas
function disableGame(){
    // Para que el jugador no pueda seguir interactuando con las casillas cuando la partida ha finalizado
}

// Funci�n para mostrar mensaje
function renderMessage(message){
    // Recibe el par�metro de las funciones youWin y gameOver
    // Renderiza el mensaje en pantalla
    alert(message);
}

// Funci�n iniciar juego
function initGame(juego){
    // Set n�mero de palabras a encontrar
    wordsFound = juego.words.length;
    // Set gameSeconds
    gameSeconds = parseInt(juego.seconds);
    // Renderizamos tablero
    renderGame(juego.casillero);
    // Renderizamos palabras a encontrar
    renderWords(juego.words);
    // Inicia la cuenta regresiva
    initCountdown();
    // Evento click letra
    // Evento click casilla letra
    $( ".letra" ).click(function() {
        alert( "Click en letra" );
        // Definir un evento onclick asociado a la clase letra, que estar�a presente en las casillas de la estructura de la sopa de letras
        // Al hacer click comprueba si el elemento est� seleccionado o no y aplica una clase de selecci�n o no
        // Comprobamos letras seleccionadas
        checkLetters();
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
    const message = "�Vaya! Se ha agotado el tiempo.";
    renderMessage(message);
}

// Funci�n para mostrar palabras a encontrar
function renderWords(words){
    console.log(words);
    // Obtiene listado de palabras
    const wordList = generateWordList(words);
    // Renderizamos listado de palabras
    document.getElementById("words").innerHTML = wordList;
}

// Renderizamos listado de palabras
function generateWordList(words){
    let html = "<ul>";
    for (let i=0; i<words.length;i++){
        html += "<li>" + words[i].word + "</li>";
    }
    html += "</ul>";
    return html;
}

// Funci�n para mostrar palabras y descripciones
function renderWordDetails(wordList){

}

// Funci�n para renderizar la sopa de letras
function renderGame(game){
    document.getElementById('game').innerHTML = game;
}