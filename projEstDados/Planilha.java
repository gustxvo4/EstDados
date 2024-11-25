package projEstDados;

import java.util.ArrayList;
import java.util.List;

public class Planilha {
    private List<Ano> anos;

    public Planilha() {
        this.anos = new ArrayList<>();
    }

    public void adicionarAno(int ano) {
        if (buscarAno(ano) == null) {
            anos.add(new Ano(ano));
        } else {
            System.out.println("Ano já existe.");
        }
    }

    public boolean removerAno(int ano) {
        Ano anoEncontrado = buscarAno(ano);
        if (anoEncontrado != null) {
            return anos.remove(anoEncontrado);
        }
        return false;
    }

    public Ano buscarAno(int ano) {
        for (Ano a : anos) {
            if (a.getAno() == ano) {
                return a;
            }
        }
        return null;
    }

    public Categoria buscarCategoria(Ano ano, String nomeCategoria) {
        if (ano != null) {
            for (Categoria c : ano.getCategorias()) {
                if (c.getNome().equalsIgnoreCase(nomeCategoria)) {
                    return c;
                }
            }
        }
        return null;
    }

    public boolean removerCategoria(Ano ano, String nomeCategoria) {
        Categoria categoria = buscarCategoria(ano, nomeCategoria);
        if (categoria != null) {
            return ano.getCategorias().remove(categoria);
        }
        return false;
    }

    public int getNumAnos() {
        return anos.size();
    }

    public Ano getAno(int index) {
        if (index >= 0 && index < anos.size()) {
            return anos.get(index);
        }
        return null;
    }

    public void adicionarCategoriaAoAno() {
        // Placeholder: Implement logic to add category in the console
        System.out.println("Adicionar categoria ao ano ainda não implementado no console.");
    }

    public void adicionarRamo() {
        // Placeholder: Implement logic to add branch in the console
        System.out.println("Adicionar ramo ainda não implementado no console.");
    }

    public void removerCategoriaDeAno() {
        // Placeholder: Implement logic to remove category in the console
        System.out.println("Remover categoria de ano ainda não implementado no console.");
    }

    public void removerRamoDeCategoria() {
        // Placeholder: Implement logic to remove branch in the console
        System.out.println("Remover ramo de categoria ainda não implementado no console.");
    }

    public void exibirPlanilha() {
        if (anos.isEmpty()) {
            System.out.println("Nenhum ano registrado.");
        } else {
            for (Ano ano : anos) {
                System.out.println("Ano: " + ano.getAno());
                for (Categoria categoria : ano.getCategorias()) {
                    System.out.println("  Categoria: " + categoria.getNome() + " - Valor Total: R$ " + categoria.getValor());
                    for (Categoria ramo : categoria.getFilhos()) {
                        System.out.println("    Ramo: " + ramo.getNome() + " - R$ " + ramo.getValor());
                    }
                }
            }
        }
    }
}
