enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val level: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val level: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add (usuario)
    }
}

fun main() {
    val ListaCont = listOf<ConteudoEducacional>(
    ConteudoEducacional("Java",60, Nivel.DIFICIL),
    ConteudoEducacional("JS",50, Nivel.INTERMEDIARIO),
    ConteudoEducacional("Python",45, Nivel.BASICO),
    )
    val Curso = Formacao ("Kotlin",ListaCont, Nivel.DIFICIL)

    Curso.matricular(Usuario("Filipe"))

    println("Curso ${Curso.nome} de nivel ${Curso.level}")
    Curso.inscritos.forEach {
        println("${it.nome} está matriculado no curso de ${Curso.nome}, ele vai aprender:")
    }
    Curso.conteudos.forEach{
        println(" ${it.nome}, com duração de ${it.duracao}  minutos, de nivel ${it.level}")
    }

}
