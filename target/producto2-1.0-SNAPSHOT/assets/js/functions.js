// Función jugar
function play(){
    // petición ajax cuya respuesta sea insertar la sopa de letras en un div de esta página
    // sería un post a un servlet
    // ese servlet generaría la estructura de la sopa de letras completa y devuelve
    // en la respuesta se inserta la sopa de letras
    jQuery.ajax({
        type: 'POST',
        url:"play",
        success: function(response) {
            if(response != '') {
                document.getElementById('game').innerHTML = response;
            }else{
                alert("Algo ha ido mal");
            }
        }
    });
}


// Evento click casilla letra
$( ".letra" ).click(function() {
    alert( "Click en letra" );
    // Definir un evento onclick asociado a la clase letra, que estaría presente en las casillas de la estructura de la sopa de letras
    // Al hacer click comprueba si el elemento está seleccionado o no y aplica una clase de selección o no
    // Esa función antes de finalizar ejecuta otra función llamada checkWords
});


// Función checkWords
function checkWords() {
    // Comprueba si están seleccionadas las letras que forman una palabra
    // En ese caso deshabilita las casillas seleccionadas que forman la palabra
    // Y contabiliza 1 palabra más encontrada de las X que hay que encontrar
    // Esta función antes de finalizar ejecuta otra función llamada checkWin
}

// Función checkWin
function checkWin(){
    // Comprueba si ya están encontradas todas las palabras
    // En ese caso decirle al jugador que ha ganado y deshabilitar todas las casillas
}
