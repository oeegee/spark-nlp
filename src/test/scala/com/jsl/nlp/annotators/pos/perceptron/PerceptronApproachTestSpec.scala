package com.jsl.nlp.annotators.pos.perceptron

import com.jsl.nlp.{ContentProvider, DataBuilder}
import com.jsl.nlp.annotators.pos.perceptron.PerceptronApproachTestSpec.trainingCorpusSources
import com.jsl.nlp.util.ResourceHelper
import org.scalatest._

/**
  * Created by Saif Addin on 5/18/2017.
  */
class PerceptronApproachTestSpec extends FlatSpec with PerceptronApproachBehaviors {

  val trainingSentences: List[(List[String], List[String])] = ResourceHelper
    .parsePOSCorpusFromText(ContentProvider.wsjTrainingCorpus, '|')

  "an isolated perceptron tagger" should behave like isolatedPerceptronTraining(
    trainingSentences
  )

  val trainedTagger: PerceptronApproach =
    PerceptronApproach.train(ResourceHelper.parsePOSCorpusFromSources(trainingCorpusSources, '|'), 2)

  "an isolated perceptron tagger" should behave like isolatedPerceptronTagging(
    trainedTagger,
    ContentProvider.targetSentencesFromWsj
  )

  val targetSentencesFromWsjResult = Array("DT","NN","IN","NN","RB","VBN","TO","VB","NNP","NN","NNS","VBZ","VBN",
    "DT","JJ","NN","IN","NN","NNS","IN","DT","NN","IN","NNS","VBN","TO","PRP","RBR","IN","CD","NNS","IN","NNS","VBD")
  "an isolated perceptron tagger" should behave like isolatedPerceptronTagCheck(
    PerceptronApproach.train(trainingSentences, 5),
    ContentProvider.targetSentencesFromWsj,
    targetSentencesFromWsjResult
  )

  "a spark based pragmatic detector" should behave like sparkBasedPOSTagger(
    DataBuilder.basicDataBuild(ContentProvider.sbdTestParagraph)
  )

}
object PerceptronApproachTestSpec {

