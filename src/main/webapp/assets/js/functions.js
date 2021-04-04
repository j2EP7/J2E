// Variables globales
// N�mero de palabras encontradas
wordsFound = 0;
// N�mero de palabras a encontrar
wordsToFind = 0;
// Inicializador de tiempo restante
countdown = undefined;

// Funci�n jugar
function play(){
    // petici�n ajax cuya respuesta sea insertar la sopa de letras en un div de esta p�gina
    // ser�a un post a un servlet
    // ese servlet generar�a la estructura de la sopa de letras completa y devuelve
    // en la respuesta se inserta la sopa de letras
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


// Evento click casilla letra
$( ".letra" ).click(function() {
    alert( "Click en letra" );
    // Definir un evento onclick asociado a la clase letra, que estar�a presente en las casillas de la estructura de la sopa de letras
    // Al hacer click comprueba si el elemento est� seleccionado o no y aplica una clase de selecci�n o no
    // Esa funci�n antes de finalizar ejecuta otra funci�n llamada checkWords
});


// Funci�n checkWords
function checkWords() {
    // Comprueba si las letras seleccionadas forman una palabra
    // En ese caso deshabilita las casillas seleccionadas que forman la palabra
    // Y contabiliza 1 palabra m�s encontrada de las X que hay que encontrar
    wordFound();
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
    if(wordsFound == wordsToFind){
        // Finalizar partida
        finishGame();
    }
}

// Funci�n mostrar victoria
function youWin(){
    // Muestra mensaje al usuario de que ha ganado
    const message = "�Enhorabuena! Has ganado.";
    renderMessage(message);
}

// Funci�n terminar la partida
function finishGame(){
    // Finaliza setInterval
    clearInterval(countdown);
    // Deshabilitamos casillero
    disableGame();
    // Comprueba n�mero de palabras encontradas
    if(wordsFound == wordsToFind){
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
function initGame(){
    // Recoge el n�mero de palabras a encontrar
    wordsToFind;
    // Promesa con petici�n AJAX
    // Si la promesa es positiva y wordsToFind > 0
    // Promesa Recoge el par�metro de segundos del juego
    const seconds = getParamTime();
    // Si la promesa es positiva y seconds es > 0
    // Inicia la cuenta regresiva
    initCountdown(seconds);
}

// Funci�n recoger par�metros del juego
function getParamTime(){
    const seconds = 0;
    // Petici�n ajax para obtener los segundos de la configuraci�n del juego
    return seconds;
}

// Funci�n para contar el tiempo restante
function initCountdown(seconds){
    // Cuenta regresiva con m�todo setInterval
    // El set interval se ejecuta cada 1000 milisegundos = 1 segundo
    // Vamos restando 1 segundo por ejecuci�n
    countdown = setInterval(function(){
        seconds = seconds - 1;
        // Muestra segundos restantes en pantalla
        renderTime(seconds);
        // Si llega a 0 el jugador pierde y se deshabilitan las casillas
        if(seconds == 0){
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

// Funci�n mostrar derrota
function gameOver(){
    // Muestra mensaje al usuario de que ha perdido
    const message = "�Vaya! No ha podido ser. En otra ocasi�n ser�.";
    renderMessage(message);
}