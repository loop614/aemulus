/*
592. Fraction Addition and Subtraction
Medium
Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.
The final result should be an irreducible fraction.
If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
 */

import java.util.HashMap;

public class Leetcode592 {

    public static void main(String[] args) {
        Solution592 sol = new Solution592();
        String res;

        res = sol.fractionAddition("1/3-1/2");
        System.out.println(res);
        System.out.println("-1/6".equals(res));

        res = sol.fractionAddition("1/2-1/3");
        System.out.println(res);
        System.out.println("1/6".equals(res));

        res = sol.fractionAddition("7/16+1/16");
        System.out.println(res);
        System.out.println("1/2".equals(res));

        res = sol.fractionAddition("1/2-1/2+1/2-1/2+1/2");
        System.out.println(res);
        System.out.println("1/2".equals(res));

        res = sol.fractionAddition("1/3-1/2");
        System.out.println(res);
        System.out.println("-1/6".equals(res));

        res = sol.fractionAddition("-1/2+1/2");
        System.out.println(res);
        System.out.println("0/1".equals(res));

        res = sol.fractionAddition("1/2-1/200");
        System.out.println(res);
        System.out.println("99/200".equals(res));

        res = sol.fractionAddition("-1/2+1/2+1/3");
        System.out.println(res);
        System.out.println("1/3".equals(res));
    }
}

class Solution592 {

    private static HashMap<String, Integer> leastCommonMultipleCache = new HashMap<>();

    public String fractionAddition(String expression) {
        char[] exp = expression.toCharArray();
        String res = "0/1";
        StringBuilder oneOp = new StringBuilder();
        int fs = 0;

        for (int i = 0; i < exp.length; ++i) {
            char letter = exp[i];

            if (letter == 47) {
                fs++;
            }
            if (i == exp.length - 1) {
                oneOp.append(letter);
                res = twoFractionsAddition(res, oneOp.toString());
                break;
            }

            if ((fs == 1 && (letter == 43 || letter == 45))) {
                res = twoFractionsAddition(res, oneOp.toString());
                fs = 0;
                oneOp = new StringBuilder();
            }
            oneOp.append(letter);
        }

        return res;
    }

    private String twoFractionsAddition(String res, String oneOp) {
        char[] resc = res.toCharArray();
        char[] one = oneOp.toCharArray();

        // 0/1 or +0/1, return other
        if (resc[0] == 48 || (resc[0] == 43 && resc[1] == 48)) {
            if (one[0] == 43) {
                return oneOp.substring(1);
            }
            return oneOp;
        }
        if (one[0] == 48 || (one[0] == 43 && one[1] == 48)) {
            if (resc[0] == 43) {
                return res.substring(1);
            }
            return res;
        }

        if ( // -1/2+1/2 or 1/2-1/2
                ((resc[0] == 45 && one[0] == 43) || (isCharNumeric(resc[0]) && one[0] == 45)) && areFractionsSame(one, resc)) {
            return "0/1";
        }

        return addFractions(resc, one);
    }

    private String addFractions(char[] l, char[] r) {
        StringBuilder la = new StringBuilder();
        StringBuilder lb = new StringBuilder();
        StringBuilder ra = new StringBuilder();
        StringBuilder rb = new StringBuilder();

        boolean hit = false;
        for (char i : l) {
            if (i == 47) {
                hit = true;
                continue;
            }
            if (hit) {
                lb.append(i);
            } else {
                la.append(i);
            }
        }
        hit = false;
        for (char i : r) {
            if (i == 47) {
                hit = true;
                continue;
            }
            if (hit) {
                rb.append(i);
            } else {
                ra.append(i);
            }
        }
        int lai = Integer.parseInt(la.toString());
        int lbi = Integer.parseInt(lb.toString());
        int rai = Integer.parseInt(ra.toString());
        int rbi = Integer.parseInt(rb.toString());
        int com = leastCommonMultiple(lbi, rbi);

        int nlai = (com / lbi) * lai;
        int nrai = (com / rbi) * rai;
        int resa = nlai + nrai;
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        int p = primes.length - 1;
        while ((Math.abs(resa) < primes[p] || com < primes[p]) && p > 0) {
            p--;
        }
        while (p >= 0) {
            if (resa % primes[p] == 0 && com % primes[p] == 0) {
                resa /= primes[p];
                com /= primes[p];
            } else {
                p--;
            }
        }

        return String.valueOf(resa) + "/" + String.valueOf(com);
    }

    private boolean areFractionsSame(char[] l, char[] r) {
        // -1/2  +1/2
        //  1/2  -1/2
        int pivotl = 0;
        int pivotr = 0;
        while (l[pivotl] == 43 || l[pivotl] == 45) {
            pivotl++;
        }
        while (r[pivotr] == 43 || r[pivotr] == 45) {
            pivotr++;
        }

        if (l.length - pivotl != r.length - pivotr) {
            return false;
        }

        boolean same = true;
        while (pivotl < l.length) {
            if (l[pivotl] != r[pivotr]) {
                same = false;
                break;
            }
            pivotl++;
            pivotr++;
        }

        return same;
    }

    private int leastCommonMultiple(int l, int r) {
        boolean biggerl = false;
        if (l == r) {
            return l;
        } else if (l > r) {
            biggerl = true;
        }
        String cacheKey = biggerl ? String.valueOf(l) + String.valueOf(r) : String.valueOf(r) + String.valueOf(l);
        Integer lhm = leastCommonMultipleCache.get(cacheKey);
        if (lhm != null) {
            return lhm;
        }

        if (biggerl && l % r == 0) {
            leastCommonMultipleCache.put(cacheKey, l);
            return l;
        }
        else if (!biggerl && r % l == 0) {
            leastCommonMultipleCache.put(cacheKey, r);
            return r;
        }
        int com;
        int pl = l;
        int pr = r;
        while (true) {
            if (pl < pr) {
                pl = pl + l;
            } else if (pr < pl) {
                pr = pr + r;
            } else {
                com = pr;
                break;
            }
        }
        leastCommonMultipleCache.put(cacheKey, com);

        return com;
    }

    private boolean isCharNumeric(char letter) {
        return letter > 47 && letter < 58;
    }
}
