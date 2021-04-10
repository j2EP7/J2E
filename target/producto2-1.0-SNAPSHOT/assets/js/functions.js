/* Variables globales */

// Número de palabras encontradas
wordsFound = 0;
// Array con la información de las palabras
// Cada elemento es un objeto (Word) con sus propiedades (id, word y description) y una propiedad extra que es un array, el cual contiene las ids de las posiciones de las letras en el tablero
gameWords = [];
// Segundos del juego
gameSeconds = 0;
// Inicializador de tiempo restante
countdown = undefined;


/* Funciones */

// Función jugar


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
    // Recoge parámetros para el juego
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

// Ejemplo petición Ajax a servlet
// petición post vía ajax cuya a un servlet para obtener la estructura de la sopa de letras
// sería un post a un servlet
// ese servlet generaría la estructura de la sopa de letras completa y devuelve
// en la respuesta se inserta la sopa de letras
function demoAjaxServletRequest(){

}

// Función para comprobar las letras seleccionadas
function checkLetters(letraId) {
    let newWordFound = false;
    // Seleccionar todas las letras seleccionadas (clase soup)
    let selectedLetters = jQuery(".soup");
    // Recorrer todas las palabras (words) y verificar si la posición de esas letras forman una palabra
    for (let i = 0; i < selectedLetters.length; i++){
        let letter = selectedLetters[i];
        let row = "";
        let col = "";
    }
    // Solo daremos por válido si esa palabra formada tiene la misma cantidad de letras que el total de letras seleccionadas en la sopa de letras
    newWordFound = lettersAreWord();
    if(newWordFound == true){
        // En ese caso deshabilita las casillas seleccionadas que forman la palabra
        disableSelectedLetters();
        // Y contabiliza 1 palabra más encontrada de las X que hay que encontrar
        wordFound();
    }
}


// Función para comprobar si las letras seleccionadas forman una palabra
function lettersAreWord(){
    // Obtenemos las letras seleccionadas
    // Recorremos y obtenemos el identificador del casillero
    // Comparamos los identificadores del casillero con los identificadores asignados a las palabras
    // Si hay match devolvemos true
    // En caso contrario false
}

// Función para desactivar letras seleccionadas del tablero
function disableSelectedLetters(){
    // Desactiva las letras que están actualmente marcadas como seleccionadas
}

// Función contabilizar palabra encontrada
function wordFound(){
    // Aumenta en 1 el contador de palabras encontradas
    wordsFound = wordsFound + 1;
    checkWin();
}

// Función checkWin
function checkWin(){
    // Comprueba si ya están encontradas todas las palabras
    if(wordsFound == gameWords.length){
        // Finalizar partida
        finishGame();
    }
}

// Función mostrar victoria
function youWin(){
    // Muestra mensaje al usuario de que ha ganado
    const message = "¡Enhorabuena! Has ganado.";
    renderMessage(message);
    // Renderizamos información de palabras
    renderWordDetails();
}

// Función terminar la partida
function finishGame(){
    // Finaliza setInterval
    clearInterval(countdown);
    // Deshabilitamos casillero
    disableGame();
    // Comprueba número de palabras encontradas
    if(wordsFound == gameWords.length){
        // Si el jugador ha encontrado todas le decimos que ha ganado
        youWin();
    }else{
        // En caso contrario le decimos que ha perdido
        gameOver();
    }
    // Habilitamos el botón para que pueda volver a jugar
    enablePlayButton();
}

// Función para deshabilitar todas las casillas
function disableGame(){
    // Para que el jugador no pueda seguir interactuando con las casillas cuando la partida ha finalizado
    jQuery("#game").addClass("gameOff");
}

// Función para mostrar mensaje
function renderMessage(message){
    // Recibe el parámetro de las funciones youWin y gameOver
    // Renderiza el mensaje en pantalla
    alert(message);
}

function disablePlayButton(){
    // Deshabilitar el botón jugar
    document.getElementById("play").disabled = true;
}

function enablePlayButton(){
    // Deshabilitar el botón jugar
    document.getElementById("play").disabled = false;
}

// Función iniciar juego
function initGame(juego){
    // Palabras con letras y posiciones
    gameWords = juego.words;
    // Set número de palabras a encontrar
    wordsFound = juego.words.length;
    // Set gameSeconds
    gameSeconds = parseInt(juego.seconds);
    // Renderizamos tablero
    renderGame(juego.casillero);
    // Deshabilitar botón jugar
    disablePlayButton();
    // Renderizamos palabras a encontrar
    renderWords(juego.words);
    // Inicia la cuenta regresiva
    initCountdown();
    // Evento click letra
    // Evento click casilla letra
    $( ".letra" ).click(function(e) {
        console.log(e.target);
        let letraId = e.target.id;
        let letraPosicion = letraId.split("-");
        // Obtenemos posiciones de la letra clicada
        let row = letraPosicion[0];
        let col = letraPosicion[1];
        console.log("row "+row+" col "+col);
        // Comprobamos si está activada o no
        jQuery('#' + letraId).toggleClass('soup');
        // Definir un evento onclick asociado a la clase letra, que estaría presente en las casillas de la estructura de la sopa de letras
        // Al hacer click comprueba si el elemento está seleccionado o no y aplica una clase de selección o no
        // Esa clase define el estilo css, y además nos sirve para saber si la próxima vez que se clique hay que activarla o desactivarla
        // Comprobamos letras seleccionadas
        checkLetters(letraId);
    });
}

// Función para contar el tiempo restante
function initCountdown(){
    // Cuenta regresiva con método setInterval
    // El set interval se ejecuta cada 1000 milisegundos = 1 segundo
    // Vamos restando 1 segundo por ejecución
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

// Función mostrar derrota
function gameOver(){
    // Muestra mensaje al usuario de que ha perdido
    const message = "¡Vaya! Se ha agotado el tiempo.";
    renderMessage(message);
}

// Función para mostrar palabras a encontrar
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

// Función para mostrar palabras y descripciones
function renderWordDetails(){

}

// Función para renderizar la sopa de letras
function renderGame(game){
    document.getElementById('game').innerHTML = game;
}