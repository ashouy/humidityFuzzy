package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Main {

    public static void main(String[] args) {
        FIS fis = FIS.load("src/resource/HumidityMamdaniQoS.fcl",true);

        if (fis == null){
            System.out.println("Can't load file");
            System.exit(1);
        }

        JFuzzyChart.get().chart(fis.getFunctionBlock("MamdaniQoSFewRules"));

        fis.setVariable("sensor1",400);
        fis.setVariable("sensor2",400);
        fis.setVariable("sensor3",400);
        fis.setVariable("fase",1);

        fis.evaluate();

        Variable umidade = fis.getFunctionBlock("MamdaniQoSFewRules").getVariable("umidade");
        JFuzzyChart.get().chart(umidade,umidade.getDefuzzifier(),true);

        System.out.println(umidade.getValue());


    }
}
