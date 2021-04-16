package entidade;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.Optional;

public class Chamada {

    private String numero;
    private DDD ddd;

    public String getNumero() {
        return numero;
    }

    public DDD getDdd() {
        return ddd;
    }

    public Chamada(String numero, ListaDDDs listaDDDs) throws Exception {
        this.ddd = procuraDDD(listaDDDs, numero);
        this.numero = formataNumero(numero);
    }

    private String formataNumero(String numero) throws ParseException {

        String numeroLimpo = limpaFormatacao(numero);
        String mascara;

        if(numeroLimpo.length() > 10) {
            mascara = "(##)#####-####";
        }
        else {
            mascara = "(##)####-####";
        }

        MaskFormatter maskFormatter= new MaskFormatter(mascara);
        maskFormatter.setValueContainsLiteralCharacters(false);
        return maskFormatter.valueToString(numeroLimpo) ;
    }

    private String limpaFormatacao(String numero) {
        return numero.replaceAll("[\\)\\(-]", "");
    }

    private DDD procuraDDD(ListaDDDs listaDDDs, String numero) throws Exception {

        String numeroLimpo = limpaFormatacao(numero);

        //regex para validar entrada de numero telefônico
        if (!numeroLimpo.matches("^[1-9]{2}([0-9]{9}|[0-9]{8})$")) {
            throw new Exception("Número telefônico inválido");
        }

        int codigoDDD = Integer.parseInt(numeroLimpo.substring(0,2));
        Optional<DDD> dddAchado = listaDDDs.getDdds().stream()
                .filter(ddd -> ddd.getCodigo() == codigoDDD)
                .findAny();

        if (!dddAchado.isPresent()) {
            throw new Exception("DDD informado é inválido !");
        }

        return dddAchado.get();
    }

    @Override
    public String toString() {
        return "{" +
                "numero='" + numero + '\'' +
                ", ddd=" + ddd +
                '}';
    }
}
