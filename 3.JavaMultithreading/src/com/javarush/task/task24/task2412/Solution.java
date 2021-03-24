package com.javarush.task.task24.task2412;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Знания - сила!
*/
public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"change {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            testArgs[5] = dateFormat.format(date);
            String pattern = null;
            if ((double) testArgs[2] == 0 && (double) testArgs[3] == 0) {
                pattern = "{0} {1} | {5} change {4}";
            }
            else {
                pattern = "{0} {1} | {5} open {2} and last {3}";
            }
            System.out.println(pattform.format(pattern, testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        Collections.sort(list, new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                String name1 = ((String) stock1.get("name"));
                String name2 = ((String) stock2.get("name"));
                int compareResult = name1.compareTo(name2);
                if (compareResult != 0) {
                    return compareResult;
                } else {
                    Date date1 = (Date) stock1.get("date");
                    Date date2 = (Date) stock2.get("date");
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
                    int dCompResult = df.format(date1).compareTo(df.format(date2));
                    if (dCompResult != 0) {
                        return (-dCompResult);
                    } else {
                        double open;
                        double last;
                        double profit1;
                        double profit2;
                        if (stock1.containsKey("open")) {
                            open = ((double) stock1.get("open"));
                            last = ((double) stock1.get("last"));
                            profit1 = last - open;
                        } else {
                            profit1 = ((double) stock1.get("change"));
                        }
                        if (stock2.containsKey("open")) {
                            open = ((double) stock2.get("open"));
                            last = ((double) stock2.get("last"));
                            profit2 = last - open;
                        } else {
                            profit2 = ((double) stock2.get("change"));
                        }
                        return (-Double.compare(profit1, profit2));
                    }
                }
            }
        });

        //        Collections.sort(list, new Comparator<Stock>() {
//            public int compare(Stock stock1, Stock stock2) {
//                String stock1Name = (String) stock1.get("name");
//                String stock2Name = (String) stock2.get("name");
//                if (stock1Name.compareTo(stock2Name) > 0) {
//                    return 1;
//                }
//                else if (stock1Name.compareTo(stock2Name) < 0) {
//                    return -1;
//                }
//                else {
//                    Date date1 = (Date) stock1.get("date");
//                    Date date2 = (Date) stock2.get("date");
//                    if (date1.compareTo(date2) > 0) {
//                        return -1;
//                    }
//                    else if (date1.compareTo(date2) < 0) {
//                        return 1;
//                    }
//                    else {
//                        double profitStock1 = (double) stock1.get("open") - (double) stock1.get("last");
//                        double profitStock2 = (double) stock2.get("open") - (double) stock2.get("last");
//
//                        if (profitStock1 > profitStock2) {
//                            return 1;
//                        }
//                        else if (profitStock1 < profitStock2) {
//                            return -1;
//                        }
//                        else {
////                            double changeStock1 = (double) stock1.get("change");
////                            double changeStock2 = (double) stock2.get("change");
////
////                            if (changeStock1 > changeStock2) {
////                                return -1;
////                            }
////                            else if (changeStock1 < changeStock2) {
////                                return 1;
////                            }
////                            else {
////                                return 0;
////                            }
//                            return 0;
//                        }
//                    }
//                }
//            }
//        });
    }

    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            //put("date", getRandomDate(2020));
            put("date", new Date());
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        //Added for test
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 518.6));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 514.6));
        //Added for test
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));

        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