  /**
    * ANC Corpus. Some files are commented due to dirty characters
    * Taking only 10
    */
  val trainingCorpusSources: List[String] = List(
    "anc-pos-corpus/Postal_Rate_Comm-ReportToCongress2002WEB.txt",
    "anc-pos-corpus/2nd_Gore-Bush.txt",
    "anc-pos-corpus/3rd_Bush-Kerry.txt",
    "anc-pos-corpus/110CYL067.txt",
    "anc-pos-corpus/110CYL068.txt",
    "anc-pos-corpus/110CYL069.txt",
    "anc-pos-corpus/110CYL070.txt",
    "anc-pos-corpus/110CYL071.txt",
    "anc-pos-corpus/110CYL072.txt",
    "anc-pos-corpus/110CYL200.txt",
    "anc-pos-corpus/112C-L012.txt",
    "anc-pos-corpus/112C-L013.txt",
    "anc-pos-corpus/112C-L014.txt",
    "anc-pos-corpus/112C-L015.txt",
    "anc-pos-corpus/112C-L016.txt",
    "anc-pos-corpus/113CWL017.txt",
    "anc-pos-corpus/113CWL018.txt",
    "anc-pos-corpus/114CUL057.txt",
    "anc-pos-corpus/114CUL058.txt",
    "anc-pos-corpus/114CUL059.txt",
    "anc-pos-corpus/114CUL060.txt",
    "anc-pos-corpus/115CVL035.txt",
    "anc-pos-corpus/115CVL036.txt",
    "anc-pos-corpus/115CVL037.txt",
    "anc-pos-corpus/116CUL032.txt",
    "anc-pos-corpus/116CUL033.txt",
    "anc-pos-corpus/116CUL034.txt",
    "anc-pos-corpus/117CWL008.txt",
    "anc-pos-corpus/117CWL009.txt",
    "anc-pos-corpus/118CWL048.txt",
    "anc-pos-corpus/118CWL049.txt",
    "anc-pos-corpus/118CWL050.txt",
    "anc-pos-corpus/119CWL041.txt",
    "anc-pos-corpus/602CZL285.txt",
    "anc-pos-corpus/1399.txt",
    "anc-pos-corpus/1400.txt",
    "anc-pos-corpus/1401.txt",
    "anc-pos-corpus/1402.txt",
    "anc-pos-corpus/1403.txt",
    "anc-pos-corpus/1468-6708-3-1.txt",
    "anc-pos-corpus/1468-6708-3-3.txt",
    "anc-pos-corpus/1471-213X-1-1.txt",
    "anc-pos-corpus/1471-230X-2-21.txt",
    "anc-pos-corpus/1471-2091-2-9.txt",
    "anc-pos-corpus/8885.txt",
    "anc-pos-corpus/9066.txt",
    "anc-pos-corpus/9085.txt",
    "anc-pos-corpus/9159.txt",
    "anc-pos-corpus/9191.txt",
    "anc-pos-corpus/12030.txt",
    "anc-pos-corpus/12174.txt",
    "anc-pos-corpus/12176.txt",
    "anc-pos-corpus/21257.txt",
    "anc-pos-corpus/23559.txt",
    "anc-pos-corpus/49059.txt",
    "anc-pos-corpus/50307.txt",
    "anc-pos-corpus/52201.txt",
    "anc-pos-corpus/52555.txt",
    "anc-pos-corpus/52713.txt",
    "anc-pos-corpus/52998.txt",
    "anc-pos-corpus/52999.txt",
    "anc-pos-corpus/53536.txt",
    "anc-pos-corpus/53555.txt",
    "anc-pos-corpus/54261.txt",
    "anc-pos-corpus/54262.txt",
    "anc-pos-corpus/54263.txt",
    "anc-pos-corpus/54536.txt",
    "anc-pos-corpus/54537.txt",
    "anc-pos-corpus/111344.txt",
    "anc-pos-corpus/111348.txt",
    "anc-pos-corpus/111349.txt",
    "anc-pos-corpus/111359.txt",
    "anc-pos-corpus/111363.txt",
    "anc-pos-corpus/111364.txt",
    "anc-pos-corpus/111367.txt",
    "anc-pos-corpus/111369.txt",
    "anc-pos-corpus/111371.txt",
    "anc-pos-corpus/111373.txt",
    "anc-pos-corpus/111375.txt",
    "anc-pos-corpus/111377.txt",
    "anc-pos-corpus/111380.txt",
    "anc-pos-corpus/111381.txt",
    "anc-pos-corpus/111382.txt",
    "anc-pos-corpus/111393.txt",
    "anc-pos-corpus/111394.txt",
    "anc-pos-corpus/111399.txt",
    "anc-pos-corpus/111400.txt",
    "anc-pos-corpus/111404.txt",
    "anc-pos-corpus/111406.txt",
    "anc-pos-corpus/111410.txt",
    "anc-pos-corpus/111414.txt",
    "anc-pos-corpus/111422.txt",
    "anc-pos-corpus/111424.txt",
    "anc-pos-corpus/111425.txt",
    "anc-pos-corpus/111428.txt",
    "anc-pos-corpus/114423.txt",
    "anc-pos-corpus/114424.txt",
    "anc-pos-corpus/114428.txt",
    "anc-pos-corpus/114433.txt",
    "anc-pos-corpus/114435.txt",
    "anc-pos-corpus/114439.txt",
    "anc-pos-corpus/114440.txt",
    "anc-pos-corpus/114441.txt",
    "anc-pos-corpus/114442.txt",
    "anc-pos-corpus/114445.txt",
    "anc-pos-corpus/114446.txt",
    "anc-pos-corpus/114447.txt",
    "anc-pos-corpus/114448.txt",
    "anc-pos-corpus/114450.txt",
    "anc-pos-corpus/114452.txt",
    "anc-pos-corpus/173252.txt",
    "anc-pos-corpus/173906.txt",
    "anc-pos-corpus/174124.txt",
    "anc-pos-corpus/175448.txt",
    "anc-pos-corpus/175814.txt",
    "anc-pos-corpus/175816.txt",
    "anc-pos-corpus/175841.txt",
    "anc-pos-corpus/176581.txt",
    "anc-pos-corpus/210343.txt",
    "anc-pos-corpus/211401.txt",
    "anc-pos-corpus/211402.txt",
    "anc-pos-corpus/218920.txt",
    "anc-pos-corpus/219122.txt",
    "anc-pos-corpus/219123.txt",
    "anc-pos-corpus/219257.txt",
    "anc-pos-corpus/221197.txt",
    "anc-pos-corpus/230685.txt",
    "anc-pos-corpus/234267.txt",
    "anc-pos-corpus/234783.txt",
    "anc-pos-corpus/20000410_nyt-NEW.txt",
    "anc-pos-corpus/20000415_apw_eng-NEW.txt",
    "anc-pos-corpus/20000419_apw_eng-NEW.txt",
    "anc-pos-corpus/20000424_nyt-NEW.txt",
    "anc-pos-corpus/20020731-nyt.txt",
    "anc-pos-corpus/A1.E1-NEW.txt",
    "anc-pos-corpus/A1.E2-NEW.txt",
    "anc-pos-corpus/A_defense_of_Michael_Moore.txt",
    "anc-pos-corpus/Acephalous-Cant-believe.txt",
    "anc-pos-corpus/Acephalous-Internet.txt",
    "anc-pos-corpus/alumnifund1.txt",
    "anc-pos-corpus/AMC2.txt",
    "anc-pos-corpus/Ant_Robot.txt",
    "anc-pos-corpus/anth_essay_4.txt",
    "anc-pos-corpus/Anti-Terrorist.txt",
    "anc-pos-corpus/appalachian1.txt",
    "anc-pos-corpus/Apply.txt",
    "anc-pos-corpus/Article247_66.txt",
    "anc-pos-corpus/Article247_327.txt",
    "anc-pos-corpus/Article247_328.txt",
    "anc-pos-corpus/Article247_400.txt",
    "anc-pos-corpus/Article247_500.txt",
    "anc-pos-corpus/Article247_3500.txt",
    "anc-pos-corpus/ArticleIP_1059.txt",
    "anc-pos-corpus/ArticleIP_1060.txt",
    "anc-pos-corpus/aspca1.txt",
    "anc-pos-corpus/att2.txt",
    "anc-pos-corpus/audubon1.txt",
    "anc-pos-corpus/audubon2.txt",
    "anc-pos-corpus/Bartok.txt",
    "anc-pos-corpus/Bed012.txt",
    "anc-pos-corpus/Black_and_white.txt",
    "anc-pos-corpus/blog-jet-lag.txt",
    "anc-pos-corpus/blog-monastery.txt",
    "anc-pos-corpus/blog-new-year's-resolutions.txt",
    "anc-pos-corpus/blog-varsity-athletics.txt",
    "anc-pos-corpus/Bmr021.txt",
    "anc-pos-corpus/cable_spool_fort.txt",
    "anc-pos-corpus/captured_moments.txt",
    "anc-pos-corpus/Cartoonist_services.txt",
    "anc-pos-corpus/ch5.txt",
    "anc-pos-corpus/chapter-10.txt",
    "anc-pos-corpus/chZ.txt",
    "anc-pos-corpus/CUP1.txt",
    "anc-pos-corpus/CUP2.txt",
    "anc-pos-corpus/Day3PMSession.txt",
    "anc-pos-corpus/Dear_e-mail_user.txt",
    "anc-pos-corpus/defenders5.txt",
    "anc-pos-corpus/detroit.txt",
    "anc-pos-corpus/Earnings_Season_Underway.txt",
    "anc-pos-corpus/easy_money.txt",
    "anc-pos-corpus/Effing-Idiot.txt",
    "anc-pos-corpus/ENRON-pearson-email-25jul02.txt",
    "anc-pos-corpus/enron-thread-159550.txt",
    "anc-pos-corpus/Env_Prot_Agency-nov1.txt",
    "anc-pos-corpus/Fastest_Reader.txt",
    "anc-pos-corpus/FBI_urgent.txt",
    "anc-pos-corpus/fcic_final_report_conclusions.txt",
    "anc-pos-corpus/Fermentation_Eminent-Domain.txt",
    "anc-pos-corpus/Fermentation_HR5034.txt",
    "anc-pos-corpus/Global_Professional_Directory.txt",
    "anc-pos-corpus/guidedogs1.txt",
    "anc-pos-corpus/HistoryGreek.txt",
    "anc-pos-corpus/HistoryJerusalem.txt",
    "anc-pos-corpus/HistoryLasVegas.txt",
    "anc-pos-corpus/Homosexuality.txt",
    "anc-pos-corpus/hotel-california.txt",
    "anc-pos-corpus/How_soon-Fans.txt",
    "anc-pos-corpus/How_soon-Lebron-James.txt",
    "anc-pos-corpus/hsus4.txt",
    "anc-pos-corpus/IFAW1.txt",
    "anc-pos-corpus/interview_nathan_hole.txt",
    "anc-pos-corpus/IntroDublin.txt",
    "anc-pos-corpus/IntroHongKong.txt",
    "anc-pos-corpus/Italy.txt",
    "anc-pos-corpus/jokes1.txt",
    "anc-pos-corpus/jokes2.txt",
    "anc-pos-corpus/jokes3.txt",
    "anc-pos-corpus/jokes4.txt",
    "anc-pos-corpus/jokes5.txt",
    "anc-pos-corpus/jokes6.txt",
    "anc-pos-corpus/jokes7.txt",
    "anc-pos-corpus/jokes8.txt",
    "anc-pos-corpus/jokes9.txt",
    "anc-pos-corpus/jokes10.txt",
    "anc-pos-corpus/jokes11.txt",
    "anc-pos-corpus/jokes12.txt",
    "anc-pos-corpus/jokes13.txt",
    "anc-pos-corpus/jokes14.txt",
    "anc-pos-corpus/jokes15.txt",
    "anc-pos-corpus/jokes16.txt",
    "anc-pos-corpus/journal.pbio.0020001.txt",
    "anc-pos-corpus/JurassicParkIV-INT.txt",
    "anc-pos-corpus/JurassicParkIV-Scene_1.txt",
    "anc-pos-corpus/JurassicParkIV-Scene_3.txt",
    "anc-pos-corpus/JurassicParkIV-Scene_4.txt",
    "anc-pos-corpus/JurassicParkIV-Scene_5.txt",
    "anc-pos-corpus/Laptop_Bags.txt",
    "anc-pos-corpus/Lessig-court-transcript.txt",
    "anc-pos-corpus/lessig_blog-carbon.txt",
    "anc-pos-corpus/lists-003-2114716.txt",
    "anc-pos-corpus/lists-003-2121270.txt",
    "anc-pos-corpus/lists-003-2125109.txt",
    "anc-pos-corpus/lists-003-2129640.txt",
    "anc-pos-corpus/lists-003-2133315.txt",
    "anc-pos-corpus/lists-003-2137010.txt",
    "anc-pos-corpus/lists-003-2144868.txt",
    "anc-pos-corpus/lists-003-2148080.txt",
    "anc-pos-corpus/lists-003-2152883.txt",
    "anc-pos-corpus/lists-003-2171003.txt",
    "anc-pos-corpus/lists-003-2173878.txt",
    "anc-pos-corpus/lists-003-2180740.txt",
    "anc-pos-corpus/lists-003-2183485.txt",
    "anc-pos-corpus/lists-003-2205935.txt",
    "anc-pos-corpus/lists-034-10062451.txt",
    "anc-pos-corpus/lists-034-10066763.txt",
    "anc-pos-corpus/lists-034-10069772.txt",
    "anc-pos-corpus/lists-034-10073419.txt",
    "anc-pos-corpus/lists-034-10077455.txt",
    "anc-pos-corpus/lists-034-10082707.txt",
    "anc-pos-corpus/lists-046-11485666.txt",
    "anc-pos-corpus/lists-046-11489622.txt",
    "anc-pos-corpus/lists-046-11493928.txt",
    "anc-pos-corpus/lists-046-11506817.txt",
    "anc-pos-corpus/lists-046-12119260.txt",
    "anc-pos-corpus/lists-046-12122969.txt",
    "anc-pos-corpus/lists-046-12130258.txt",
    "anc-pos-corpus/lists-046-12133410.txt",
    "anc-pos-corpus/lists-046-12139072.txt",
    "anc-pos-corpus/lists-046-12142206.txt",
    "anc-pos-corpus/lists-046-12146425.txt",
    "anc-pos-corpus/lists-046-12151335.txt",
    "anc-pos-corpus/lists-046-12155427.txt",
    "anc-pos-corpus/lists-046-12158926.txt",
    "anc-pos-corpus/lists-046-12162937.txt",
    "anc-pos-corpus/littleshelter2.txt",
    "anc-pos-corpus/LSC-Protocol_Regarding_Access.txt",
    "anc-pos-corpus/lw1.txt",
    "anc-pos-corpus/Madame_White_Snake.txt",
    "anc-pos-corpus/Mailbox_Upgrade.txt",
    "anc-pos-corpus/marine1.txt",
    "anc-pos-corpus/NapierDianne.txt",
    "anc-pos-corpus/Nathans_Bylichka.txt",
    "anc-pos-corpus/new_clients.txt",
    "anc-pos-corpus/NWF1.txt",
    "anc-pos-corpus/NYTnewswire1.txt",
    "anc-pos-corpus/NYTnewswire2.txt",
    "anc-pos-corpus/NYTnewswire3.txt",
    "anc-pos-corpus/NYTnewswire4.txt",
    "anc-pos-corpus/NYTnewswire5.txt",
    "anc-pos-corpus/NYTnewswire6.txt",
    "anc-pos-corpus/NYTnewswire7.txt",
    "anc-pos-corpus/NYTnewswire8.txt",
    "anc-pos-corpus/NYTnewswire9.txt",
    "anc-pos-corpus/Ohio_Steel.txt",
    "anc-pos-corpus/pirates.txt",
    "anc-pos-corpus/pmed.0010029.txt",
    "anc-pos-corpus/PolkMaria.txt",
    "anc-pos-corpus/Re_JobOffer.txt",
    "anc-pos-corpus/record_volume.txt",
    "anc-pos-corpus/ReidSandra.txt",
    "anc-pos-corpus/RindnerBonnie.txt",
    "anc-pos-corpus/rr166.txt",
    "anc-pos-corpus/rybczynski-ch3.txt",
    "anc-pos-corpus/Secret_Shopper.txt",
    "anc-pos-corpus/Seedbombing.txt",
    "anc-pos-corpus/SEO.txt",
    "anc-pos-corpus/SgtCassandra.txt",
    "anc-pos-corpus/sucker.txt",
    "anc-pos-corpus/sw2014-ms98-a-trans.txt",
    "anc-pos-corpus/sw2015-ms98-a-trans.txt",
    "anc-pos-corpus/sw2025-ms98-a-trans.txt",
    "anc-pos-corpus/sw2071-ms98-a-trans.txt",
    "anc-pos-corpus/sw2078-ms98-a-trans.txt",
    "anc-pos-corpus/The_Black_Willow.txt",
    "anc-pos-corpus/Tupelo-Honey-Cafe.txt",
    "anc-pos-corpus/tweets1.txt",
    "anc-pos-corpus/tweets2.txt",
    "anc-pos-corpus/ucb1.txt",
    "anc-pos-corpus/ucb2.txt",
    "anc-pos-corpus/ucb3.txt",
    "anc-pos-corpus/ucb4.txt",
    "anc-pos-corpus/ucb6.txt",
    "anc-pos-corpus/ucb8.txt",
    "anc-pos-corpus/ucb9.txt",
    "anc-pos-corpus/ucb10.txt",
    "anc-pos-corpus/ucb11.txt",
    "anc-pos-corpus/ucb12.txt",
    "anc-pos-corpus/ucb14.txt",
    "anc-pos-corpus/ucb15.txt",
    "anc-pos-corpus/ucb20.txt",
    "anc-pos-corpus/ucb21.txt",
    "anc-pos-corpus/ucb22.txt",
    "anc-pos-corpus/ucb23.txt",
    "anc-pos-corpus/ucb24.txt",
    "anc-pos-corpus/ucb25.txt",
    "anc-pos-corpus/ucb26.txt",
    "anc-pos-corpus/ucb27.txt",
    "anc-pos-corpus/ucb28.txt",
    "anc-pos-corpus/ucb29.txt",
    "anc-pos-corpus/ucb30.txt",
    "anc-pos-corpus/ucb31.txt",
    "anc-pos-corpus/ucb40.txt",
    "anc-pos-corpus/ucb41.txt",
    "anc-pos-corpus/ucb42.txt",
    "anc-pos-corpus/ucb43.txt",
    "anc-pos-corpus/ucb44.txt",
    "anc-pos-corpus/ucb45.txt",
    "anc-pos-corpus/ucb46.txt",
    "anc-pos-corpus/ucb47.txt",
    "anc-pos-corpus/ucb48.txt",
    "anc-pos-corpus/ucb49.txt",
    "anc-pos-corpus/ucb50.txt",
    "anc-pos-corpus/ucb51.txt",
    "anc-pos-corpus/ucb52.txt",
    "anc-pos-corpus/ucb53.txt",
    "anc-pos-corpus/ucb54.txt",
    "anc-pos-corpus/united1.txt",
    "anc-pos-corpus/Uprooted_Bike.txt",
    "anc-pos-corpus/Uprooted_Farming-on-Sand.txt",
    "anc-pos-corpus/vampires.txt",
    "anc-pos-corpus/VOL15_3.txt",
    "anc-pos-corpus/warner1.txt",
    "anc-pos-corpus/WhatToHongKong.txt",
    "anc-pos-corpus/WhereToHongKong.txt",
    "anc-pos-corpus/wildelifewatch1.txt",
    "anc-pos-corpus/wsj_0006.txt",
    "anc-pos-corpus/wsj_0026.txt",
    "anc-pos-corpus/wsj_0027.txt",
    "anc-pos-corpus/wsj_0032.txt",
    "anc-pos-corpus/wsj_0068.txt",
    "anc-pos-corpus/wsj_0073.txt",
    "anc-pos-corpus/wsj_0106.txt",
    "anc-pos-corpus/wsj_0120.txt",
    "anc-pos-corpus/wsj_0124.txt",
    "anc-pos-corpus/wsj_0127.txt",
    "anc-pos-corpus/wsj_0132.txt",
    "anc-pos-corpus/wsj_0135.txt",
    "anc-pos-corpus/wsj_0136.txt",
    "anc-pos-corpus/wsj_0144.txt",
    "anc-pos-corpus/wsj_0150.txt",
    "anc-pos-corpus/wsj_0151.txt",
    "anc-pos-corpus/wsj_0152.txt",
    "anc-pos-corpus/wsj_0157.txt",
    "anc-pos-corpus/wsj_0158.txt",
    "anc-pos-corpus/wsj_0159.txt",
    "anc-pos-corpus/wsj_0160.txt",
    "anc-pos-corpus/wsj_0161.txt",
    "anc-pos-corpus/wsj_0165.txt",
    "anc-pos-corpus/wsj_0167.txt",
    "anc-pos-corpus/wsj_0168.txt",
    "anc-pos-corpus/wsj_0169.txt",
    "anc-pos-corpus/wsj_0171.txt",
    "anc-pos-corpus/wsj_0172.txt",
    "anc-pos-corpus/wsj_0173.txt",
    "anc-pos-corpus/wsj_0175.txt",
    "anc-pos-corpus/wsj_0176.txt",
    "anc-pos-corpus/wsj_0184.txt",
    "anc-pos-corpus/wsj_0187.txt",
    "anc-pos-corpus/wsj_0189.txt",
    "anc-pos-corpus/wsj_1640.mrg-NEW.txt",
    "anc-pos-corpus/wsj_2465.txt",
    "anc-pos-corpus/wwf12.txt"
  ).take(5)

}