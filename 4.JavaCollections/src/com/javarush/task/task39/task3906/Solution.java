package com.javarush.task.task39.task3906;

/* 
Интерфейсы нас спасут!
*/
public class Solution {
    public static void main(String[] args) {
        Switchable securitySystem = new SecuritySystem();
        Switchable lightbulb = new LightBulb();

        ElectricPowerSwitch electricPowerSwitchSecuritySystem = new ElectricPowerSwitch(securitySystem);
        ElectricPowerSwitch electricPowerSwitchLightBulb = new ElectricPowerSwitch(lightbulb);

        electricPowerSwitchSecuritySystem.press();
        electricPowerSwitchLightBulb.press();
        electricPowerSwitchSecuritySystem.press();
        electricPowerSwitchLightBulb.press();
    }
}
