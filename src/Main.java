
import grammar.ContextFreeGrammar;
import grammar.FirstAndFollow;
import grammar.GrammarBuilder;
import java.util.List;
import java.util.ArrayList;
import model.symbol.Symbol;
import model.symbol.Terminal;
import parser.lr1.CanonicalCollection;
import parser.lr1.State;



import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ContextFreeGrammar cfg = GrammarBuilder.buildFromFile("C:\\Users\\Juandi Duque\\Documents\\NetBeansProjects\\lr1\\lr2\\src\\res\\grammar9.txt");
        GrammarBuilder.transformToExtendedGrammar(cfg);
        FirstAndFollow ff = new FirstAndFollow(cfg);
        
        Map<Symbol, Set<Terminal>> first = ff.getFirst1();
        Map<Symbol, Set<Terminal>> follow = ff.getFollow1();

        List<String> ejemploLista = new ArrayList<String>();
        
        System.out.println(first.toString());
        System.out.println(follow.toString());

        CanonicalCollection canCol = new CanonicalCollection(cfg);
        int i = 0;
        for (State s : canCol.getTheCanonicalCollection()) {
            System.out.println(Integer.toString(i) + ": " + s.toString());
            i++;
        }

    }
}
