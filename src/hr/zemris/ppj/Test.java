package hr.zemris.ppj;

import hr.zemris.ppj.commons.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
    public Test() {
        HashMap<String, HashMap<Pair<Integer, Character>, ArrayList<Integer>>> transitions = new HashMap<>() {
            {
                put("S_a", new HashMap<>() {
                    {
                        put(new Pair(32, "a"), new ArrayList<>() {{
                            add(33);
                        }});
                        put(new Pair(34, ")"), new ArrayList<>() {{
                            add(35);
                        }});
                        put(new Pair(59, "$"), new ArrayList<>() {{
                            add(60);
                        }});
                        put(new Pair(24, "b"), new ArrayList<>() {{
                            add(25);
                        }});
                        put(new Pair(117, "$"), new ArrayList<>() {{
                            add(95);
                        }});
                        put(new Pair(51, "$"), new ArrayList<>() {{
                            add(52);
                        }});
                        put(new Pair(140, "b"), new ArrayList<>() {{
                            add(141);
                        }});
                        put(new Pair(109, "$"), new ArrayList<>() {{
                            add(110);
                        }});
                        put(new Pair(43, "$"), new ArrayList<>() {{
                            add(41);
                        }});
                        put(new Pair(101, "$"), new ArrayList<>() {{
                            add(99);
                        }});
                        put(new Pair(35, "$"), new ArrayList<>() {{
                            add(31);
                        }});
                        put(new Pair(93, "$"), new ArrayList<>() {{
                            add(91);
                        }});
                        put(new Pair(60, "$"), new ArrayList<>() {{
                            add(62);
                            add(66);
                            add(70);
                        }});
                        put(new Pair(27, "$"), new ArrayList<>() {{
                            add(28);
                        }});
                        put(new Pair(58, "c"), new ArrayList<>() {{
                            add(59);
                        }});
                        put(new Pair(118, "$"), new ArrayList<>() {{
                            add(120);
                        }});
                        put(new Pair(85, "$"), new ArrayList<>() {{
                            add(83);
                        }});
                        put(new Pair(116, "c"), new ArrayList<>() {{
                            add(117);
                        }});
                        put(new Pair(19, "$"), new ArrayList<>() {{
                            add(20);
                        }});
                        put(new Pair(52, ")"), new ArrayList<>() {{
                            add(53);
                        }});
                        put(new Pair(143, "$"), new ArrayList<>() {{
                            add(145);
                            add(142);
                        }});
                        put(new Pair(77, "$"), new ArrayList<>() {{
                            add(78);
                        }});
                        put(new Pair(44, "$"), new ArrayList<>() {{
                            add(46);
                        }});
                        put(new Pair(11, "$"), new ArrayList<>() {{
                            add(9);
                        }});
                        put(new Pair(110, ")"), new ArrayList<>() {{
                            add(111);
                        }});
                        put(new Pair(135, "$"), new ArrayList<>() {{
                            add(136);
                        }});
                        put(new Pair(102, "$"), new ArrayList<>() {{
                            add(104);
                        }});
                        put(new Pair(69, "$"), new ArrayList<>() {{
                            add(67);
                        }});
                        put(new Pair(36, "$"), new ArrayList<>() {{
                            add(38);
                        }});
                        put(new Pair(3, "$"), new ArrayList<>() {{
                            add(4);
                        }});
                        put(new Pair(92, "_"), new ArrayList<>() {{
                            add(93);
                        }});
                        put(new Pair(127, "$"), new ArrayList<>() {{
                            add(125);
                        }});
                        put(new Pair(94, "$"), new ArrayList<>() {{
                            add(96);
                        }});
                        put(new Pair(61, "$"), new ArrayList<>() {{
                            add(63);
                            add(67);
                            add(71);
                            add(76);
                        }});
                        put(new Pair(50, "z"), new ArrayList<>() {{
                            add(51);
                        }});
                        put(new Pair(26, "c"), new ArrayList<>() {{
                            add(27);
                        }});
                        put(new Pair(28, ")"), new ArrayList<>() {{
                            add(29);
                        }});
                        put(new Pair(42, "x"), new ArrayList<>() {{
                            add(43);
                        }});
                        put(new Pair(86, "$"), new ArrayList<>() {{
                            add(88);
                        }});
                        put(new Pair(108, "z"), new ArrayList<>() {{
                            add(109);
                        }});
                        put(new Pair(53, "$"), new ArrayList<>() {{
                            add(49);
                        }});
                        put(new Pair(100, "x"), new ArrayList<>() {{
                            add(101);
                        }});
                        put(new Pair(144, "$"), new ArrayList<>() {{
                            add(142);
                            add(145);
                        }});
                        put(new Pair(20, ")"), new ArrayList<>() {{
                            add(21);
                        }});
                        put(new Pair(76, "a"), new ArrayList<>() {{
                            add(77);
                        }});
                        put(new Pair(111, "$"), new ArrayList<>() {{
                            add(107);
                        }});
                        put(new Pair(142, "c"), new ArrayList<>() {{
                            add(143);
                        }});
                        put(new Pair(12, "$"), new ArrayList<>() {{
                            add(14);
                        }});
                        put(new Pair(70, "$"), new ArrayList<>() {{
                            add(72);
                        }});
                        put(new Pair(4, "$"), new ArrayList<>() {{
                            add(6);
                        }});
                        put(new Pair(136, ")"), new ArrayList<>() {{
                            add(137);
                        }});
                        put(new Pair(128, "$"), new ArrayList<>() {{
                            add(130);
                        }});
                        put(new Pair(62, "$"), new ArrayList<>() {{
                            add(64);
                        }});
                        put(new Pair(29, "$"), new ArrayList<>() {{
                            add(30);
                        }});
                        put(new Pair(18, "z"), new ArrayList<>() {{
                            add(19);
                        }});
                        put(new Pair(10, "x"), new ArrayList<>() {{
                            add(11);
                        }});
                        put(new Pair(21, "$"), new ArrayList<>() {{
                            add(17);
                        }});
                        put(new Pair(2, "t"), new ArrayList<>() {{
                            add(3);
                        }});
                        put(new Pair(145, "$"), new ArrayList<>() {{
                            add(119);
                        }});
                        put(new Pair(134, "z"), new ArrayList<>() {{
                            add(135);
                        }});
                        put(new Pair(68, "y"), new ArrayList<>() {{
                            add(69);
                        }});
                        put(new Pair(79, "$"), new ArrayList<>() {{
                            add(80);
                        }});
                        put(new Pair(126, "x"), new ArrayList<>() {{
                            add(127);
                        }});
                        put(new Pair(137, "$"), new ArrayList<>() {{
                            add(133);
                        }});
                        put(new Pair(38, "$"), new ArrayList<>() {{
                            add(40);
                            add(44);
                            add(48);
                        }});
                        put(new Pair(5, "$"), new ArrayList<>() {{
                            add(22);
                        }});
                        put(new Pair(96, "$"), new ArrayList<>() {{
                            add(98);
                            add(102);
                            add(106);
                        }});
                        put(new Pair(30, "$"), new ArrayList<>() {{
                            add(32);
                        }});
                        put(new Pair(121, "$"), new ArrayList<>() {{
                            add(122);
                        }});
                        put(new Pair(55, "$"), new ArrayList<>() {{
                            add(56);
                        }});
                        put(new Pair(113, "$"), new ArrayList<>() {{
                            add(114);
                        }});
                        put(new Pair(78, "b"), new ArrayList<>() {{
                            add(79);
                        }});
                        put(new Pair(47, "$"), new ArrayList<>() {{
                            add(45);
                        }});
                        put(new Pair(105, "$"), new ArrayList<>() {{
                            add(103);
                        }});
                        put(new Pair(39, "$"), new ArrayList<>() {{
                            add(41);
                            add(45);
                            add(49);
                            add(54);
                        }});
                        put(new Pair(6, "$"), new ArrayList<>() {{
                            add(8);
                            add(12);
                            add(16);
                        }});
                        put(new Pair(97, "$"), new ArrayList<>() {{
                            add(99);
                            add(103);
                            add(107);
                            add(112);
                        }});
                        put(new Pair(31, "$"), new ArrayList<>() {{
                            add(1);
                        }});
                        put(new Pair(122, "$"), new ArrayList<>() {{
                            add(124);
                            add(128);
                            add(132);
                        }});
                        put(new Pair(54, "a"), new ArrayList<>() {{
                            add(55);
                        }});
                        put(new Pair(89, "$"), new ArrayList<>() {{
                            add(87);
                        }});
                        put(new Pair(23, "$"), new ArrayList<>() {{
                            add(24);
                        }});
                        put(new Pair(112, "a"), new ArrayList<>() {{
                            add(113);
                        }});
                        put(new Pair(81, "$"), new ArrayList<>() {{
                            add(37);
                        }});
                        put(new Pair(48, "$"), new ArrayList<>() {{
                            add(50);
                        }});
                        put(new Pair(15, "$"), new ArrayList<>() {{
                            add(13);
                        }});
                        put(new Pair(120, "o"), new ArrayList<>() {{
                            add(121);
                        }});
                        put(new Pair(139, "$"), new ArrayList<>() {{
                            add(140);
                        }});
                        put(new Pair(106, "$"), new ArrayList<>() {{
                            add(108);
                        }});
                        put(new Pair(73, "$"), new ArrayList<>() {{
                            add(74);
                        }});
                        put(new Pair(40, "$"), new ArrayList<>() {{
                            add(42);
                        }});
                        put(new Pair(7, "$"), new ArrayList<>() {{
                            add(9);
                            add(13);
                            add(17);
                            add(5);
                        }});
                        put(new Pair(131, "$"), new ArrayList<>() {{
                            add(129);
                        }});
                        put(new Pair(98, "$"), new ArrayList<>() {{
                            add(100);
                        }});
                        put(new Pair(65, "$"), new ArrayList<>() {{
                            add(63);
                        }});
                        put(new Pair(88, "a"), new ArrayList<>() {{
                            add(89);
                        }});
                        put(new Pair(123, "$"), new ArrayList<>() {{
                            add(125);
                            add(129);
                            add(133);
                            add(138);
                        }});
                        put(new Pair(90, "$"), new ArrayList<>() {{
                            add(92);
                        }});
                        put(new Pair(22, "a"), new ArrayList<>() {{
                            add(23);
                        }});
                        put(new Pair(46, "y"), new ArrayList<>() {{
                            add(47);
                        }});
                        put(new Pair(57, "$"), new ArrayList<>() {{
                            add(58);
                        }});
                        put(new Pair(104, "y"), new ArrayList<>() {{
                            add(105);
                        }});
                        put(new Pair(115, "$"), new ArrayList<>() {{
                            add(116);
                        }});
                        put(new Pair(82, "$"), new ArrayList<>() {{
                            add(84);
                        }});
                        put(new Pair(80, "c"), new ArrayList<>() {{
                            add(81);
                        }});
                        put(new Pair(16, "$"), new ArrayList<>() {{
                            add(18);
                        }});
                        put(new Pair(138, "a"), new ArrayList<>() {{
                            add(139);
                        }});
                        put(new Pair(8, "$"), new ArrayList<>() {{
                            add(10);
                        }});
                        put(new Pair(74, ")"), new ArrayList<>() {{
                            add(75);
                        }});
                        put(new Pair(132, "$"), new ArrayList<>() {{
                            add(134);
                        }});
                        put(new Pair(66, "$"), new ArrayList<>() {{
                            add(68);
                        }});
                        put(new Pair(33, "$"), new ArrayList<>() {{
                            add(34);
                        }});
                        put(new Pair(0, "$"), new ArrayList<>() {{
                            add(2);
                            add(8);
                            add(12);
                            add(16);
                            add(6);
                            add(4);
                            add(30);
                            add(0);
                            add(40);
                            add(44);
                            add(48);
                            add(38);
                            add(62);
                            add(66);
                            add(70);
                            add(60);
                            add(36);
                            add(82);
                            add(86);
                            add(90);
                            add(98);
                            add(102);
                            add(106);
                            add(96);
                            add(94);
                            add(124);
                            add(128);
                            add(132);
                            add(122);
                            add(118);
                        }});
                        put(new Pair(124, "$"), new ArrayList<>() {{
                            add(126);
                        }});
                        put(new Pair(56, "b"), new ArrayList<>() {{
                            add(57);
                        }});
                        put(new Pair(14, "y"), new ArrayList<>() {{
                            add(15);
                        }});
                        put(new Pair(25, "$"), new ArrayList<>() {{
                            add(26);
                        }});
                        put(new Pair(114, "b"), new ArrayList<>() {{
                            add(115);
                        }});
                        put(new Pair(72, "z"), new ArrayList<>() {{
                            add(73);
                        }});
                        put(new Pair(84, "
                                "), new ArrayList<>(){{ add(85); }});put(new Pair(130, "y"), new ArrayList<>(){{ add(131); }});put(new Pair(141, "$"), new ArrayList<>(){{ add(144); }});put(new Pair(64, "x"), new ArrayList<>(){{ add(65); }});put(new Pair(75, "$"), new ArrayList<>(){{ add(71); }});}})}};


                    }

                }