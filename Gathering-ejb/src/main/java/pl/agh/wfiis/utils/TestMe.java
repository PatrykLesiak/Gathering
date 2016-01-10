package pl.agh.wfiis.utils;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class TestMe {

    public String test() {
        return "test ok";
    }
}
