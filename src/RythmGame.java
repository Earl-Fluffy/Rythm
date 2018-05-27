
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner; // Temporaire

public class RythmGame {

    public static void main(String[] args) {

        // Maps hard-codées (à bouger ? Encombrant)
        int[][][] chichiWoMogeBeats = {{{4, 0}, {14, 0}, {16, 0}, {46, 0}, {62, 0}, {70, 0}, {78, 0}, {94, 0}, {98, 0}, {122, 0}, {136, 1}, {138, 0}, {140, 0}, {158, 0}, {160, 0}, {174, 0}, {176, 0}, {184, 0}, {191, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{2, 0}, {8, 0}, {20, 0}, {26, 0}, {38, 1}, {42, 0}, {54, 0}, {58, 0}, {80, 0}, {92, 0}, {96, 0}, {100, 0}, {106, 2}, {126, 0}, {130, 0}, {134, 0}, {138, 0}, {140, 0}, {148, 0}, {164, 0}, {182, 1}, {191, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{6, 0}, {18, 0}, {24, 0}, {28, 0}, {30, 0}, {36, 1}, {44, 0}, {50, 0}, {56, 0}, {60, 0}, {66, 0}, {72, 0}, {82, 0}, {84, 0}, {90, 0}, {102, 0}, {110, 2}, {118, 0}, {124, 1}, {128, 1}, {134, 0}, {138, 0}, {140, 0}, {142, 1}, {146, 0}, {152, 0}, {154, 0}, {162, 0}, {168, 0}, {170, 0}, {180, 1}, {185, 0}, {191, 0}, {0, 0}},
                {{10, 0}, {12, 0}, {22, 0}, {34, 1}, {48, 0}, {52, 0}, {64, 0}, {68, 0}, {74, 0}, {76, 0}, {86, 0}, {104, 0}, {114, 2}, {132, 1}, {136, 1}, {138, 0}, {140, 0}, {144, 1}, {150, 0}, {156, 0}, {166, 0}, {172, 0}, {178, 1}, {186, 4}, {191, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass chichiWoMoge = new SongClass(165, 1, 6990, "Ressources/ChichiWoMoge.wav", "Ressources/ChichiWoMogeBG.png", 72, 4, chichiWoMogeBeats);
        int[][][] oddsAndEndsBeats = {{{10, 0}, {30, 0}, {46, 0}, {62, 0}, {76, 0}, {80, 0}, {88, 0}, {131, 0}, {133, 0}, {135, 0}, {146, 0}, {158, 0}, {198, 4}, {234, 2}, {0, 0}},
                {{2, 0}, {16, 0}, {28, 0}, {32, 0}, {44, 0}, {48, 0}, {56, 0}, {60, 0}, {74, 0}, {78, 0}, {82, 0}, {98, 0}, {102, 0}, {118, 0}, {139, 0}, {141, 0}, {142, 0}, {143, 0}, {148, 0}, {171, 0}, {179, 0}, {180, 0}, {187, 0}, {188, 0}, {194, 0}, {195, 0}, {211, 0}, {212, 0}, {219, 0}, {220, 0}, {226, 0}, {227, 0}, {231, 0}, {232, 0}, {244, 0}, {245, 0}, {252, 0}, {253, 0}, {254, 0}, {256, 0}, {264, 0}, {268, 0}, {272, 0}, {279, 0}, {280, 0}, {0, 0}},
                {{6, 0}, {8, 0}, {14, 0}, {18, 0}, {22, 0}, {24, 0}, {26, 0}, {40, 0}, {52, 0}, {66, 0}, {68, 0}, {72, 0}, {86, 0}, {104, 0}, {106, 0}, {112, 0}, {120, 0}, {126, 0}, {130, 0}, {137, 0}, {144, 0}, {150, 0}, {153, 0}, {154, 0}, {155, 0}, {156, 0}, {167, 0}, {169, 0}, {172, 3}, {178, 0}, {186, 0}, {190, 0}, {191, 0}, {192, 0}, {196, 0}, {210, 0}, {218, 0}, {222, 0}, {223, 0}, {224, 0}, {228, 0}, {230, 0}, {238, 0}, {242, 0}, {246, 0}, {250, 0}, {258, 0}, {262, 0}, {274, 0}, {276, 0}, {0, 0}},
                {{36, 0}, {70, 0}, {84, 0}, {90, 4}, {110, 0}, {114, 0}, {122, 0}, {128, 0}, {152, 0}, {161, 0}, {163, 0}, {165, 0}, {174, 0}, {176, 0}, {182, 0}, {184, 0}, {206, 0}, {208, 0}, {214, 0}, {216, 0}, {240, 0}, {248, 0}, {260, 0}, {0, 0}}};
        SongClass oddsAndEnds = new SongClass(192, 1, 5858, "Ressources/OddsAndEnds.wav", "Ressources/OddsAndEndsBG.png", 94, 3, oddsAndEndsBeats);
        int[][][] sansBeats = {{{2, 0}, {8, 0}, {16, 0}, {18, 0}, {24, 0}, {29, 2}, {34, 0}, {38, 0}, {43, 0}, {53, 0}, {58, 0}, {62, 0}, {66, 0}, {74, 0}, {79, 0}, {82, 0}, {89, 0}, {93, 0}, {95, 0}, {97, 0}, {104, 0}, {109, 0}, {117, 0}, {122, 0}, {130, 0}, {136, 0}, {139, 0}, {146, 0}, {154, 0}, {158, 0}, {161, 0}, {168, 0}, {172, 0}, {177, 0}, {182, 0}, {186, 0}, {190, 0}, {192, 0}, {194, 0}, {198, 0}, {202, 0}, {206, 0}, {0, 0}},
                {{5, 0}, {9, 0}, {11, 0}, {15, 0}, {18, 0}, {21, 0}, {25, 0}, {28, 0}, {32, 2}, {37, 0}, {42, 0}, {45, 0}, {49, 0}, {52, 0}, {57, 0}, {61, 0}, {63, 0}, {70, 0}, {75, 0}, {80, 0}, {82, 0}, {86, 0}, {88, 0}, {101, 0}, {105, 0}, {108, 0}, {113, 0}, {116, 0}, {120, 0}, {123, 0}, {127, 0}, {130, 0}, {134, 0}, {137, 0}, {143, 0}, {145, 0}, {148, 0}, {152, 0}, {155, 0}, {159, 0}, {165, 0}, {169, 0}, {173, 2}, {180, 0}, {187, 0}, {0, 0}},
                {{4, 0}, {10, 0}, {13, 0}, {17, 0}, {22, 0}, {26, 0}, {31, 0}, {36, 0}, {41, 0}, {44, 0}, {48, 0}, {54, 0}, {60, 0}, {64, 0}, {68, 0}, {72, 0}, {77, 2}, {84, 0}, {87, 0}, {91, 0}, {94, 0}, {96, 0}, {100, 0}, {107, 0}, {111, 0}, {114, 0}, {118, 0}, {124, 0}, {128, 2}, {132, 0}, {140, 0}, {144, 0}, {149, 0}, {153, 0}, {156, 0}, {160, 0}, {164, 0}, {170, 0}, {175, 0}, {177, 0}, {180, 0}, {184, 0}, {189, 0}, {191, 0}, {193, 0}, {196, 0}, {200, 0}, {204, 0}, {208, 0}, {0, 0}},
                {{2, 0}, {6, 0}, {12, 0}, {20, 0}, {27, 0}, {34, 0}, {40, 0}, {47, 0}, {50, 0}, {56, 0}, {59, 0}, {66, 0}, {69, 0}, {76, 0}, {81, 0}, {85, 0}, {90, 0}, {97, 0}, {102, 0}, {106, 0}, {112, 0}, {114, 0}, {121, 0}, {125, 2}, {133, 0}, {138, 0}, {141, 0}, {146, 0}, {150, 0}, {157, 0}, {161, 0}, {166, 0}, {171, 0}, {175, 0}, {178, 0}, {185, 0}, {188, 0}, {0, 0}}};
        SongClass sans = new SongClass(128, 2, 3000, "Ressources/sans.wav", "Ressources/sansBG.png", 49, 5, sansBeats);
        int[][][] bonetrousleBeats = {{{2, 0}, {6, 0}, {10, 0}, {14, 0}, {42, 0}, {50, 0}, {54, 0}, {62, 0}, {68, 0}, {76, 0}, {86, 0}, {92, 0}, {102, 0}, {110, 0}, {116, 0}, {124, 0}, {132, 0}, {138, 0}, {145, 0}, {152, 0}, {158, 0}, {168, 0}, {176, 0}, {180, 0}, {186, 2}, {190, 0}, {194, 2}, {202, 2}, {207, 0}, {214, 2}, {219, 0}, {226, 0}, {230, 0}, {234, 0}, {238, 0}, {242, 0}, {245, 0}, {250, 0}, {255, 0}, {260, 0}, {264, 0}, {282, 0}, {0, 0}},
                {{18, 0}, {22, 0}, {26, 0}, {30, 0}, {34, 0}, {40, 0}, {44, 0}, {58, 0}, {70, 0}, {78, 0}, {84, 0}, {106, 0}, {115, 0}, {120, 0}, {130, 0}, {143, 0}, {148, 0}, {155, 0}, {162, 2}, {170, 2}, {177, 0}, {184, 0}, {192, 0}, {200, 0}, {209, 0}, {212, 0}, {218, 0}, {222, 0}, {240, 0}, {244, 0}, {250, 0}, {254, 0}, {268, 0}, {272, 0}, {286, 0}, {0, 0}},
                {{4, 0}, {8, 0}, {12, 0}, {16, 0}, {36, 0}, {48, 0}, {52, 0}, {56, 0}, {72, 0}, {82, 0}, {90, 0}, {94, 0}, {100, 0}, {108, 0}, {114, 0}, {118, 0}, {126, 0}, {129, 0}, {134, 0}, {142, 0}, {146, 0}, {154, 0}, {156, 0}, {162, 0}, {166, 2}, {175, 0}, {178, 2}, {191, 0}, {196, 0}, {204, 0}, {206, 0}, {210, 2}, {216, 0}, {221, 0}, {228, 0}, {232, 0}, {234, 0}, {236, 0}, {239, 0}, {241, 0}, {246, 0}, {248, 0}, {252, 0}, {256, 0}, {258, 0}, {262, 0}, {274, 0}, {276, 0}, {278, 0}, {288, 0}, {0, 0}},
                {{20, 0}, {24, 0}, {28, 0}, {32, 0}, {38, 0}, {46, 0}, {60, 0}, {64, 0}, {74, 0}, {80, 0}, {88, 0}, {96, 0}, {104, 0}, {112, 0}, {122, 0}, {128, 0}, {136, 0}, {140, 0}, {144, 0}, {150, 0}, {158, 0}, {164, 0}, {172, 0}, {174, 0}, {182, 2}, {188, 0}, {193, 0}, {198, 2}, {208, 0}, {217, 0}, {220, 0}, {226, 0}, {230, 0}, {233, 0}, {238, 0}, {242, 0}, {246, 0}, {249, 0}, {253, 0}, {257, 0}, {266, 0}, {270, 0}, {284, 0}, {0, 0}}};
        SongClass bonetrousle = new SongClass(150, 2, 3120, "Ressources/Bonetrousle.wav", "Ressources/BonetrousleBG.png", 59, 5, bonetrousleBeats);
        int[][][] himeHimeBeats = {{{1, 0}, {17, 0}, {33, 0}, {45, 0}, {57, 4}, {79, 0}, {93, 0}, {125, 4}, {141, 0}, {157, 0}, {177, 10}, {205, 0}, {219, 0}, {237, 0}, {251, 0}, {269, 0}, {283, 0}, {295, 0}, {303, 0}, {311, 0}, {317, 4}, {329, 0}, {337, 0}, {347, 0}, {357, 0}, {369, 0}, {379, 0}, {389, 0}, {407, 0}, {417, 0}, {429, 0}, {453, 4}, {473, 4}, {499, 12}, {531, 4}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{13, 0}, {21, 0}, {37, 0}, {65, 4}, {81, 0}, {111, 0}, {133, 0}, {149, 0}, {165, 0}, {187, 0}, {197, 0}, {209, 0}, {221, 0}, {229, 0}, {241, 0}, {247, 0}, {257, 0}, {265, 0}, {273, 0}, {285, 0}, {293, 0}, {299, 0}, {309, 0}, {321, 0}, {343, 0}, {349, 0}, {361, 0}, {375, 0}, {385, 0}, {401, 0}, {411, 0}, {415, 0}, {427, 0}, {437, 0}, {441, 8}, {461, 4}, {477, 4}, {507, 0}, {523, 4}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{5, 0}, {29, 0}, {53, 0}, {65, 0}, {97, 0}, {113, 4}, {129, 0}, {145, 0}, {161, 0}, {173, 0}, {189, 0}, {215, 0}, {233, 0}, {245, 0}, {277, 0}, {287, 0}, {291, 0}, {307, 0}, {325, 0}, {373, 0}, {393, 0}, {405, 0}, {413, 0}, {419, 0}, {425, 0}, {431, 0}, {435, 0}, {449, 0}, {457, 4}, {469, 4}, {489, 10}, {509, 0}, {519, 4}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{9, 0}, {25, 0}, {41, 0}, {49, 0}, {61, 4}, {81, 4}, {97, 4}, {113, 0}, {129, 0}, {137, 0}, {153, 0}, {169, 0}, {193, 0}, {201, 0}, {213, 0}, {225, 0}, {253, 0}, {261, 0}, {279, 0}, {297, 0}, {301, 0}, {313, 0}, {333, 0}, {341, 0}, {353, 0}, {365, 0}, {381, 0}, {397, 0}, {411, 0}, {421, 0}, {431, 0}, {465, 4}, {483, 6}, {511, 0}, {515, 0}, {527, 4}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass himeHime = new SongClass(178, 4, 1850, "Ressources/HimeHime.wav", "Ressources/HimeHimeBG.png", 97, 10, himeHimeBeats);
        int[][][] sasageyoBeats = {{{1, 0}, {17, 0}, {33, 0}, {43, 0}, {55, 0}, {63, 0}, {67, 0}, {71, 0}, {79, 0}, {93, 0}, {97, 0}, {105, 0}, {113, 0}, {121, 0}, {129, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{7, 0}, {23, 0}, {33, 0}, {39, 0}, {43, 0}, {51, 0}, {55, 0}, {63, 0}, {75, 0}, {85, 0}, {91, 0}, {101, 0}, {109, 0}, {115, 0}, {123, 0}, {127, 0}, {133, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{3, 0}, {11, 0}, {15, 0}, {19, 0}, {35, 0}, {39, 0}, {47, 0}, {51, 0}, {59, 0}, {65, 0}, {73, 0}, {81, 0}, {87, 0}, {95, 0}, {103, 0}, {111, 0}, {119, 0}, {125, 0}, {131, 0}, {135, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{27, 0}, {31, 0}, {35, 0}, {47, 0}, {59, 0}, {65, 0}, {69, 0}, {77, 0}, {83, 0}, {89, 0}, {99, 0}, {107, 0}, {117, 0}, {125, 0}, {129, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass sasageyo = new SongClass(160, 4, 2150, "Ressources/Sasageyo.wav", "Ressources/SasageyoBG.png", 89, 8, sasageyoBeats);
        int[][][] asgoreBeats = {{{18, 0}, {46, 0}, {50, 0}, {58, 4}, {86, 0}, {100, 0}, {106, 0}, {138, 0}, {154, 3}, {170, 0}, {186, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{2, 0}, {26, 4}, {34, 0}, {44, 0}, {48, 0}, {54, 0}, {74, 4}, {90, 4}, {98, 0}, {102, 0}, {110, 0}, {118, 0}, {122, 8}, {142, 0}, {157, 3}, {162, 4}, {178, 4}, {189, 0}, {194, 4}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{10, 4}, {22, 0}, {42, 0}, {66, 0}, {74, 4}, {94, 2}, {104, 0}, {110, 0}, {116, 0}, {122, 8}, {138, 0}, {146, 4}, {160, 2}, {184, 0}, {194, 4}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{6, 0}, {38, 0}, {58, 4}, {70, 0}, {82, 0}, {106, 0}, {114, 0}, {120, 0}, {142, 0}, {152, 0}, {162, 4}, {174, 0}, {192, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}};
        SongClass asgore = new SongClass(113, 4, 3290, "Ressources/Asgore.wav", "Ressources/AsgoreBG.png", 180, 8, asgoreBeats);


        Fenetre fenetre = new Fenetre();
        Score score1 = new Score(1);
        Score score2 = new Score(2);

        // Temporaire
        Scanner kgb = new Scanner(System.in);
        System.out.println("Choisissez une map :");
        System.out.println("1   -   Takahashi Hiroki - Chichi wo Moge   -   1*");
        System.out.println("2   -   Hatsune Miku - Odds and Ends   -   1*");
        System.out.println("3   -   Toby Fox - sans.    -    1*");
        System.out.println("4   -   Toby Fox - Bonetrousle    -   1*");
        System.out.println();
        System.out.println("5   -   *namirin - Koi no Hime Pettanko    -   2*");
        System.out.println();
        System.out.println("6   -   Linked Horizon - Shinzou wo Sasageyo !   -   3*");
        System.out.println("7   -   Toby Fox - Bergentruckung / Asgore   -   3*");
        int mapChoisie = 0;
        while((mapChoisie < 1)||(mapChoisie > 7)) {
            mapChoisie = kgb.nextInt();
        }
        if(mapChoisie == 1){
            launchMap(chichiWoMoge, fenetre, score1, score2);
        }
        if(mapChoisie == 2){
            launchMap(oddsAndEnds, fenetre, score1, score2);
        }
        if(mapChoisie == 3){
            launchMap(sans, fenetre, score1, score2);
        }
        if(mapChoisie == 4){
            launchMap(bonetrousle, fenetre, score1, score2);
        }
        if(mapChoisie == 5){
            launchMap(himeHime, fenetre, score1, score2);
        }
        if(mapChoisie == 6){
            launchMap(sasageyo, fenetre, score1, score2);
        }
        if(mapChoisie == 7){
            launchMap(asgore, fenetre, score1, score2);
        }

    }

    public static void launchMap(SongClass map, Fenetre fenetre, Score score1, Score score2){ // Lance la map sélectionnée

        fenetre.setGameScreen(map.BGfileName, (int)(600/map.vitesseDefilement));
        Clavier clavier = new Clavier(fenetre, score1, score2);
        fenetre.addKeyListener(clavier);

        // On setup un effet sonore
        Clip hitsound = null;
        try {
            hitsound = AudioSystem.getClip();
            hitsound.open(AudioSystem.getAudioInputStream(new File("Ressources/NormalHitclap.wav")));
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        System.out.println("Playing : " + map.musicFileName); // On joue la musique
        Clip musique = null;
        try {
            musique = AudioSystem.getClip();
            musique.open(AudioSystem.getAudioInputStream(new File(map.musicFileName)));
            musique.start();
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }

        try { // On attend pour passer l'offset
            Thread.sleep((long)(map.offset-map.vitesseDefilement*map.beatDuration));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Boucle qui dure pendant la map
        int beatNB = 1;
        int[] avancement = new int[4];
        for(int i=-map.vitesseDefilement; i<(map.duree*1000/map.beatDuration); i++) {

            affichageInfos(map, i, beatNB, musique, score1, score2, fenetre);



            for(int note=0; note<20; note++) { // Un chti bruit a chaque note qui arrive au point où il faut appuyer
                if (fenetre.getNotesOnScreen()[note].y == 545) {
                    hitsound.stop();
                    hitsound.setMicrosecondPosition(0);
                    hitsound.start();
                }
            }

            for(int colonne=0; colonne<4; colonne++) { // On place les nouvelles notes
                if (map.beats[colonne][avancement[colonne]][0] == beatNB) {
                    fenetre.spawnNote(colonne, findSpace(fenetre), map.beats[colonne][avancement[colonne]][1]);
                    avancement[colonne]++;
                }
            }



            beatNB++;
            fenetre.waitForNextBeat(map, 15, i*map.beatDuration + map.offset - musique.getMicrosecondPosition()/1000, score1, score2);
            //confirmation();
        }

        score1.calculComboMax();
        score2.calculComboMax();
        System.out.println(score1.combos + " " + score2.combos);
    }

    public static int findSpace(Fenetre fenetre){ // Cherche un emplacement dans le tableau des notes pas encore occupé pour en placer une nouvelle (2 méthodes, laquelle est plus rapide ?)
        int k=0;
        while((!fenetre.getNotesOnScreen()[k].hitByP1)&&(!fenetre.getNotesOnScreen()[k].hitByP2)){
            k++;
            if(k == 19){
                return 19;
            }
        }
        return k;
        /*for(int i=0; i<20; i++){
            if(fenetre.getNotesOnScreen()[i].y >= 650){
                return i;
            }
        }
        return 0;*/
    }

    public static void confirmation(){ // Temporaire, demande qu'on écrive "1" au terminal pour continuer (permet de freeze le programme pour voir ce qu'il se passe)
        Scanner kgb = new Scanner(System.in);
        int n = 0;
        while(n != 1){
            n = kgb.nextInt();
        }
    }

    public static void affichageInfos (SongClass map, int i, int beatNB, Clip musique, Score score1, Score score2, Fenetre fenetre){ // Temporaire, affiche des informations pendant l'exécution du jeu pour débug

        // On peut mettre les lignes non désirées dans l'immédiat en commentaire

        //System.out.println("i : " + i + "       beatNB : " + beatNB);
        //System.out.println("Decalage actuel (ms) : " + (musique.getMicrosecondPosition()/1000 - ((beatNB + map.vitesseDefilement)*map.beatDuration)));
        //System.out.println();

        /*for(int j=0; j<20; j++){
            System.out.print(fenetre.getNotesOnScreen()[j].colonne + " " + fenetre.getNotesOnScreen()[j].y + " " + fenetre.getNotesOnScreen()[j].x1 + " " + fenetre.getNotesOnScreen()[j].x2 + "    ");
        }
        System.out.println();*/

        /*for(int j=0; j<score1.avancement; j++){
            System.out.print(score1.notes[j] + " ");
        }
        System.out.println();*/
        /*for(int j=0; j<score1.avancement; j++){
            System.out.print(score2.notes[j] + " ");
        }
        System.out.println();*/

        /*score1.calculAcc();
        score2.calculAcc();
        System.out.println(score1.acc + " " + score2.acc);*/
    }

}
