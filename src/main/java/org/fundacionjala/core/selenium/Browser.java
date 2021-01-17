package org.fundacionjala.core.selenium;

public class Browser {
    private String name;
    private String implicitWaitingSeconds;
    private String explicitWaitingSeconds;
    private String sleepingTimeMills;

    /**
     * Get browser's name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get browser's implicitWaitingSeconds.
     * @return implicitWaitingSeconds
     */
    public String getImplicitWaitingSeconds() {
        return implicitWaitingSeconds;
    }

    /**
     * Get browser's explicitWaitingSeconds.
     * @return explicitWaitingSeconds
     */
    public String getExplicitWaitingSeconds() {
        return explicitWaitingSeconds;
    }

    /**
     * Get browser's sleepingTimeMills.
     * @return sleepingTimeMills
     */
    public String getSleepingTimeMills() {
        return sleepingTimeMills;
    }
}
