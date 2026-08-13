//RAKOTONIRINA TOLOJANAHARY Wilson
//N°25
//L2 GE-IT

package com.example.myevaluation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myevaluation.ui.theme.MyEvaluationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyEvaluationTheme {
                HabitScreen()
            }
        }
    }
}

@Composable
fun HabitScreen() {

    var vie by remember { mutableStateOf(50) }
    var exp by remember { mutableStateOf(12) }
    var mp by remember { mutableStateOf(15) }

    var mediter by remember { mutableStateOf(0) }
    var boireEau by remember { mutableStateOf(0) }
    var sport by remember { mutableStateOf(0) }
    var lire by remember { mutableStateOf(0) }
    var etudier by remember { mutableStateOf(0) }
    var dormirTot by remember { mutableStateOf(0) }
    var rangerChambre by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF10131A))
            .padding(16.dp)
    ) {

        // PROFILE + STATES
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF1A1F2B)
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // PHOTO PROFILE À GAUCHE
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(20.dp))

                // STATES À DROITE
                Column {

                    Text(
                        text = "PLAYER",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "❤️ Vie : $vie /100",
                        color = Color(0xFFFF5C6C),
                        fontSize = 16.sp
                    )

                    Text(
                        text = "⭐ EXP : $exp /50",
                        color = Color(0xFFB388FF),
                        fontSize = 16.sp
                    )

                    Text(
                        text = "🔵 MP : $mp /100",
                        color = Color(0xFF5DADE2),
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = "HABITUDES",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // MÉDITER
        HabitItem(
            nom = "Méditer",
            nombre = mediter,
            onPlus = {
                mediter += 1
                exp += 1
                mp += 2
            },
            onMoins = {
                mediter -= 1
                exp -= 1
                mp -= 2
            }
        )

        // BOIRE DE L'EAU
        HabitItem(
            nom = "Boire de l'eau",
            nombre = boireEau,
            onPlus = {
                boireEau += 1
                vie += 2
            },
            onMoins = {
                boireEau -= 1
                vie -= 2
            }
        )

        // SPORT
        HabitItem(
            nom = "Sport",
            nombre = sport,
            onPlus = {
                sport += 1
                vie += 2
                exp += 1
            },
            onMoins = {
                sport -= 1
                vie -= 2
                exp -= 1
            }
        )

        // LIRE
        HabitItem(
            nom = "Lire",
            nombre = lire,
            onPlus = {
                lire += 1
                exp += 2
            },
            onMoins = {
                lire -= 1
                exp -= 2
            }
        )

        // ÉTUDIER
        HabitItem(
            nom = "Étudier",
            nombre = etudier,
            onPlus = {
                etudier += 1
                exp += 3
            },
            onMoins = {
                etudier -= 1
                exp -= 3
            }
        )

        // DORMIR TÔT
        HabitItem(
            nom = "Dormir tôt",
            nombre = dormirTot,
            onPlus = {
                dormirTot += 1
                vie += 3
                mp += 2
            },
            onMoins = {
                dormirTot -= 1
                vie -= 3
                mp -= 2
            }
        )

        // RANGER LA CHAMBRE
        HabitItem(
            nom = "Ranger la chambre",
            nombre = rangerChambre,
            onPlus = {
                rangerChambre += 1
                vie += 1
                exp += 1
            },
            onMoins = {
                rangerChambre -= 1
                vie -= 1
                exp -= 1
            }
        )
    }
}

@Composable
fun HabitItem(
    nom: String,
    nombre: Int,
    onPlus: () -> Unit,
    onMoins: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1F2B)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = nom,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(1f)
            )

            // BOUTON -
            Button(
                onClick = onMoins,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF343A46)
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(42.dp)
            ) {
                Text(
                    text = "−",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }

            // COMPTEUR
            Text(
                text = "$nombre",
                color = Color(0xFF7CFCB2),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 14.dp)
            )

            // BOUTON +
            Button(
                onClick = onPlus,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5865F2)
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(42.dp)
            ) {
                Text(
                    text = "+",
                    color = Color.White,
                    fontSize = 20.sp
                )
            }
        }
    }
}