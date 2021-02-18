/******************************************************************************
 * Copyright (c) 2006, 2020 Borland Software Corporation, CEA LIST, Artal and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/ 
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors: 
 *     committers of openArchitectureWare - Xpand language syntax
 *     Artem Tikhomirov (Borland) - LALR grammar
 *                                - Migration to OCL expressions
 *     Aurelien Didier (ARTAL) - aurelien.didier51@gmail.com - Bug 569174
 *****************************************************************************/
package org.eclipse.papyrus.gmf.internal.xpand.parser;

public interface XpandKWLexersym {
    public final static int
      Char_DollarSign = 46,
      Char_Percent = 47,
      Char__ = 48,
      Char_a = 7,
      Char_b = 31,
      Char_c = 10,
      Char_d = 12,
      Char_e = 1,
      Char_f = 21,
      Char_g = 24,
      Char_h = 26,
      Char_i = 4,
      Char_j = 37,
      Char_k = 38,
      Char_l = 5,
      Char_m = 19,
      Char_n = 3,
      Char_o = 8,
      Char_p = 14,
      Char_q = 39,
      Char_r = 6,
      Char_s = 9,
      Char_t = 2,
      Char_u = 13,
      Char_v = 27,
      Char_w = 34,
      Char_x = 35,
      Char_y = 23,
      Char_z = 49,
      Char_A = 20,
      Char_B = 40,
      Char_C = 32,
      Char_D = 25,
      Char_E = 11,
      Char_F = 28,
      Char_G = 50,
      Char_H = 41,
      Char_I = 17,
      Char_J = 51,
      Char_K = 52,
      Char_L = 30,
      Char_M = 42,
      Char_N = 22,
      Char_O = 15,
      Char_P = 33,
      Char_Q = 53,
      Char_R = 16,
      Char_S = 29,
      Char_T = 18,
      Char_U = 36,
      Char_V = 43,
      Char_W = 54,
      Char_X = 44,
      Char_Y = 55,
      Char_Z = 56,
      Char_EOF = 45;

    public final static String orderedTerminalSymbols[] = {
                 "",
                 "e",
                 "t",
                 "n",
                 "i",
                 "l",
                 "r",
                 "a",
                 "o",
                 "s",
                 "c",
                 "E",
                 "d",
                 "u",
                 "p",
                 "O",
                 "R",
                 "I",
                 "T",
                 "m",
                 "A",
                 "f",
                 "N",
                 "y",
                 "g",
                 "D",
                 "h",
                 "v",
                 "F",
                 "S",
                 "L",
                 "b",
                 "C",
                 "P",
                 "w",
                 "x",
                 "U",
                 "j",
                 "k",
                 "q",
                 "B",
                 "H",
                 "M",
                 "V",
                 "X",
                 "EOF",
                 "DollarSign",
                 "Percent",
                 "_",
                 "z",
                 "G",
                 "J",
                 "K",
                 "Q",
                 "W",
                 "Y",
                 "Z"
             };

    public final static int numTokenKinds = orderedTerminalSymbols.length;
    public final static boolean isValidForParser = true;
}
