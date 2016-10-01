# 工学部専門科目「プログラミング言語」講義資料(2016年度)

## 開講情報・担当

* 曜時限: 月曜日2限(10:30〜12:00)
* 場所: 総合研究8号館3F講義室4
* 担当: 五十嵐 淳
    * オフィスアワー: 月曜17:00〜18:00(総合研究7号館224)
         * その他の時間は要アポイントメント
* 担当ＴＡ: 矢杉和義 (通信情報システム専攻M1)

## お知らせ

* 2016年度ページたちあげ (2016.9.17)

## 授業の概要・目的(シラバスより)

プログラミング言語が提供する様々な抽象化機構や実行時システムについて，種々のプログラミング言語を比較しながらコンピュータサイエンスの立場から論じる．([シラバス](http://www.t.kyoto-u.ac.jp/syllabus-s/?mode=subject&lang=ja&year=2016&b=6&c=90170))

### 目的達成のための方針

(おそらく年内くらいは)以下の3言語を並行して学習する．

* Java
* OCaml
* C

同じ例題が，違う言語でどのように表現されるかを知り，それを通じて，シラバスの授業内容にあげられているような言語共通のプログラム抽象化のアイデア，言語毎の idiosyncrasy を学ぶ．また，実際の言語仕様を読んで理解できるようにもしたい．

ある言語を使ってプログラムをバリバリ書くためには，その基本的な原理や機能を知ることはもちろん必要だが，利用可能なライブラリやツール(エディタ，コンパイラ，デバッガ，プロファイラ，バージョン管理システム)の使い方を知るのも重要である．この講義だけでは，そこまではあまりカバーできないのであしからず．

## 授業スケジュールと配布資料

|回数|日付| 内容(予定) | 資料 | 宿題 |
|----|----|-----------|------|------|
|1   |10/3|           | [00-introduction.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/00-introduction.html)  |      |
|2   |10/17|           | [01-bst-java.html](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/pl/01-bst-java.html)  |      |
|3   |10/24|           |      |      |
|4   |10/31|           |      |      |
|5   |11/7|            |      |      |
|6   |11/14|          |      |      |
|7   |11/28|           |      |      |
|8   |12/5|            |      |      |
|9   |12/12|          |      |      |
|10  |12/19|           |      |      |
|11  |12/26!?|           |      |      |
|12  |1/4!?|          |      |      |
|13  |1/16| (休講予定) |      |      |
|14  |1/23|           |      |      |
|15  |1/30|           |      |      |
|    |2/7?|試験      |      |      |

講義で紹介するプログラムは(上のファイル一覧にある) src/ 以下で公開するので適宜ダウンロードしてもらいたい．

## 参考書・参考資料

### 言語仕様(っぽいもの)
* X. Leroy, D. Doligez, A. Frisch, J. Garrigue, D. Rémy and J. Vouillon.
[The OCaml System Documentation and User's Manual](http://caml.inria.fr/pub/docs/manual-ocaml/index.html)
* J. Gosling, B. Joy, G. Steele, G. Bracha, A. Buckley.  [The Java Language Specification. Java SE 8 Edition.](https://docs.oracle.com/javase/specs/jls/se8/html/index.html)
* C99 (ISOが1999年に定めたC言語規格 ISO/IEC 9899:1999) (正式版は有料だが，[ドラフト](http://www.open-std.org/jtc1/sc22/WG14/www/docs/n1256.pdf)が落ちている．) その後 C11 に改訂されている．

### OCaml 情報
* 五十嵐淳． [OCaml 入門](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/class/isle4-11w/mltext.pdf) (次の本の元になった計算機科学実験及演習4の資料．この講義の範囲ならこれで十分)
* 五十嵐淳．[プログラミング in OCaml](http://www.fos.kuis.kyoto-u.ac.jp/~igarashi/OCaml/)．技術評論社．(でもこれも買ってくれるとうれしい!)
* [OCaml MOOC2](https://t.co/jI01aqUzBN) (2016年9月下旬に開講しているが，登録はまだ間に合うので興味がある人は受講しよう!)


-----------
igarashi@kuis.kyoto-u.ac.jp
