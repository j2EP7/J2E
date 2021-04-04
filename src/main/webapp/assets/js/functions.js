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

/* Eventos */

// Evento click casilla letra
$( ".letra" ).click(function() {
    alert( "Click en letra" );
    // Definir un evento onclick asociado a la clase letra, que estaría presente en las casillas de la estructura de la sopa de letras
    // Al hacer click comprueba si el elemento está seleccionado o no y aplica una clase de selección o no
    // Comprobamos letras seleccionadas
    checkLetters();
});

/* Funciones */

// Función jugar
function play(){
    // Recoge parámetros para el juego

    //Nos comunicamos con servlet por ajax
       //*------------------
    //----- AJAX JS

  /*  function processData(data) {
        document.getElementById("uno").innerHTML = data;
    }

    function handler() {
        if(this.status == 200 &&
            this.response != null)
            {
            // success!
            processData(this.response.textContent);
        }else if(this.status == 404){
            alert("404");
        }else if(this.response==null){
            alert("null");
        }
        else {
            // something went wrong
            alert("error handler");
        }
    }

    var client = new XMLHttpRequest();
    client.onload = handler;
    client.open("GET", "game");
    client.send()*/

    //-- AJAX JS FIN

    // https://stackoverflow.com/questions/43895473/promise-inside-promise-whats-the-correct-way-to-return-a-variable-from-the-chi/43895627
    // Promesa 1
    // Palabras
    gameWords;
    // Si se resuelve la Promesa 1 lanzamos la Promesa 2
    // Segundos
    gameSeconds;
    // Si se resuelve la Promesa 2 comprobamos
    // Si los valores de los parámetros son mayores a 0, inicializamos el juego
    if(gameWords > 0 && gameSeconds > 0){
        initGame();
    }else{
        document.getElementById('uno').innerText = "Aun quedan cosas por hacer";
        //demoAjaxServletRequest();
        //ajaxNumberWords();
        gameFromAjax();
    }
}

// Ejemplo petición Ajax a servlet
// petición post vía ajax cuya a un servlet para obtener la estructura de la sopa de letras
// sería un post a un servlet
// ese servlet generaría la estructura de la sopa de letras completa y devuelve
// en la respuesta se inserta la sopa de letras
function demoAjaxServletRequest(){
    jQuery.ajax({
        type: 'POST',
        url:"play",
        success: function(response) {
            if(response != '') {
                document.getElementById('game').innerHTML = response;
                // Inicializa el juego
                initGame();
            }else{
                alert("Algo ha ido mal");
            }
        }
    });
}

function gameFromAjax(){
    jQuery.ajax({
        type: 'POST',
        url:"renderGame.jsp",
        success: function(response) {
            if(response != '') {
                document.getElementById('game').innerHTML = response;
                // Inicializa el juego
            }else{
                alert("Algo ha ido mal");
            }
        }
    });
}

function ajaxNumberWords(){
    jQuery.ajax({
        type: 'POST',
        url:"game",
        success: function(response) {
            if(response != '') {
                document.getElementById('config').innerHTML = response;
                // Inicializa el juego
                //initGame();
            }else{
                alert("Algo ha ido mal");
            }
        }
    });
}

// Función para comprobar las letras seleccionadas
function checkLetters() {
    let newWordFound = false;
    // Comprueba si las letras seleccionadas forman una palabra
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
}

// Función para deshabilitar todas las casillas
function disableGame(){
    // Para que el jugador no pueda seguir interactuando con las casillas cuando la partida ha finalizado
}

// Función para mostrar mensaje
function renderMessage(message){
    // Recibe el parámetro de las funciones youWin y gameOver
    // Renderiza el mensaje en pantalla
    alert(message);
}

// Función iniciar juego
function initGame(){
    // Renderizamos tablero
    renderGame();
    // Renderizamos palabras a encontrar
    renderWords();
    // Inicia la cuenta regresiva
    initCountdown();
}

// Función para contar el tiempo restante
function initCountdown(seconds){
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
    console.log(time);
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
function renderWords(){

}

// Función para mostrar palabras y descripciones
function renderWordDetails(){

}

// Función para renderizar la sopa de letras
function renderGame(){


}