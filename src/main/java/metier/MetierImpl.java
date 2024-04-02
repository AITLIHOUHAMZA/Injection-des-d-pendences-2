package metier;

import dao.IDao;
import ext.DaoImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class MetierImpl implements IMetier {
    // couplage faible
    @Autowired
    @Qualifier("dao")
    private IDao dao;

    public MetierImpl(DaoImpl2 dao) {
    }


    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
/* Injecter dans l'interface dao un object d'une classe qui implemente l'interface IDao */
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
