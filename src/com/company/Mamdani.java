package com.company;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Mamdani {

        public double start(float sensor1, float sensor2, float sensor3, float fase){

            FIS fis = FIS.load("src/resource/HumidityMamdaniQoS.fcl", true);

            if (fis == null) {
                System.out.println("Can't load file");
                System.exit(1);
            }

            JFuzzyChart.get().chart(fis.getFunctionBlock("MamdaniQoSFewRules"));

            fis.setVariable("sensor1", sensor1);
            fis.setVariable("sensor2", sensor2);
            fis.setVariable("sensor3", sensor3);
            fis.setVariable("fase", fase);

            fis.evaluate();

            Variable umidade = fis.getFunctionBlock("MamdaniQoSFewRules").getVariable("umidade");
            JFuzzyChart.get().chart(umidade, umidade.getDefuzzifier(), true);

            System.out.println(umidade.getValue());
            return umidade.getValue();
        }

}
