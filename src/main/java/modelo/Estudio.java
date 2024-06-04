package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Estudio {

	
	public Estudio(int id, String nome, int musicasGravadas, double taxaHoras) {
		super();
		this.id = id;
		this.nome = nome;
		this.musicasGravadas = musicasGravadas;
		this.taxaHoras = taxaHoras;
		
	}
	
	private int id;
	private String nome;
	private int musicasGravadas;
	private double taxaHoras;
	
	
	public Estudio(String nome, int musicasGravadas, double taxaHoras) {
		
		this.nome = nome;
		this.musicasGravadas = musicasGravadas;
		this.taxaHoras = taxaHoras;
		
		
	}
	public Estudio() {}
	
	public String mixarMusica() {
        if (musicasGravadas > 0) {
            return "***mixando uma musica. total de musicas gravadas: " +musicasGravadas + "***";
            
        } else {
            return "***nenhuma musica gravada disponivel para mixagem.***";
        }
    }

public String calcularFaturamento() {
		double faturamento = taxaHoras * 44.50;
		String result = String.format("%.2f", faturamento);
        return "***faturamento total de: R$" +result + "***";
        
        
    }

public String agendarSessao() {
        LocalDate hoje = LocalDate.now();
        LocalDate dataSessao = hoje.plusDays(15);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataSessao.format(formatter);
        return "***sessao agendada para " + dataFormatada + "***";
    }


	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}
	
	
	

	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public int getMusicasGravadas() {
		return musicasGravadas;
	}




	public void setMusicasGravadas(int musicasGravadas) {
		this.musicasGravadas = musicasGravadas;
	}




	public double getTaxaHoras() {
		return taxaHoras;
	}




	public void setTaxaHoras(double taxaHoras) {
		this.taxaHoras = taxaHoras;
	}
	
	
	
}


