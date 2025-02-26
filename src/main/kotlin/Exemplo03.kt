// Classe abstrata representando um animal genérico, com nome e idade
abstract class Animal(val nome: String, val idade: Int) {
    // Metodo abstrato que será implementado nas subclasses para emitir som
    abstract fun emitirSom(): String
}

// Interface que define o comportamento de amamentação
interface Amamentador {
    // Metodo que será implementado por classes que podem amamentar
    fun amamentar()
}

// Classe Cachorro que herda de Animal e implementa a interface Amamentador
class Cachorro(nome: String, idade: Int) : Animal(nome, idade), Amamentador {
    // Implementação do metodo emitirSom, retornando o som típico de um cachorro
    override fun emitirSom(): String {
        return "Au au"
    }

    // Implementação do metodo amamentar, com mensagem indicando o processo de amamentação
    override fun amamentar() {
        println("$nome está amamentando seus filhotes.")
    }
}

// Classe Gato que herda de Animal e implementa a interface Amamentador
class Gato(nome: String, idade: Int) : Animal(nome, idade), Amamentador {
    // Implementação do metodo emitirSom, retornando o som típico de um gato
    override fun emitirSom(): String {
        return "Miau"
    }

    // Implementação do metodo amamentar, com mensagem indicando o processo de amamentação
    override fun amamentar() {
        println("$nome está amamentando seus filhotes.")
    }
}

// Classe Vaca que herda de Animal e implementa a interface Amamentador
class Vaca(nome: String, idade: Int) : Animal(nome, idade), Amamentador {
    // Implementação do metodo emitirSom, retornando o som típico de uma vaca
    override fun emitirSom(): String {
        return "Muuu"
    }

    // Implementação do metodo amamentar, com mensagem indicando o processo de ordenha/amamentação
    override fun amamentar() {
        println("$nome está sendo ordenhada/amamentando.")
    }
}

// Classe Zoologico que gerencia uma coleção de animais
class Zoologico {
    // Lista mutável para armazenar os animais do zoológico
    private val animais: MutableList<Animal> = mutableListOf()

    // Metodo para adicionar um animal à lista e imprimir uma mensagem de confirmação
    fun adicionarAnimal(animal: Animal) {
        animais.add(animal)
        println("${animal.nome} foi adicionado ao zoológico.")
    }

    // Metodo para listar todos os animais no zoológico, mostrando o som que eles emitem
    fun listarAnimais() {
        println("Animais no zoológico:")
        animais.forEach { println("${it.nome} (${it.idade} anos): ${it.emitirSom()}") }
    }

    // Metodo para filtrar animais que implementam a interface Amamentador e chamar o metodo amamentar
    fun amamentarMamiferos() {
        println("Amamentando os mamíferos:")
        animais.filterIsInstance<Amamentador>().forEach { it.amamentar() }
    }
}

fun main() { // Função principal
    // Instância do Zoologico
    val zoologico = Zoologico()

    // Adicionando animais ao zoológico
    zoologico.adicionarAnimal(Cachorro("Rex", 3))
    zoologico.adicionarAnimal(Gato("Mia", 2))
    zoologico.adicionarAnimal(Vaca("Mimosa", 5))

    // Listando todos os animais presentes no zoológico
    zoologico.listarAnimais()

    println()
    // Amamentando todos os mamíferos do zoológico
    zoologico.amamentarMamiferos()
}