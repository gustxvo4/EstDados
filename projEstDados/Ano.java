package projEstDados;

import java.util.ArrayList;
import java.util.List;

public class Ano {
    private int ano;
    private List<Categoria> categorias;

    public Ano(int ano) {
        this.ano = ano;
        this.categorias = new ArrayList<>();
    }

    public int getAno() {
        return ano;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void adicionarCategoria(Categoria categoria) {
        if (!categorias.contains(categoria)) {
            categorias.add(categoria);
        }
    }

    // Add this method to remove a category by name
    public boolean removerCategoria(String categoriaNome) {
        return categorias.removeIf(c -> c.getNome().equalsIgnoreCase(categoriaNome));
    }

    // Search for a category by name
    public Categoria buscarCategoria(String nomeCategoria) {
        for (Categoria categoria : categorias) {
            if (categoria.getNome().equalsIgnoreCase(nomeCategoria)) {
                return categoria;
            }
        }
        return null;
    }
}
