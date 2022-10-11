package com.ralonsoj.aad_2022.ut01.ex05.data.remote

import com.ralonsoj.aad_2022.ut01.ex05.domain.Adress
import com.ralonsoj.aad_2022.ut01.ex05.domain.Company
import com.ralonsoj.aad_2022.ut01.ex05.domain.Geo
import com.ralonsoj.aad_2022.ut01.ex05.domain.User

class UsersRemoteDataSource {
    fun getUsers(): List<User>{
        return mutableListOf(
            User(1,"Leanne Graham","Bret", "Sincere@april.biz",
                "1-770-736-8031 x56442","hildegard.org",
                Adress("Kulas Light","Apt. 556","Gwenborough","92998-3874"),
                Geo(-37.3159,81.1496),
                Company("Romaguera-Crona","Multi-layered client-server neural-net","harness real-time e-markets")
            ),
            User(2,"Ervin Howell","Antonette", "Shanna@melissa.tv",
                "010-692-6593 x09125","anastasia.net",
                Adress("Victor Plains","Suite 879","Wisokyburgh","90566-7771"),
                Geo(-43.9509,-34.4618),
                Company("Deckow-Crist","Proactive didactic contingency","synergize scalable supply-chains")
            ),
            User(3,"Clementine Bauch","Samantha", "Nathan@yesenia.net",
                "1-463-123-4447","ramiro.info",
                Adress("Douglas Extension","Suite 847","McKenziehaven","59590-4157"),
                Geo(-68.6102,-47.0653),
                Company("Romaguera-Jacobson","Face to face bifurcated interface","e-enable strategic applications")
            ),
        )
    }
}