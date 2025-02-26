data class Livro(
    val titulo: String,
    val autor: String,
    val anoPublicacao: Int
) // Representa um livro com título, autor e ano de publicação 

class Biblioteca { // Classe que representa uma biblioteca, que armazena uma lista de livros 
    private val livros: MutableList<Livro> = mutableListOf() // Lista mutável para armazenar os livros da biblioteca 

    fun adicionarLivro(livro: Livro) { // Adiciona um livro à lista de livros da biblioteca 
        livros.add(livro) // Adiciona o livro à lista
        println("Livro '${livro.titulo}' adicionado à biblioteca.") // Imprime mensagem confirmando a adição
    }

    fun removerLivro(titulo: String) { // Remove um livro da biblioteca pelo título 
        val livroRemovido =
            livros.removeIf { it.titulo == titulo } // Verifica e remove o livro com o título correspondente
        if (livroRemovido) { // Se o livro foi removido...
            println("Livro '$titulo' removido da biblioteca.") // Confirma a remoção
        } else { // Caso contrário, se o livro não for encontrado...
            println("Livro '$titulo' não encontrado na biblioteca.") // Informa que o livro não foi encontrado
        }
    }

    fun buscarLivrosPorAutor(autor: String): List<Livro> { // Busca livros pelo autor 
        return livros.filter { it.autor == autor } // Retorna uma lista de livros que correspondem ao autor informado
    }

    fun listarLivros() { // Lista todos os livros na biblioteca 
        if (livros.isEmpty()) { // Se a lista estiver vazia...
            println("A biblioteca está vazia.") // Informa que não há livros
        } else { // Caso contrário...
            println("Livros na biblioteca:") // Exibe os livros um por um
            livros.forEach { println("${it.titulo} - ${it.autor} (${it.anoPublicacao})") } // Imprime os detalhes do livro
        }
    }
}

fun main() { // Função principal 
    val biblioteca = Biblioteca() // Cria uma instância da classe Biblioteca

    // Adiciona livros à biblioteca 
    biblioteca.adicionarLivro(Livro("A Arte da Guerra", "Sun Tzu", -500)) // Livro com título, autor e ano de publicação
    biblioteca.adicionarLivro(Livro("Dom Casmurro", "Machado de Assis", 1899))
    biblioteca.adicionarLivro(Livro("1984", "George Orwell", 1949))
    biblioteca.adicionarLivro(Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943))
    biblioteca.adicionarLivro(Livro("Cem Anos de Solidão", "Gabriel García Márquez", 1967))
    biblioteca.adicionarLivro(Livro("Admirável Mundo Novo", "Aldous Huxley", 1932))

    biblioteca.listarLivros() // Lista todos os livros na biblioteca

    println("\nBuscando livros por autor 'Machado de Assis':") // Imprime mensagem informando a busca
    val livrosMachado = biblioteca.buscarLivrosPorAutor("Machado de Assis") // Busca os livros pelo autor 
    livrosMachado.forEach { println(it.titulo) } // Imprime os títulos encontrados

    biblioteca.removerLivro("1984") // Remove o livro com título "1984" 

    println("\nLivros após remover '1984':") // Lista os livros restantes após a remoção
    biblioteca.listarLivros()
}