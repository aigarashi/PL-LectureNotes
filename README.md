# 工学部専門科目「プログラミング言語」講義資料(2017年度)

このページのURL: http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/ (現在 https://github.com/aigarashi/PL-LectureNotes に転送されます．)

## 開講情報・担当

* 曜時限: 月曜日2限(10:30〜12:00)
* 場所: 総合研究7号館1F情報1講義室
* 担当: 五十嵐 淳
    * オフィスアワー: 月曜17:00〜18:00(総合研究7号館224)
         * その他の時間は要アポイントメント
* 担当ＴＡ: 矢杉和義 (通信情報システム専攻M2)

## お知らせ

* BlueJ のデバッガなんて知らん，ということなので[今年の「プログラミング入門」で使った資料](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/tmp/BlueJTool2.pdf)を置きました．(2017.11.06)
* 課題1を出しました．締切は 11/13 です． (2017.10.29)
* 2017年度ページたちあげ (2017.9.27)

## 授業の概要・目的(シラバスより)

プログラミング言語が提供する様々な抽象化機構や実行時システムについて，種々のプログラミング言語を比較しながらコンピュータサイエンスの立場から論じる．([シラバス](http://www.t.kyoto-u.ac.jp/syllabus-s/?mode=subject&lang=ja&year=2017&b=6&c=90170))

### 目的達成のための方針

(おそらく前半くらいは)以下の3言語

* Java
* OCaml
* C

を並行して用い，同じ例題が異なる言語でどのように表現されるかを知り，それを通じて，シラバスの授業内容にあげられているような言語共通のプログラム抽象化のアイデア，言語毎の idiosyncrasy (特異な点)を学ぶ．また，実際の言語仕様の文書を読んで理解できるようにもしたい．

ある言語を使ってプログラムをバリバリ書くためには，その基本的な原理や機能を知ることはもちろん必要だが，利用可能なライブラリやツール(エディタ，コンパイラ，デバッガ，プロファイラ，バージョン管理システム)の使い方を知るのも重要である．この講義だけでは，そこまではあまりカバーできないのであしからず．

## 授業スケジュールと講義ノート

以下の表で，日付は今年度のものですが，内容は昨年の実績に基づいており，変更の可能性が大いにあります．

|回数|日付| 内容 | 資料 | 宿題 |
|----|----|-----------|------|------|
|1   |10/2| 講義概要・Javaと2分探索木の復習 | [00-introduction.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/00-introduction.html)  |  Java の復習 [01-java.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/01-java.html) |
|2   |10/16| 2分探索木 in Java (1) | [02-bst-java.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/02-bst-java.html) |      |
|3   |10/23| OCaml の概要 | [03-ocaml.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/03-ocaml.html)     |      |
|4   |10/30| 2分探索木 in OCaml (1),  2分探索木 in Java (2) | [04-bst-ocaml.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/04-bst-ocaml.html), [05-bst-java-vars.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/05-bst-java-vars.html)  | [課題1(締切: 11/13) ](https://github.com/ProgrammingLanguagesAtKUEng/kadai1) |
|5   |11/6| 2分探索木 in Java (3), 再帰と繰り返し | [06-rec-iter.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/06-rec-iter.html)  |     | 
|6   |11/13| 続・再帰と繰り返し |      |      |
|7   |11/20| 以下は去年の内容です: C言語の概要(1) | [06-C.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/06-C.html)     |      |
|8   |12/4| C言語の概要(2) |    |      |
|9   |12/11| 2分探索木 in C, プログラミング言語の構文論  |[07-bst-C.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/07-bst-C.html), [08-language-syntax.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/08-language-syntax.html)|      |
|10  |12/18| プログラミング言語の構文論 | [08-language-syntax.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/08-language-syntax.html)|      |
|11  |12/25(!)| 再帰と繰り返し |  |      |
|12  |1/15| 多相性(1)  | [10-polymorphism.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/10-polymorphism.html) |      |
|13  |1/22| 高階関数   | [11-hofuns.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/11-hofuns.html) |      |
|14  |1/29| 多相性と高階関数，試験について  | [12-polyBST.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/12-polyBST.html) |      |
|    |2/5(?)|試験      |      |      |


講義で紹介するプログラムは(上のファイル一覧にある) src/ 以下で公開するので適宜ダウンロードしてもらいたい．

## 参考書・参考資料

### 言語仕様(っぽいもの)
* X. Leroy, D. Doligez, A. Frisch, J. Garrigue, D. Rémy and J. Vouillon.
[The OCaml System Documentation and User's Manual](http://caml.inria.fr/pub/docs/manual-ocaml/index.html)
* J. Gosling, B. Joy, G. Steele, G. Bracha, A. Buckley.  [The Java Language Specification. Java SE 8 Edition.](https://docs.oracle.com/javase/specs/jls/se8/html/index.html)
* J. Gosling, B. Joy, G. Steele, G. Bracha, A. Buckley.  [The Java Language Specification. Java SE 9 Edition.](https://docs.oracle.com/javase/specs/jls/se9/html/index.html)
* C99 (ISOが1999年に定めたC言語規格 ISO/IEC 9899:1999) (正式版は有料だが，[ドラフト](http://www.open-std.org/jtc1/sc22/WG14/www/docs/n1256.pdf)が落ちている．) その後 C11 に改訂されている．

### OCaml 情報
* 五十嵐淳． [OCaml 入門](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/isle4-11w/mltext.pdf) (次の本の元になった計算機科学実験及演習の資料．この講義の範囲ならこれで十分)
* 五十嵐淳．[プログラミング in OCaml](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/OCaml/)．技術評論社．(でもこれも買ってくれるとうれしい!)

### 環境設定

* [OCaml, C 開発環境のセットアップ](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/setup.html)
* [OCaml, C 開発環境の利用法](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/usage.html)

-----------
Copyright 五十嵐 淳 (pl17@fos.kuis.kyoto-u.ac.jp), 2016, 2017
