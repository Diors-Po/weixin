/*
 Navicat MySQL Data Transfer

 Source Server         : mytest
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : weixin

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 12/10/2018 20:58:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for score_record
-- ----------------------------
DROP TABLE IF EXISTS `score_record`;
CREATE TABLE `score_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(255) NULL DEFAULT NULL,
  `score` int(255) NULL DEFAULT NULL,
  `time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cause` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_record
-- ----------------------------
INSERT INTO `score_record` VALUES (1, 1, 1, '2018-08-04 00:00:00', '签到');
INSERT INTO `score_record` VALUES (2, 1, 2, '2018-08-05 01:13:39', '签到');
INSERT INTO `score_record` VALUES (3, 19, 1, '2018-08-08 13:38:18', '签到');
INSERT INTO `score_record` VALUES (4, 19, 2, '2018-08-09 10:41:08', '签到');
INSERT INTO `score_record` VALUES (5, 6, 1, '2018-08-11 20:07:49', '签到');
INSERT INTO `score_record` VALUES (6, 6, 2, '2018-08-12 17:37:25', '签到');
INSERT INTO `score_record` VALUES (7, 6, 3, '2018-08-13 18:30:55', '签到');
INSERT INTO `score_record` VALUES (8, 8, 1, '2018-08-13 19:18:59', '签到');
INSERT INTO `score_record` VALUES (9, 8, 100, '2018-08-14 17:49:05', '分享文章（asdasd123）');
INSERT INTO `score_record` VALUES (10, 8, -4, '2018-08-14 18:00:00', '兑换视频5（video）');
INSERT INTO `score_record` VALUES (11, 8, -5, '2018-08-14 18:01:14', '兑换视频4（video）');
INSERT INTO `score_record` VALUES (12, 8, -2, '2018-08-14 18:02:04', '兑换视频3（video）');
INSERT INTO `score_record` VALUES (13, 8, 2, '2018-08-14 18:03:50', '签到');
INSERT INTO `score_record` VALUES (14, 18, 1, '2018-08-15 15:13:07', '签到');
INSERT INTO `score_record` VALUES (15, 18, 2, '2018-08-16 10:22:28', '签到');
INSERT INTO `score_record` VALUES (16, 18, 2, '2018-08-16 10:22:28', '签到');
INSERT INTO `score_record` VALUES (17, 18, 2, '2018-08-16 10:22:28', '签到');
INSERT INTO `score_record` VALUES (18, 18, 2, '2018-08-16 10:22:29', '签到');

-- ----------------------------
-- Table structure for wx_admin
-- ----------------------------
DROP TABLE IF EXISTS `wx_admin`;
CREATE TABLE `wx_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_admin
-- ----------------------------
INSERT INTO `wx_admin` VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for wx_article
-- ----------------------------
DROP TABLE IF EXISTS `wx_article`;
CREATE TABLE `wx_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `details` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_article
-- ----------------------------
INSERT INTO `wx_article` VALUES (1, 6, '2018-08-11 21:26:55', '请在此输入标题', '请在此输入正文', '审核未通过');
INSERT INTO `wx_article` VALUES (2, 6, '2018-08-11 21:27:46', '请在此输入标题加加加加加', '请在此输入正文', '审核通过');
INSERT INTO `wx_article` VALUES (4, 8, '2018-08-13 21:41:37', '无标题', '', '审核未通过');
INSERT INTO `wx_article` VALUES (5, 8, '2018-08-15 13:54:48', '悯农', '锄禾日当午\n汗滴禾下土', '待审核');
INSERT INTO `wx_article` VALUES (7, 8, '2018-08-14 16:32:07', 'asdasd123', 'asdasdasd', '审核通过');
INSERT INTO `wx_article` VALUES (9, 18, '2018-08-15 15:06:42', 'sssss', 'ssss', '待审核');
INSERT INTO `wx_article` VALUES (11, 18, '2018-08-15 15:09:49', 'sssssssss', 'sssss', '待审核');

-- ----------------------------
-- Table structure for wx_bought
-- ----------------------------
DROP TABLE IF EXISTS `wx_bought`;
CREATE TABLE `wx_bought`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `goodsid` int(11) NOT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` int(11) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_bought
-- ----------------------------
INSERT INTO `wx_bought` VALUES (1, 8, 5, '2018-08-14 18:00:00', 'video', 'y0743cd8qwf', 4, '视频教程系列', '/img/1.jpg', '视频5');
INSERT INTO `wx_bought` VALUES (2, 8, 4, '2018-08-14 18:01:15', 'video', 'y0743cd8qwf', 5, '视频教程系列', '/img/1.jpg', '视频4');
INSERT INTO `wx_bought` VALUES (3, 8, 3, '2018-08-14 18:02:05', 'video', 'y0743cd8qwf', 2, '视频教程系列', '/img/1.jpg', '视频3');

-- ----------------------------
-- Table structure for wx_diary
-- ----------------------------
DROP TABLE IF EXISTS `wx_diary`;
CREATE TABLE `wx_diary`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `bp_high` int(11) NULL DEFAULT NULL,
  `bp_low` int(11) NULL DEFAULT NULL,
  `gls` int(11) NULL DEFAULT NULL,
  `gls_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `weight` float NULL DEFAULT NULL,
  `upd` int(255) NULL DEFAULT NULL,
  `mood` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `medicine` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_diary
-- ----------------------------
INSERT INTO `wx_diary` VALUES (1, 6, '2018-08-11 20:22:45', 123, 123, 23, '早餐前', 80, 1231, '沮丧', '1231');
INSERT INTO `wx_diary` VALUES (2, 6, '2018-08-11 20:24:18', 123, 123, 23, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (3, 6, '2018-08-12 17:46:05', 123, 50, 23, '午餐前', 123, 1231, '沮丧', '1231');
INSERT INTO `wx_diary` VALUES (5, 8, '2018-08-13 19:50:16', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (6, 8, '2018-08-13 19:50:19', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (7, 8, '2018-08-13 19:50:21', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (8, 8, '2018-08-13 19:50:25', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (9, 8, '2018-08-13 19:50:28', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (10, 8, '2018-08-13 19:50:30', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (11, 8, '2018-08-13 19:50:34', 123, 123, 13, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (12, 8, '2018-08-13 20:15:09', NULL, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (13, 8, '2018-08-13 20:15:11', NULL, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (14, 8, '2018-08-13 20:15:14', NULL, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (15, 8, '2018-08-13 20:15:16', NULL, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (16, 8, '2018-08-13 20:15:19', NULL, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (18, 8, '2018-08-13 20:56:53', 123, 123, 23, '睡觉前', 123, 123, '开心', '12345');
INSERT INTO `wx_diary` VALUES (19, 8, '2018-08-14 16:16:13', 123, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (20, 8, '2018-08-14 16:16:25', NULL, NULL, NULL, '早餐前', 123, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (21, 8, '2018-08-14 16:19:13', 122, 122, 12, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (22, 8, '2018-08-14 16:28:13', 123, 123, 12, '早餐前', 123, 123, '沮丧', '123');
INSERT INTO `wx_diary` VALUES (23, 17, '2018-08-15 14:44:17', NULL, NULL, NULL, '早餐前', NULL, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (24, 17, '2018-08-15 14:45:18', 222, 56, NULL, '早餐前', NULL, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (25, 17, '2018-08-15 14:47:02', 89, 89, 5, '早餐前', 56, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (26, 17, '2018-08-15 14:47:14', 96, 56, 4, '早餐前', 45, 45, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (27, 17, '2018-08-15 14:56:02', NULL, NULL, NULL, '早餐前', NULL, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (28, 17, '2018-08-15 14:56:29', NULL, NULL, NULL, '早餐前', 45, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (29, 17, '2018-08-15 14:56:49', NULL, NULL, NULL, '早餐前', NULL, NULL, '沮丧', NULL);
INSERT INTO `wx_diary` VALUES (30, 18, '2018-08-15 15:01:24', NULL, NULL, NULL, '早餐前', 45, NULL, '沮丧', NULL);

-- ----------------------------
-- Table structure for wx_goods
-- ----------------------------
DROP TABLE IF EXISTS `wx_goods`;
CREATE TABLE `wx_goods`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `price` int(10) NULL DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_goods
-- ----------------------------
INSERT INTO `wx_goods` VALUES (1, 'video', 'y0743cd8qwf', '视频教程系列', 0, '/img/1.jpg', '视频1');
INSERT INTO `wx_goods` VALUES (2, 'video', 'y0743cd8qwf', '视频教程系列', 0, '/img/1.jpg', '视频2');
INSERT INTO `wx_goods` VALUES (3, 'video', 'y0743cd8qwf', '视频教程系列', 2, '/img/1.jpg', '视频3');
INSERT INTO `wx_goods` VALUES (4, 'video', 'y0743cd8qwf', '视频教程系列', 5, '/img/1.jpg', '视频4');
INSERT INTO `wx_goods` VALUES (5, 'video', 'y0743cd8qwf', '视频教程系列', 4, '/img/1.jpg', '视频5');
INSERT INTO `wx_goods` VALUES (7, 'video', 's0755qses5s', 'This is a test video', 0, '/img/test111.png', 'MyTest');

-- ----------------------------
-- Table structure for wx_medicine
-- ----------------------------
DROP TABLE IF EXISTS `wx_medicine`;
CREATE TABLE `wx_medicine`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `details` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_medicine
-- ----------------------------
INSERT INTO `wx_medicine` VALUES (1, '阿司匹林', '/img/medicine_no_img.jpg', '【药品名称】阿司匹林\r\n\r\n【适应症】\r\n1、降低急性心肌梗死疑似患者的发病风险\r\n2、预防心肌梗死复发\r\n3、中风的二级预防\r\n4、降低短暂性脑缺血发作(TIA)及其继发脑卒中的风险\r\n5、降低稳定性和不稳定性心绞痛患者的发病风险\r\n6、动脉外科手术或介入手术后，如经皮冠脉腔内成形术(PTCA)，冠状动脉旁路术(CABG)，颈动脉内膜剥离术，动静脉分流术\r\n7、预防大手术后深静脉血栓和肺栓塞\r\n8、降低心血管危险因素者(冠心病家族史、糖尿病、血脂异常、高血压、肥胖、抽烟史、年龄大于50岁者)心肌梗死发作的风险。\r\n\r\n【用法用量】\r\n用法：口服。肠溶片应饭前用适量水送服。\r\n1、降低急性心肌梗死疑似患者的发病风险：建议首次剂量300mg，嚼碎后服用以快速吸收。以后每天100-200mg。\r\n2、预防心肌梗死复发：每天100-300mg。\r\n3、中风的二级预防：每天100-300mg。\r\n4、降低短暂性脑缺血发作(TIA)及其继发脑卒中的风险：每天100-300mg。\r\n5、降低稳定性和不稳定性心绞痛患者的发病风险：每天100-300mg。\r\n6、动脉外科手术或介入手术后，如经皮冠脉腔内成形术(PTCA)，冠状动脉旁路术(CABG)，颈动脉内膜剥离术，动静脉分流术：每天100-300mg。\r\n7、预防大手术后深静脉血栓和肺栓塞：每天100-200mg。\r\n8、降低心血管危险因素者(冠心病家族史、糖尿病、血脂异常、高血压、肥胖、抽烟史、年龄大于50岁者)心肌梗死发作的风险：每天100mg。\r\n\r\n【注意事项】\r\n下列情况时使用阿司匹林应谨慎：\r\n1、对止痛药/抗炎药抗风湿药过敏，或存在其它过敏反应。\r\n2、胃十二指肠溃疡史，包括慢性溃疡、复发性溃疡、胃肠道出血史。\r\n3、与抗凝药合用。\r\n4、对于肾功能或心血管循环受损的患者(例如，肾血管性疾病、充血性心衰，血容量不足、大手术、败血症或严重出血性事件)。\r\n5、对于严重葡萄糖-6-磷酸脱氢酶(G6PD)缺乏症患者，可增加溶血风险的因素如高剂量、发热和急性感染。\r\n6、肝功能损害；\r\n7、如合用阿司匹林和布洛芬，应咨询医生。\r\n8、阿司匹林可能导致支气管痉挛并引起哮喘发作或其它过敏反应。危险因素包括支气管哮喘，花粉热，鼻息肉，或慢性呼吸道感染。这也适用于对其它物质有过敏反应的患者(例如皮肤反应、瘙痒、风疹)。\r\n9、可能导致手术中或手术后增加出血。\r\n10、低剂量阿司匹林减少尿酸的消除，可诱发痛风。\r\n\r\n【不良反应】\r\n1、上、下胃肠道不适，如消化不良、胃肠道和腹部疼痛。罕见的胃肠道炎症、胃十二指肠溃疡。非常罕见的可能出现胃肠道出血和穿孔，伴有实验室异常和临床症状。\r\n2、阿司匹林可能增加出血的风险。\r\n3、严重葡萄糖-6-磷酸脱氨酶(G6PD)缺乏症患者出现溶血和溶血性贫血。\r\n4、肾损伤和急性肾衰竭。\r\n5、过敏反应伴有相应实验室异常和临床症状，包括哮喘症状，轻度至中度的皮肤反应。\r\n6、呼吸道、胃肠道和心血管系统，包括皮疹，荨麻疹，水肿，瘙痒症，心血管-呼吸系统不适，极罕见的严重反应包括过敏性休克。\r\n7、极罕见的一过性肝损害伴肝转氨酶升高。\r\n8、药物过量时曾报道头晕和耳鸣。\r\n\r\n【禁忌】\r\n下列情况禁用阿司匹林肠溶片：\r\n1、对阿司匹林或其它水杨酸盐，或药品的任何其它成份过敏；\r\n2、水杨酸盐或含水杨酸物质、非甾体抗炎药导致哮喘的历史；\r\n3、急性胃肠道溃疡；\r\n4、出血体质；\r\n5、严重的肾功能衰竭；\r\n6、严重的肝功能衰竭；\r\n7、严重的心功能衰竭；\r\n8、与氨甲蝶呤(剂量为15mg/周或更多)合用；\r\n9、妊娠的最后三个月。\r\n\r\n【贮存方式】\r\n未拆封或已拆封：密封，干燥，25℃\r\n');
INSERT INTO `wx_medicine` VALUES (2, '阿司匹林', '/img/medicine_no_img.jpg', '【药品名称】阿司匹林【药品名称】阿司匹林\r\n\r\n【适应症】\r\n1、降低急性心肌梗死疑似患者的发病风险\r\n2、预防心肌梗死复发\r\n3、中风的二级预防\r\n4、降低短暂性脑缺血发作(TIA)及其继发脑卒中的风险\r\n5、降低稳定性和不稳定性心绞痛患者的发病风险\r\n6、动脉外科手术或介入手术后，如经皮冠脉腔内成形术(PTCA)，冠状动脉旁路术(CABG)，颈动脉内膜剥离术，动静脉分流术\r\n7、预防大手术后深静脉血栓和肺栓塞\r\n8、降低心血管危险因素者(冠心病家族史、糖尿病、血脂异常、高血压、肥胖、抽烟史、年龄大于50岁者)心肌梗死发作的风险。\r\n\r\n【用法用量】\r\n用法：口服。肠溶片应饭前用适量水送服。\r\n1、降低急性心肌梗死疑似患者的发病风险：建议首次剂量300mg，嚼碎后服用以快速吸收。以后每天100-200mg。\r\n2、预防心肌梗死复发：每天100-300mg。\r\n3、中风的二级预防：每天100-300mg。\r\n4、降低短暂性脑缺血发作(TIA)及其继发脑卒中的风险：每天100-300mg。\r\n5、降低稳定性和不稳定性心绞痛患者的发病风险：每天100-300mg。\r\n6、动脉外科手术或介入手术后，如经皮冠脉腔内成形术(PTCA)，冠状动脉旁路术(CABG)，颈动脉内膜剥离术，动静脉分流术：每天100-300mg。\r\n7、预防大手术后深静脉血栓和肺栓塞：每天100-200mg。\r\n8、降低心血管危险因素者(冠心病家族史、糖尿病、血脂异常、高血压、肥胖、抽烟史、年龄大于50岁者)心肌梗死发作的风险：每天100mg。\r\n\r\n【注意事项】\r\n下列情况时使用阿司匹林应谨慎：\r\n1、对止痛药/抗炎药抗风湿药过敏，或存在其它过敏反应。\r\n2、胃十二指肠溃疡史，包括慢性溃疡、复发性溃疡、胃肠道出血史。\r\n3、与抗凝药合用。\r\n4、对于肾功能或心血管循环受损的患者(例如，肾血管性疾病、充血性心衰，血容量不足、大手术、败血症或严重出血性事件)。\r\n5、对于严重葡萄糖-6-磷酸脱氢酶(G6PD)缺乏症患者，可增加溶血风险的因素如高剂量、发热和急性感染。\r\n6、肝功能损害；\r\n7、如合用阿司匹林和布洛芬，应咨询医生。\r\n8、阿司匹林可能导致支气管痉挛并引起哮喘发作或其它过敏反应。危险因素包括支气管哮喘，花粉热，鼻息肉，或慢性呼吸道感染。这也适用于对其它物质有过敏反应的患者(例如皮肤反应、瘙痒、风疹)。\r\n9、可能导致手术中或手术后增加出血。\r\n10、低剂量阿司匹林减少尿酸的消除，可诱发痛风。\r\n\r\n【不良反应】\r\n1、上、下胃肠道不适，如消化不良、胃肠道和腹部疼痛。罕见的胃肠道炎症、胃十二指肠溃疡。非常罕见的可能出现胃肠道出血和穿孔，伴有实验室异常和临床症状。\r\n2、阿司匹林可能增加出血的风险。\r\n3、严重葡萄糖-6-磷酸脱氨酶(G6PD)缺乏症患者出现溶血和溶血性贫血。\r\n4、肾损伤和急性肾衰竭。\r\n5、过敏反应伴有相应实验室异常和临床症状，包括哮喘症状，轻度至中度的皮肤反应。\r\n6、呼吸道、胃肠道和心血管系统，包括皮疹，荨麻疹，水肿，瘙痒症，心血管-呼吸系统不适，极罕见的严重反应包括过敏性休克。\r\n7、极罕见的一过性肝损害伴肝转氨酶升高。\r\n8、药物过量时曾报道头晕和耳鸣。\r\n\r\n【禁忌】\r\n下列情况禁用阿司匹林肠溶片：\r\n1、对阿司匹林或其它水杨酸盐，或药品的任何其它成份过敏；\r\n2、水杨酸盐或含水杨酸物质、非甾体抗炎药导致哮喘的历史；\r\n3、急性胃肠道溃疡；\r\n4、出血体质；\r\n5、严重的肾功能衰竭；\r\n6、严重的肝功能衰竭；\r\n7、严重的心功能衰竭；\r\n8、与氨甲蝶呤(剂量为15mg/周或更多)合用；\r\n9、妊娠的最后三个月。\r\n\r\n【贮存方式】\r\n未拆封或已拆封：密封，干燥，25℃\r\n');

-- ----------------------------
-- Table structure for wx_pop
-- ----------------------------
DROP TABLE IF EXISTS `wx_pop`;
CREATE TABLE `wx_pop`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `count` int(255) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_pop
-- ----------------------------
INSERT INTO `wx_pop` VALUES (1, '薛晓波', 5);
INSERT INTO `wx_pop` VALUES (6, '孙家辉', 0);
INSERT INTO `wx_pop` VALUES (7, 'test', 0);

-- ----------------------------
-- Table structure for wx_recipe
-- ----------------------------
DROP TABLE IF EXISTS `wx_recipe`;
CREATE TABLE `wx_recipe`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `material` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `method` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `suitpeople` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `img` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vid` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 193 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_recipe
-- ----------------------------
INSERT INTO `wx_recipe` VALUES (1, '番茄烩青鱼丸', '青鱼、番茄', '烩', '肾病、糖尿病、高血压、高血脂、慢性胃炎', '/img/recipe_no_img.jpg', 'y0743cd8qwf');
INSERT INTO `wx_recipe` VALUES (2, '彩椒茭白鸡丝', '鸡胸肉、茭白、彩椒', '炒', '糖尿病、高血脂、高血压、肝炎、酒精中毒、肿瘤', '/img/recipe_no_img.jpg', 'y0743cd8qwf');
INSERT INTO `wx_recipe` VALUES (3, '木耳山药炒鸡片', '鸡胸肉、山药、木耳炒', '炒', '高血糖、高血压、高血脂、肥胖、肿瘤、慢性胃肠炎', '/img/recipe_no_img.jpg', NULL);
INSERT INTO `wx_recipe` VALUES (4, '大蒜烧黄鳝', '黄鳝、大蒜', '烧', '肾脏病、糖尿病、高血压及高脂血症患者', '/img/recipe_no_img.jpg', NULL);
INSERT INTO `wx_recipe` VALUES (5, '蒜叶鸭血烩豆腐', '鸭血、猪瘦肉、豆腐', '烩', '缺铁性贫血等患者', '/img/recipe_no_img.jpg', NULL);
INSERT INTO `wx_recipe` VALUES (6, '土豆炖牛肉', '牛肉、土豆、胡萝卜', '炖', '慢性肾病，糖尿病，贫血等患者', '/img/recipe_no_img.jpg', NULL);
INSERT INTO `wx_recipe` VALUES (7, '香菇蒸鸡腿', '鸡腿肉、香菇、', '蒸', '糖尿病、肿瘤、术后康复期患者', '/img/recipe_no_img.jpg', NULL);
INSERT INTO `wx_recipe` VALUES (8, '芦笋炒蘑菇', '芦笋、蘑菇', '炒', '糖尿病、高血压、高血脂、肿瘤、肥胖、便秘', '/img/recipe_no_img.jpg', NULL);
INSERT INTO `wx_recipe` VALUES (9, '西芹炒百合', '西芹、百合', '炒', '高血压、高血脂、高血糖、肥胖、便秘、更年期综合征', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (10, '蒜蓉拌苦瓜', '苦瓜、大蒜', '拌', '肥胖、高血压、高血脂、高血糖、高胆固醇、肿瘤', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (11, '韭菜虾仁水晶饼', NULL, NULL, '慢性肾脏病、便秘、肠癌、高血脂和高血压患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (12, '葱烧海参', NULL, '烧', '糖尿病、高血压、冠心病、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (13, '肉末蒸茄子', '茄子、猪瘦肉', '蒸', '高血压、高血脂、糖尿病以及便秘', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (14, '丝瓜炒鸡蛋', '鸡蛋、丝瓜', '炒', '肾脏病、糖尿病、高血脂、高血压、慢性胃炎、冠心病、水肿', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (15, '四喜丸子', '猪五花肉、莲藕', '烧', '缺铁性贫血、瘦弱、食欲不振以及癌症患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (16, '红烧带鱼', '带鱼', '烧', '肾脏病、糖尿病、高血脂、高血压、营养不良、产后乳汁不足等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (17, '凉拌黑木耳', '黑木耳、大蒜', '拌', '高血压、高脂血症、糖尿病、缺铁性贫血、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (18, '凉拌金针菇', '金针菇、大蒜、', '拌', '高血糖、高血压、高血脂、便秘、癌症患者以及儿童、孕妇、老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (19, '木耳莴苣炒肉片', '黑木耳、猪里脊肉、莴苣', '炒', '肾脏病、糖尿病、贫血、肿瘤等患者以及正常人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (20, '清炒手撕包菜', '卷心菜', '炒', '糖尿病、高血脂、高血压、心脏病、巨幼红细胞性贫血、胃溃疡患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (21, '口蘑烧鸡翅根', '鸡翅、口蘑', '烧', '高血压、糖尿病、癌症患者以及病中、病后虚弱者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (22, '彩椒杏鲍菇绘鸡丁', '彩椒、杏鲍菇、鸡胸肉', '烩', '高血压、高脂血症、糖尿病、肿瘤患者、超重肥胖人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (23, '萝卜杏仁炖猪肺', '猪肺、南杏仁、白萝卜', '炖', '慢性支气管炎、肿瘤、营养不良及术后虚弱患者、发育期青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (24, '苦瓜酿牛肉', '牛肉、苦瓜', '蒸', '高血压、高血脂、高胆固醇、超重肥胖以及肿瘤患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (25, '土豆烧麻鸭', '麻鸭、土豆', '烧', '高血压、高脂血症、糖尿病、慢性肾脏病、儿童、孕妇及老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (26, '四季豆炒猪心', '猪心、四季豆', '炒', '高血压、糖尿病、便秘、缺铁性贫血、妇幼人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (27, '韭菜炒螺丝', '螺蛳、韭菜', '炒', '高血压、高血脂、糖尿病以及便秘', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (28, '茄汁鱼片', '草鱼、番茄沙司', '烧', '食欲不振、营养不良、免疫力低下、妇幼及老年人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (29, '昂刺鱼烧豆腐', '昂刺鱼、豆腐', '烧', '高血压、高脂血症、糖尿病、肿瘤患者、孕妇、儿童及老年人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (30, '洋葱炒猪耳', '猪耳、洋葱', '炒', '孕产妇、食欲不振、糖尿病、肿瘤患者食用', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (31, '乌鸡炖甲鱼', '乌鸡、甲鱼', '炖', '营养不良、低蛋白血症、骨质疏松、缺铁性贫血症等患者及产妇、乳母', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (32, '韭菜苔炒鸡丝', '韭菜苔、鸡脯肉', '炒', '超重/肥胖、高脂血症、高血压、糖尿病、冠心病等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (33, '魔芋豆腐烧鸡腿', '魔芋豆腐、鸡腿', '烧', '超重/肥胖、便秘、糖尿病、高血压、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (34, '茼蒿拌鸡丝', '茼蒿、鸡脯肉', '拌', '超重/肥胖、便秘、高血压、糖尿病、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (35, '西红柿浇汁鳕鱼', '鳕鱼、西红柿', '煎', '营养不良、肾脏病、高血压、糖尿病、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (36, '西芹炒鸡柳', '鸡脯肉、西芹、胡萝卜', '炒', '慢性肾脏病，超重或肥胖、高血压、糖尿病、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (37, '玉米粒炒杏鲍菇', '杏鲍菇、鲜玉米粒', '炒', '超重/肥胖、糖尿病、高脂血症、高血压、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (38, '彩椒毛豆炒肉丝', '彩椒、毛豆、猪里脊肉', '炒', '肿瘤、孕期贫血、低蛋白血症、糖尿病、高脂血症、高血压等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (39, '糖醋藕带', '藕带', '炒', '高血压、高脂血症、营养不良、胃口不佳等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (40, '海带拌腐竹', '海带丝、腐竹', '拌', '高血压、高血脂症、糖尿病、超重、肥胖、便秘等患者及易缺碘人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (41, '丝瓜炒干贝', '丝瓜、干贝', '炒', '高血压、糖尿病、超重肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (42, '萝卜丝鲫鱼汤', '白萝卜、鲫鱼', '煮', '营养不良、低蛋白血症、肿瘤等患者及产后乳母人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (43, '苦瓜焖鸡翅', '苦瓜、鸡翅', '焖', '高血压、高脂血症、糖尿病、营养不良、食欲不振等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (44, '豇豆肉末烧茄子', '豇豆、猪肉、茄汁', '烧', '肾脏病、高血压、高血脂、高血糖、肥胖、心血管疾病、动脉硬化等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (45, '核桃炒肉丁', '猪里脊、生核桃仁', '炒', '缺铁性贫血症、低蛋白血症、营养不良等患者及孕产妇', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (46, '杏仁拌苦瓜', '杏仁、苦瓜', '拌', '高血压、高脂血症、糖尿病，肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (47, '虾皮焖冬瓜', '虾皮、冬瓜', '焖', '高血压、糖尿病、高脂血症、骨质疏松、超重/肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (48, '莴笋片炒蛤蜊肉', '莴笋、蛤蜊', '炒', '高血压、高血脂、糖尿病、肥胖等患者及儿童、孕妇', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (49, '黑豆烧麻油鸡翅', '黑豆、鸡翅中', '烧', '糖尿病、高血压、高脂血症、营养不良、食欲不振等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (50, '红豆麻鸭汤', '红豆、麻鸭', '炖', '糖尿病、高血压、高脂血症、低蛋白血症、营养不良、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (51, '空心菜炒玉米粒', '空心菜、玉米', '炒', '高脂血症、高血压、糖尿病、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (52, '莲藕烧鳝鱼', '鳝鱼、莲藕', '烧', '高血压、糖尿病、肾脏病、肿瘤、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (53, '苦瓜煲鹌鹑', '苦瓜、鹌鹑', '烧', '肾脏病、糖尿病、高血压、高脂血症、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (54, '韭菜炒绿豆芽', '韭菜、绿豆芽', '炒', '高脂血症、高血压、糖尿病、肥胖、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (55, '板栗炒芹菜', '板栗、 芹菜', '炒', ' 高脂血症、高血压、糖尿病、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (56, '南瓜炒百合', '南瓜、百合', '炒', '肥胖、冠心病、便秘、高血压、高血脂等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (57, '素炒杏鲍菇', '胡萝卜、鸡腿菇', '炒', '高脂血症、高血压、糖尿病、超重/肥胖、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (58, '口蘑拌花生仁', '口蘑、花生仁', '拌', NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (59, '胡萝卜牛肉汤', '牛肉、胡萝卜', '烧', '缺铁性贫血、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (60, '西兰花炒虾仁', '西兰花、虾仁', '炒', '高血压、高脂血症、糖尿病、动脉粥样硬化、肿瘤、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (61, '苦瓜绿豆汤', '苦瓜、绿豆', '烧', NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (62, '洋葱炒芦笋', '洋葱、芦笋', '炒', '糖尿病、高血压、高血脂、肿瘤、便秘、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (63, '南瓜炒鸡蛋', '南瓜、鸡蛋', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (64, '虾仁豆腐蒸水蛋', '豆腐、虾仁、鸡蛋', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (65, '紫菜肉丸汤', '紫菜、猪瘦肉', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (66, '木耳荷兰豆炒虾仁', '木耳、荷兰豆、虾仁', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (67, '秋葵小炒肉', '秋葵、', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (68, '洋葱炒土豆片', '洋葱、土豆', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (69, '蟹味菇拌萝卜丝', '蘑菇、萝卜', NULL, NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (70, '清蒸鲈鱼', '鲈鱼', '蒸', '慢性肾病、糖尿病、冠心病、超重或肥胖', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (71, '糖醋排骨', '排骨、罗汉果', '炒', '慢性肾病、糖尿病、贫血、营养不良等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (72, '蒜蓉粉丝蒸大虾', '基围虾、大蒜、粉丝', '蒸', '慢性肾病患者，老年人等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (73, '莴笋炒鸡丁', '鸡胸肉、莴笋', '炒', '慢性肾炎、糖尿病、高血压、高血脂等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (74, '西兰花炒牛柳', '牛里脊、西兰花', '炒', '慢性肾病、糖尿病、贫血、肿瘤患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (75, '虾仁木耳滑蛋', '基围虾、木耳、鸡蛋', '炒', '慢性肾脏病、糖尿病、高血脂、超重肥胖等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (76, '凉拌莴笋坚果', '莴笋、花生、腰果、杏仁', '拌', '适合高血压、糖尿病、高脂血症、孕妇以及儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (77, '山药炒木耳', '木耳、山药', '炒', '糖尿病、高脂血症、心血管疾病患者以及矿工、纺织工人等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (78, '西兰花炒双菇', '西兰花、香菇、杏鲍菇', '炒', '糖尿病、高血压、血脂异常、癌症、肥胖和超重', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (79, '茶香虾仁', '基围虾、绿茶', '炒', '慢性肾病、高血脂、心血管疾病以及超重和肥胖人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (80, '荔枝肉', '荸荠、猪瘦肉', '炒', '肾脏病患者、高血压、缺铁性贫血患者以及产妇等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (81, '剁椒蒸鱼头', '鱼头、青红椒', '蒸', '普通人群，营养不良者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (82, '凉拌茄子', '茄子', '拌', '高血压、高血糖、高血脂、心血管疾病以及动脉硬化患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (83, '凤尾豆腐', '基围虾、豆腐', '蒸', '慢性肾病、高血糖、高血脂等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (84, '口蘑茨菇焖猪肉', '猪瘦肉、口蘑、茨菰', '焖', '高血压、高血糖、癌症患者、缺铁性贫血', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (85, '青椒茄子烧土豆', '青椒、茄子、土豆', '烧', '糖尿病、肿瘤患者、胃口不佳以及正在发育的儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (86, '葱爆羊肉丁', '瘦羊肉、葱', '炒', '高血压、血脂异常、肿瘤患者、肾脏病患者以及食欲不振人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (87, '糯米荷叶蒸鸡', '鸡肉、荷叶、糯米、虾仁、腊肠', '蒸', '正在发育的儿童青少年、食欲不振等儿童', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (88, '鸡汁干丝', '干丝、鸡肉、虾仁', '煮', '血脂异常、糖尿病、心血管疾病、肾脏患者等各类人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (89, '红烧鲤鱼', '鲤鱼', '烧', '肾脏病、血脂异常、正在生长发育的儿童青少年以及老年人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (90, '三色蒸蛋', '鸡蛋、咸鸭蛋、皮蛋', '蒸', '胃口不佳及一般人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (91, '芦笋百合炒白果', '芦笋、百合、白果', '炒', '高血脂、高血压、心脑血管疾病、肿瘤患者以及中老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (92, '排骨南瓜盅', '南瓜、猪小排', '蒸', '慢性肾病、食欲不振患者以及正在生长发育的儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (93, '莴苣拌牛百叶', '百叶、莴苣', '拌', '血脂异常、糖尿病及肿瘤患者食用', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (94, '菠菜粉丝炒鸡蛋', '菠菜、鸡蛋、粉丝', '炒', '肾脏病、高血压、儿童青少年以及老年人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (95, '凉拌五彩大拉皮', '拉皮、胡萝不、黄瓜、木耳等', '拌', '肾脏病、血脂异常、高血压、肿瘤患者、儿童青少年以及更年期女性食', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (96, '海带排骨汤', '猪小排、海带', '烧', '肾脏病、高血压、糖尿病、甲状腺以及肿瘤患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (97, '小米蒸排骨', '猪小排、小米、土豆', '蒸', ' 食欲不振、贫血、肿瘤患者以及正处于生长发育期儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (98, '炖三菌', '平菇、草菇、口蘑', '炖', '糖尿病、高血脂、高血压、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (99, '猴头菇油菜心', '猴头菇、油菜、番茄', '炒', '糖尿病、高血压、高血脂、肥胖、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (100, '胡萝卜羊排汤', '羊排', '煮', '营养不良、贫血等患者及儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (101, '口蘑烧冬瓜', '口蘑、冬瓜', '烧', '肾脏病、糖尿病、高血压、高血脂及肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (102, '凉拌五彩鸡丝', '鸡脯肉、胡萝卜、金针菇', '拌', '肾脏病、糖尿病、高血压、高血脂、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (103, '娃娃菜蛤蜊鸡汤', '娃娃菜、蛤蜊、鸡汤', '煮', ' 糖尿病、肥胖、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (104, '竹荪笋干鸭腿汤', '竹荪、笋干、鸭腿', '炖', '糖尿病、肾脏病、肿瘤、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (105, '口蘑汆小肉丸', '猪瘦肉、鲜蘑、菜心', '煮', '贫血、肿瘤、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (106, '冬瓜烧鸡腿', '鸡腿、冬瓜', '烧', '高血压、糖尿病、高脂血症、肾脏病以及肥胖患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (107, '白果鸡丁', '白果、鸡丁', '炒', '糖尿病、高血脂、高血压、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (108, '凉拌海蜇萝卜丝', '海蜇、胡萝卜', '拌', '糖尿病、高血脂、高血压、心血管疾病、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (109, '黄豆猪蹄汤', '黄豆、猪蹄', '煮', ' 营养不良、乳母、孕妇等人群 ', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (110, '莲藕黑豆汤', '莲藕、黄豆', '煮', '高血压、高血脂、糖尿病、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (111, '南瓜清炖牛肉', '南瓜、牛肉', '烧', '高血脂、高血压、肾脏病、贫血等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (112, '乌鸡炖山药', '乌鸡、山药', '烧', '糖尿病、高血脂、营养不良、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (113, '鸭肉炖白菜', '鸭肉、白菜', '烧', NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (114, '洋葱圈煎蛋', '洋葱、鸡蛋', '煎', '糖尿病、高血压、高血脂、肾脏病及肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (115, '银芽鸡丝', '绿豆芽、鸡胸肉、青椒', '炒', '肾脏病、糖尿病、高血压、高血脂、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (116, '清汤肉圆', '肥瘦猪肉、荸荠、鸡蛋', '煮', '营养不良患者、胃口不佳者以及正在发育的儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (117, '栗子烧鸡', '板栗、鸡肉', '烧', '糖尿病、高血压、高脂血症、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (118, '芦笋腰果炒虾仁', '基围虾、芦笋、腰果', '炒', '高脂血症、动脉粥样硬化、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (119, '青椒炒肉丝', '猪瘦肉、青椒', '炒', '消瘦、贫血、慢性萎缩性胃炎等营养不良患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (120, '红烧猪蹄', '猪蹄', '烧', '低脂血症、能量缺乏型营养不良、夜盲症及毛囊角化症等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (121, '腐乳空心菜', '空心菜、腐乳', '炒', '便秘、高脂血症、高血压、血糖代谢异常人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (122, '西红柿炖牛腩', '牛腩、西红柿', '炖', '超重、肥胖、孕期贫血、低蛋白血症等', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (123, '肉末蒸豆腐', '猪肉、豆腐', '蒸', '免疫力低下的儿童、老年人以及贫血人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (124, '山药燕麦蒸饭', NULL, NULL, '超重/肥胖、糖耐量异常、高脂血症、高血压及便秘人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (125, '香椿炒鸡蛋', '鸡蛋、香椿', '炒', '便秘、青少年及各年龄层的女性群体', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (126, '柠檬蒸石斑鱼', NULL, '蒸', '食欲不佳、产后妇女及老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (127, '凉拌秋葵', '秋葵', '拌', '超重/肥胖、妊娠期糖尿病、糖耐量异常、老年慢性病', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (128, '爆炒猪肝', '猪肝、青、红椒', '炒', '糖尿病、贫血、妇幼及老年人等群体', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (129, '葱香蛏子', '蛏子', '煮', '血糖或血脂代谢异常、瘦弱及免疫力低下人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (130, '干丝炒肉丝', '猪里脊、干丝', '炒', '缺铁性贫血、便秘、糖尿病、高脂血症、妇幼及老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (131, '秋葵炒蛋', '秋葵、鸡蛋', '炒', '青少年、妇女、超重/肥胖、糖尿病、高脂血症、老年慢性病', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (132, '肉末粉丝', '猪里脊、粉丝', '炒', '慢性肾脏病人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (133, '豌豆炒牛肉粒', '豌豆、牛里脊肉', '炒', '贫血、便秘、儿童青少年、孕妇及老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (134, '蒜苔木耳炒鸡蛋', '蒜薹、木耳、鸡蛋', '炒', '高脂血症、糖尿病等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (135, '双耳炒黄瓜', '黑木耳、银耳、黄瓜', '炒', '糖尿病、高血压、高脂血症、超重、肥胖、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (136, '山楂烧豆腐', '北豆腐、山楂', '烧', '糖尿病、高血压、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (137, '菠菜炒绿豆芽', '绿豆芽、菠菜', '炒', '高血压、高脂血症、动脉粥样硬化、血糖异常、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (138, '肉丁炒蚕豆', '猪里脊、蚕豆', '炒', '低蛋白血症、糖尿病、贫血、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (139, '回锅肉', '五花肉、青蒜', '炒', '营养不良、贫血等患者及儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (140, '糖醋里脊', '猪里脊、鸡蛋', '炸', '慢性肾病、缺铁性贫血等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (141, '猪肉炖粉条', '猪肉、粉条', '炖', '慢性肾脏衰竭等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (142, '鱼香肉丝', '猪五花、笋', '炒', '缺铁性贫血患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (143, '南瓜烧排骨', '南瓜、猪小排', '烧', '贫血、瘦弱、营养不良等患者及儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (144, '素炒三丝', '绿豆芽、胡萝卜、青椒', '炒', '肥胖、便秘、糖尿病、高血压、高脂血症等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (145, '豆腐皮炒鸡毛菜', '豆腐皮、鸡毛菜', '拌', '糖尿病、高脂血症、超重/肥胖人群、儿童青少年及老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (146, '裙带菜豆腐汤', '裙带菜、豆腐汤', '煮', '糖尿病、高脂血症、中老年慢性病等患者以及儿童少年等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (147, '西红柿炒洋葱', '西红柿、洋葱', '炒', '糖尿病、高血压、心血管疾病及超重、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (148, '西葫芦炒肚片', '西葫芦、猪肚', '炒', '糖尿病、高血压等患者及儿童青少年、孕产妇', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (149, '草菇烩芦笋', '草菇、芦笋', '烩', '糖尿病、高血压、高脂血症、超重、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (150, '彩椒炒猪腰', '彩椒、猪腰', '炒', '糖尿病、肥胖等患者及儿童青少年、老年等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (151, '五彩鸡肉粒', '鸡肉、百合、青豆、胡萝卜、松子仁', '拌', '糖尿病、高血压、便秘等患者及儿童青少年、老年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (152, '鸭肉炒菌菇', '鸭肉、香菇、白玉菇', '炒', '糖尿病、高血压、高脂血症、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (153, '番茄炒扇贝', '番茄、扇贝', '炒', '高血脂、高胆固醇以及消耗性疾病等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (154, '黄瓜炖泥鳅', '老黄瓜、泥鳅', '炖', '糖尿病、低蛋白血症、心血管疾病等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (155, '牛肉菠萝盅', '牛肉、菠萝', '炒', '肾脏病、营养不良、贫血、食欲不振等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (156, '清蒸鲳鱼', '鲳鱼', '蒸', '糖尿病、高血压、高脂血症等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (157, '蜜汁芸豆', '芸豆、蜂蜜', '煮', '高脂血症、肥胖、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (158, '海米炒丝瓜', '海米、丝瓜', '炒', '糖尿病、高脂血症、超重/肥胖等患者及儿童青少年', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (159, '木须肉', '猪瘦肉、鸡蛋、木耳', '炒', '慢性肾脏患者、儿童、青少年、孕产妇及老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (160, '文蛤蒸鸡蛋', '文蛤、鸡蛋', '蒸', '儿童，孕妇、乳母以及营养不良、慢性消耗性疾病患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (161, '芹菜炒牛肉丝', '牛肉丝、芹菜', '炒', '虚弱、贫血、高血压、糖尿病、便秘等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (162, '丝瓜烧猪血', '猪血、丝瓜', '烧', '痛风、高尿酸血症，贫血、三高以及减肥人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (163, '青椒木耳炒鸡蛋', '鸡蛋、青椒、木耳', '炒', '痛风及高尿酸血症人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (164, '荷兰豆木耳炒藕片', '莲藕、木耳、荷兰豆、胡萝卜', '炒', '糖尿病、减肥人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (165, '葱烧大排', '排骨、葱', '烧', '营养不良、孕妇、乳母和生长发育期儿童', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (166, '竹笋香菇烧魔芋豆腐', '魔芋、魔芋豆腐，竹笋，鲜香菇，', '烧', '便秘、肥胖或超重、糖尿病及心血管疾病患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (167, '荞麦面鸡肉卷', '荞麦粉、糯米粉、鸡胸肉', '炒', '糖尿病、高血压、高血脂及减肥人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (168, '胡萝卜玉米炖排骨', '排骨、胡萝卜、玉米', '炖', '体质虚弱、营养不良、生长发育期的儿童、孕妇、乳母', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (169, '素炒芋头片', '芋头、青、红椒', '炒', '超重、肥胖、高血压、慢性肾病及低钾血症患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (170, '莲藕海带汤', '莲藕、海带结', '烧', '超重、肥胖、慢性肾病患者以及碘易缺乏人群，如孕妇、乳母、少年儿童', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (171, '西红柿炒山药', '西红柿、山药', '炒', '超重、肥胖、高血压、慢性肾病患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (172, '冬瓜银耳排骨汤', '冬瓜、银耳、排骨', '烧', '营养不良，贫血，肿瘤患者和少年儿童、孕妇、乳母', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (173, '糯米藕圆子', '猪肉末、莲藕、糯米', '蒸', '消瘦、营养不良、肿瘤患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (174, '莴笋玉米炒鸭丁', '莴笋、玉米、鸭脯肉', '炒', '营养不良、高血压、高血脂、糖尿病患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (175, '上汤枸杞娃娃菜', '娃娃菜、鸡脯肉', '烧', '营养不良、食欲不振，青少年儿童、孕妇、乳母、老年人', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (176, '双菇炖豆腐', '香菇、草菇、豆腐', '炖', '动脉粥样硬化、冠心病、糖尿病、高血压、高血脂等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (177, '白萝卜炖鹌鹑', '白萝卜、鹌鹑', '炖', '食欲不振、体质虚弱、营养不良及肿瘤患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (178, '银鱼鸡蛋羹', '银鱼、鸡蛋', '蒸', '糖尿病、体质虚弱、营养不良等患者及儿童、孕妇、乳母等人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (179, '香菇蒸鳕鱼', '鳕鱼、香菇', '蒸', '心血管疾病、糖尿病、肥胖等患者及孕妇、乳母、老年人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (180, '平菇扒菜心', '平菇、油菜心', '炒', '糖尿病、高血压、免疫力低下、肥胖、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (181, '芹菜炒五香豆干', '五香豆干、芹菜、红甜椒', '炒', '高血压、高血脂、糖尿病、便秘等患者及减肥人群', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (182, '蒜蓉西兰花', '西兰花、蒜', '炒', '心血管疾病、脂肪肝、糖尿病、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (183, '番茄乌鱼汤', '番茄、乌鱼', '炖', '慢性肾病、高血压、高血脂、糖尿病、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (184, '双菇墨鱼烧鸡块', '墨鱼、鸡、香菇、金针菇', '烧', '营养不良、肿瘤等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (185, '荸荠炖猪肚汤', '猪肚、荸荠', '炖', '肾脏病、贫血、消瘦、营养不良等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (186, '清蒸绿茶鲫鱼', '鲫鱼', '蒸', '慢性肾病、心脑血管疾病、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (187, '荸荠木耳带鱼汤', '荸荠、木耳、带鱼', '炖', '慢性肾病、高血压、高血脂、冠心病等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (188, '五彩龙利鱼丁', '龙利鱼、火龙果、胡萝卜', '炒', '慢性肾病、高血脂、高血压、便秘等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (189, '清蒸开屏大黄鱼', '黄花鱼', '蒸', '慢性肾病、糖尿病、高血压、高血脂等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (190, '香煎三文鱼排', '三文鱼', '煎', '慢性肾病、心脑血管疾病、糖尿病、肥胖等患者', NULL, NULL);
INSERT INTO `wx_recipe` VALUES (191, '迷迭香煎鸡肉', '鸡脯肉', '煎', NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (192, '奇异果胡萝卜炒鸡丁', '奇异果、胡萝卜、鸡脯肉', '炒', NULL, NULL, NULL);
INSERT INTO `wx_recipe` VALUES (193, '竹荪枸杞鸽子汤', '竹荪、枸杞、鸽子', '炖', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for wx_searchhis
-- ----------------------------
DROP TABLE IF EXISTS `wx_searchhis`;
CREATE TABLE `wx_searchhis`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keyword` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 151 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_searchhis
-- ----------------------------
INSERT INTO `wx_searchhis` VALUES (1, 6, 'recipe_search', '排骨', '2018-08-12 18:10:02');
INSERT INTO `wx_searchhis` VALUES (2, 6, 'recipe_search', '排骨', '2018-08-12 18:10:33');
INSERT INTO `wx_searchhis` VALUES (3, 6, 'recipe_search', '排骨', '2018-08-12 18:15:35');
INSERT INTO `wx_searchhis` VALUES (4, 6, 'recipe_search', '排骨', '2018-08-12 18:17:10');
INSERT INTO `wx_searchhis` VALUES (5, 6, 'recipe_search', '排骨', '2018-08-12 18:17:11');
INSERT INTO `wx_searchhis` VALUES (6, 6, 'recipe_search', '排骨', '2018-08-12 18:19:55');
INSERT INTO `wx_searchhis` VALUES (7, 6, 'recipe_search', '排骨', '2018-08-12 18:22:31');
INSERT INTO `wx_searchhis` VALUES (8, 6, 'recipe_search', '排骨', '2018-08-12 18:22:49');
INSERT INTO `wx_searchhis` VALUES (9, 6, 'recipe_search', '排骨', '2018-08-12 18:23:22');
INSERT INTO `wx_searchhis` VALUES (10, 6, 'recipe_search', '排骨', '2018-08-12 18:23:28');
INSERT INTO `wx_searchhis` VALUES (11, 6, 'recipe_search', '排骨', '2018-08-12 18:23:51');
INSERT INTO `wx_searchhis` VALUES (12, 6, 'recipe_search', '排骨', '2018-08-12 18:24:13');
INSERT INTO `wx_searchhis` VALUES (13, 6, 'recipe_search', '排骨', '2018-08-12 18:24:39');
INSERT INTO `wx_searchhis` VALUES (14, 6, 'recipe_search', '排骨', '2018-08-12 18:28:37');
INSERT INTO `wx_searchhis` VALUES (15, 6, 'recipe_search', '排骨', '2018-08-12 18:30:30');
INSERT INTO `wx_searchhis` VALUES (16, 6, 'recipe_search', '排骨', '2018-08-12 18:31:02');
INSERT INTO `wx_searchhis` VALUES (17, 6, 'recipe_search', '排骨', '2018-08-12 18:33:06');
INSERT INTO `wx_searchhis` VALUES (18, 8, 'medicines_search', 'asd', '2018-08-13 23:27:09');
INSERT INTO `wx_searchhis` VALUES (19, 8, 'medicines_search', '阿司匹林', '2018-08-13 23:27:45');
INSERT INTO `wx_searchhis` VALUES (20, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:34:55');
INSERT INTO `wx_searchhis` VALUES (21, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:36:08');
INSERT INTO `wx_searchhis` VALUES (22, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:40:10');
INSERT INTO `wx_searchhis` VALUES (23, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:40:54');
INSERT INTO `wx_searchhis` VALUES (24, 8, 'medicines_search', '阿司匹', '2018-08-14 10:43:14');
INSERT INTO `wx_searchhis` VALUES (25, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:46:14');
INSERT INTO `wx_searchhis` VALUES (26, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:48:03');
INSERT INTO `wx_searchhis` VALUES (27, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:48:30');
INSERT INTO `wx_searchhis` VALUES (28, 8, 'medicines_search', 'aspl', '2018-08-14 10:51:45');
INSERT INTO `wx_searchhis` VALUES (29, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:51:54');
INSERT INTO `wx_searchhis` VALUES (30, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:53:47');
INSERT INTO `wx_searchhis` VALUES (31, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:57:07');
INSERT INTO `wx_searchhis` VALUES (32, 8, 'medicines_search', '阿司匹林', '2018-08-14 10:59:16');
INSERT INTO `wx_searchhis` VALUES (33, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:00:08');
INSERT INTO `wx_searchhis` VALUES (34, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:01:32');
INSERT INTO `wx_searchhis` VALUES (35, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:01:47');
INSERT INTO `wx_searchhis` VALUES (36, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:02:28');
INSERT INTO `wx_searchhis` VALUES (37, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:04:16');
INSERT INTO `wx_searchhis` VALUES (38, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:06:05');
INSERT INTO `wx_searchhis` VALUES (39, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:09:00');
INSERT INTO `wx_searchhis` VALUES (40, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:12:24');
INSERT INTO `wx_searchhis` VALUES (41, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:14:04');
INSERT INTO `wx_searchhis` VALUES (42, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:15:06');
INSERT INTO `wx_searchhis` VALUES (43, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:15:40');
INSERT INTO `wx_searchhis` VALUES (44, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:16:07');
INSERT INTO `wx_searchhis` VALUES (45, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:16:26');
INSERT INTO `wx_searchhis` VALUES (46, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:16:59');
INSERT INTO `wx_searchhis` VALUES (47, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:27:58');
INSERT INTO `wx_searchhis` VALUES (48, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:28:38');
INSERT INTO `wx_searchhis` VALUES (49, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:29:00');
INSERT INTO `wx_searchhis` VALUES (50, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:31:31');
INSERT INTO `wx_searchhis` VALUES (51, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:32:46');
INSERT INTO `wx_searchhis` VALUES (52, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:40:39');
INSERT INTO `wx_searchhis` VALUES (53, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:45:17');
INSERT INTO `wx_searchhis` VALUES (54, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:45:45');
INSERT INTO `wx_searchhis` VALUES (55, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:47:10');
INSERT INTO `wx_searchhis` VALUES (56, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:48:15');
INSERT INTO `wx_searchhis` VALUES (57, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:49:00');
INSERT INTO `wx_searchhis` VALUES (58, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:58:13');
INSERT INTO `wx_searchhis` VALUES (59, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:58:16');
INSERT INTO `wx_searchhis` VALUES (60, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:58:26');
INSERT INTO `wx_searchhis` VALUES (61, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:58:52');
INSERT INTO `wx_searchhis` VALUES (62, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:58:54');
INSERT INTO `wx_searchhis` VALUES (63, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:59:39');
INSERT INTO `wx_searchhis` VALUES (64, 8, 'medicines_search', '阿司匹林', '2018-08-14 11:59:40');
INSERT INTO `wx_searchhis` VALUES (65, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:00:19');
INSERT INTO `wx_searchhis` VALUES (66, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:00:20');
INSERT INTO `wx_searchhis` VALUES (67, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:00:24');
INSERT INTO `wx_searchhis` VALUES (68, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:01:02');
INSERT INTO `wx_searchhis` VALUES (69, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:01:04');
INSERT INTO `wx_searchhis` VALUES (70, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:02:01');
INSERT INTO `wx_searchhis` VALUES (71, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:02:08');
INSERT INTO `wx_searchhis` VALUES (72, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:02:39');
INSERT INTO `wx_searchhis` VALUES (73, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:02:41');
INSERT INTO `wx_searchhis` VALUES (74, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:03:01');
INSERT INTO `wx_searchhis` VALUES (75, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:03:03');
INSERT INTO `wx_searchhis` VALUES (76, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:03:22');
INSERT INTO `wx_searchhis` VALUES (77, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:03:23');
INSERT INTO `wx_searchhis` VALUES (78, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:03:50');
INSERT INTO `wx_searchhis` VALUES (79, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:03:51');
INSERT INTO `wx_searchhis` VALUES (80, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:04:38');
INSERT INTO `wx_searchhis` VALUES (81, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:12:48');
INSERT INTO `wx_searchhis` VALUES (82, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:12:50');
INSERT INTO `wx_searchhis` VALUES (83, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:15:43');
INSERT INTO `wx_searchhis` VALUES (84, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:15:44');
INSERT INTO `wx_searchhis` VALUES (85, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:18:21');
INSERT INTO `wx_searchhis` VALUES (86, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:18:26');
INSERT INTO `wx_searchhis` VALUES (87, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:18:37');
INSERT INTO `wx_searchhis` VALUES (88, 8, 'medicines_search', '打破了', '2018-08-14 12:19:12');
INSERT INTO `wx_searchhis` VALUES (89, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:19:18');
INSERT INTO `wx_searchhis` VALUES (90, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:19:20');
INSERT INTO `wx_searchhis` VALUES (91, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:20:10');
INSERT INTO `wx_searchhis` VALUES (92, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:20:13');
INSERT INTO `wx_searchhis` VALUES (93, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:24:02');
INSERT INTO `wx_searchhis` VALUES (94, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:24:05');
INSERT INTO `wx_searchhis` VALUES (95, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:24:27');
INSERT INTO `wx_searchhis` VALUES (96, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:24:28');
INSERT INTO `wx_searchhis` VALUES (97, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:24:52');
INSERT INTO `wx_searchhis` VALUES (98, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:24:53');
INSERT INTO `wx_searchhis` VALUES (99, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:26:01');
INSERT INTO `wx_searchhis` VALUES (100, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:26:03');
INSERT INTO `wx_searchhis` VALUES (101, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:26:34');
INSERT INTO `wx_searchhis` VALUES (102, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:26:35');
INSERT INTO `wx_searchhis` VALUES (103, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:26:57');
INSERT INTO `wx_searchhis` VALUES (104, 8, 'medicines_search', '阿司匹林', '2018-08-14 12:27:00');
INSERT INTO `wx_searchhis` VALUES (105, 8, 'recipe_search', '红烧肉', '2018-08-14 12:30:28');
INSERT INTO `wx_searchhis` VALUES (106, 8, 'recipe_search', '玉米', '2018-08-14 12:30:32');
INSERT INTO `wx_searchhis` VALUES (107, 8, 'recipe_search', '红烧肉', '2018-08-14 12:31:16');
INSERT INTO `wx_searchhis` VALUES (108, 8, 'recipe_search', '红烧肉', '2018-08-14 13:08:25');
INSERT INTO `wx_searchhis` VALUES (109, 8, 'recipe_search', '排骨', '2018-08-14 13:08:28');
INSERT INTO `wx_searchhis` VALUES (110, 8, 'recipe_search', '排骨', '2018-08-14 13:08:56');
INSERT INTO `wx_searchhis` VALUES (111, 8, 'recipe_search', '排骨', '2018-08-14 13:09:08');
INSERT INTO `wx_searchhis` VALUES (112, 8, 'recipe_search', '排骨', '2018-08-14 13:11:03');
INSERT INTO `wx_searchhis` VALUES (113, 8, 'recipe_search', '排骨', '2018-08-14 13:11:36');
INSERT INTO `wx_searchhis` VALUES (114, 8, 'recipe_search', '排骨', '2018-08-14 13:11:59');
INSERT INTO `wx_searchhis` VALUES (115, 8, 'recipe_search', '排骨', '2018-08-14 13:12:21');
INSERT INTO `wx_searchhis` VALUES (116, 8, 'recipe_search', '排骨', '2018-08-14 13:13:29');
INSERT INTO `wx_searchhis` VALUES (117, 8, 'recipe_search', '排骨', '2018-08-14 13:14:26');
INSERT INTO `wx_searchhis` VALUES (118, 8, 'recipe_search', '排骨', '2018-08-14 13:15:14');
INSERT INTO `wx_searchhis` VALUES (119, 8, 'recipe_search', '排骨', '2018-08-14 13:15:38');
INSERT INTO `wx_searchhis` VALUES (120, 8, 'recipe_search', '排骨', '2018-08-14 13:15:52');
INSERT INTO `wx_searchhis` VALUES (121, 8, 'recipe_search', '排骨', '2018-08-14 13:16:03');
INSERT INTO `wx_searchhis` VALUES (122, 8, 'recipe_search', '排骨', '2018-08-14 13:18:53');
INSERT INTO `wx_searchhis` VALUES (123, 8, 'recipe_search', '排骨', '2018-08-14 15:17:59');
INSERT INTO `wx_searchhis` VALUES (124, 8, 'recipe_search', '红烧肉', '2018-08-14 16:35:23');
INSERT INTO `wx_searchhis` VALUES (125, 8, 'recipe_search', '排骨', '2018-08-14 16:35:27');
INSERT INTO `wx_searchhis` VALUES (126, 8, 'medicines_search', '阿', '2018-08-14 16:35:56');
INSERT INTO `wx_searchhis` VALUES (127, 8, 'medicines_search', '阿', '2018-08-14 16:35:59');
INSERT INTO `wx_searchhis` VALUES (128, 8, 'medicines_search', '阿', '2018-08-14 16:39:51');
INSERT INTO `wx_searchhis` VALUES (129, 8, 'medicines_search', '阿', '2018-08-14 16:39:55');
INSERT INTO `wx_searchhis` VALUES (130, 8, 'recipe_search', '排骨', '2018-08-14 16:44:17');
INSERT INTO `wx_searchhis` VALUES (131, 8, 'recipe_search', '排骨', '2018-08-14 16:44:41');
INSERT INTO `wx_searchhis` VALUES (132, 8, 'recipe_search', '排骨', '2018-08-14 16:45:26');
INSERT INTO `wx_searchhis` VALUES (133, 8, 'recipe_search', '排骨', '2018-08-14 16:45:59');
INSERT INTO `wx_searchhis` VALUES (134, 8, 'recipe_search', '排骨', '2018-08-14 16:48:08');
INSERT INTO `wx_searchhis` VALUES (135, 8, 'recipe_search', '排骨', '2018-08-14 16:48:39');
INSERT INTO `wx_searchhis` VALUES (136, 8, 'recipe_search', '排骨', '2018-08-14 16:48:54');
INSERT INTO `wx_searchhis` VALUES (137, 8, 'recipe_search', '排骨', '2018-08-14 16:50:36');
INSERT INTO `wx_searchhis` VALUES (138, 8, 'recipe_search', '啦', '2018-08-14 16:52:39');
INSERT INTO `wx_searchhis` VALUES (139, 8, 'recipe_search', 'la3', '2018-08-14 16:52:52');
INSERT INTO `wx_searchhis` VALUES (140, 8, 'recipe_search', '排骨', '2018-08-14 16:55:42');
INSERT INTO `wx_searchhis` VALUES (141, 8, 'recipe_search', '排骨', '2018-08-14 16:55:45');
INSERT INTO `wx_searchhis` VALUES (142, 8, 'recipe_search', '排骨', '2018-08-14 16:55:51');
INSERT INTO `wx_searchhis` VALUES (143, 8, 'recipe_search', '排骨', '2018-08-14 16:56:40');
INSERT INTO `wx_searchhis` VALUES (144, 8, 'recipe_search', '排骨', '2018-08-14 17:06:14');
INSERT INTO `wx_searchhis` VALUES (145, 8, 'recipe_search', '排骨', '2018-08-14 17:06:19');
INSERT INTO `wx_searchhis` VALUES (146, 8, 'recipe_search', '红烧肉', '2018-08-14 17:06:23');
INSERT INTO `wx_searchhis` VALUES (147, 8, 'recipe_search', '排骨', '2018-08-14 17:06:39');
INSERT INTO `wx_searchhis` VALUES (148, 8, 'recipe_search', '排骨', '2018-08-14 17:13:04');
INSERT INTO `wx_searchhis` VALUES (149, 8, 'recipe_search', '排骨', '2018-08-14 17:14:08');
INSERT INTO `wx_searchhis` VALUES (150, 8, 'recipe_search', '红烧肉', '2018-08-14 17:14:13');
INSERT INTO `wx_searchhis` VALUES (151, 8, 'recipe_search', '排骨', '2018-08-15 13:32:05');

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `openid` varchar(28) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `height` float NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of wx_user
-- ----------------------------
INSERT INTO `wx_user` VALUES (1, '张三', '123243242', '1900-09-12', '女', 180.5, '12345566');
INSERT INTO `wx_user` VALUES (2, '王五', '999999999999999', '1997-02-13', '男', NULL, NULL);
INSERT INTO `wx_user` VALUES (3, '赵六', '1111111111111111·', '1998-03-03', '男', NULL, NULL);
INSERT INTO `wx_user` VALUES (4, '钱四', '89898989898989898', '1999-09-09', '女', 111.111, '12345678987');
INSERT INTO `wx_user` VALUES (18, 'sunsu', 'o_4iP4nr5MxKz6KZTdd4vUMXAdHc', '2018-08-03', '男', 160, '');

SET FOREIGN_KEY_CHECKS = 1;
