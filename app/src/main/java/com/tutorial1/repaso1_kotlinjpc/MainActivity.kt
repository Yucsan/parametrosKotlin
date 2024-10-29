package com.tutorial1.repaso1_kotlinjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutorial1.repaso1_kotlinjpc.ui.theme.Repaso1_KotlinJPCTheme

class MainActivity : ComponentActivity() {
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      enableEdgeToEdge()
      setContent {
         ViewContainer()
      }
   }
}

//Accion Principal con Preview
@Preview(showBackground = true)
@Composable
fun ViewContainer() {
   Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
      Main(
         name = "Android",
         modifier = Modifier.padding(innerPadding)
      )
   }
}

//clase
class EstadoScreen(){
   var screen by mutableStateOf("Screen")
}


@Composable
fun Main(name: String, modifier: Modifier = Modifier) {
   Botonera1();
}

@Composable
fun Botonera1() {
                  //variables de estado
   var muestraR: String by remember { mutableStateOf("incia") }
   var pantalla = remember { mutableStateOf("0") }
   var variableEstadoPantalla = remember {EstadoScreen()}

   Column() {
      Box(
      ) {
         Text(
            text = muestraR,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = 15.dp)
         )
      }
      Box(
      ){
         Text(
            text = pantalla.value, //mutableStateOf<String>
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = 15.dp)
         )
      }
      Box(
      ){
         Text(
            text = variableEstadoPantalla.screen, //mutableStateOf<String>
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
               .fillMaxWidth()
               .padding(vertical = 15.dp)
         )
      }

      Row() {

         Button(
            onClick = { Accion("Nuevo Texto") { muestraR = it } } //LAMBDA
         ) {
            Text("Cambiar Texto")
         }

         Button(
            onClick = { fn(pantalla) } //mutable State of
         ) {
            Text("Funcion 2")
         }

         Button(
            onClick = { funcionObj("Texto Objeto",variableEstadoPantalla) } //OBJETO
         ) {
            Text("fn Objeto")
         }


      }
   }
}
//parametros Lambda
fun Accion(s: String, ActualizaTexto: (String) -> Unit) {
   ActualizaTexto(s)  //actualizamos con funcion enviada por parametro
}
//MutableState<String>
fun fn(pantalla: MutableState<String>) {
   pantalla.value = "Texto desde fn" // Cambiamos el valor de `pantalla`
}
//Objeto
fun funcionObj(texto: String, estado: EstadoScreen){
   estado.screen= texto
}

