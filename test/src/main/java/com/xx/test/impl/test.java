package com.xx.test.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xx.test.bo.AccountBO;
import com.xx.test.bo.OooBO;
import com.xx.test.bo.RoleBO;
import com.xx.test.bo.SupCategoryBO;
import com.xx.test.po.Boy;
import com.xx.test.po.Product;
import com.xx.test.util.AesEcbUtil;
import com.xx.test.util.JaxbUtil;
import com.xx.test.util.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.sound.midi.Soundbank;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
public class test {

    public static final String HEIGHT_LIMIT_LOW_PRICE = "2";
    /**
     * 16进制字符串定长长度
     */
    private final static Integer MAX_DIGITS = 64;
    /**
     * 会员二维码生成时不足64位时的补位符号
     */
    public static final String SUPPLEMENT_SYMBOL = "$";

//    public static void main(String[] args) throws IOException, InterruptedException {
//
//
//
//        /**
//         * list
//         */
////        BigDecimal bigDecimal = new BigDecimal("15");
////        Product prod1 = new Product(1L, 3, new BigDecimal("15.5"), "面包", "零食");
////        Product prod2 = new Product(2L, 4, new BigDecimal("20"), "饼干", "零食");
////        Product prod3 = new Product(3L, 2, new BigDecimal("30"), "月饼", "零食");
////        Product prod4 = new Product(4L, 3, new BigDecimal("18"), "青岛啤酒", "啤酒");
////        Product prod5 = new Product(5L, 1, new BigDecimal("15"), "百威啤酒", "啤酒");
////        List<Product> prodList = new ArrayList<>();
////        prodList.add(prod1);
////        prodList.add(prod2);
////        prodList.add(prod3);
////        prodList.add(prod4);
////        prodList.add(prod5);
////        Collections.sort(prodList);
////        System.out.println(prodList);
////        Map<String, List<Product>> map = prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
////        long forMapStart = System.currentTimeMillis();
////        List<ProductBO> productBOS = new ArrayList<>();
////        for (Map.Entry<String, List<Product>> entry: map.entrySet()){
////            ProductBO bo = new ProductBO();
////            bo.setCategory(entry.getKey());
////            List<DetailBO> detailBOS = JSON.parseArray(JSON.toJSONString(entry.getValue(), SerializerFeature.WriteMapNullValue), DetailBO.class);
////            bo.setDetails(detailBOS);
////            productBOS.add(bo);
////        }
////        long forMapEnd = System.currentTimeMillis();
////        System.out.println(JSON.toJSONString(productBOS));
////        System.out.println("forMap:" + (forMapEnd - forMapStart));
//
////        List<Product> collect = prodList.stream().filter(item -> item.getId() == 1L).collect(Collectors.toList());
////        System.out.println(JSON.toJSONString(collect));
//        /**Collections.singletonList
//         /*        List<String> stringList = Collections.singletonList("a");
//         System.out.println(stringList);*/
//        /**
//         * groupingBy
//         */
////        Map<String, List<Product>> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
////        System.out.println(JSON.toJSONString(prodMap));
////        List<List<Product>> collect = prodMap.values().stream().collect(Collectors.toList());
////        System.out.println(JSON.toJSONString(collect));
//        //Map<Integer, Set<Product>>
////        Map<String, Set<Product>> collect = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.toSet()));
//        /**
//         * toMap,sorted
//         */
///*        Map<String, String> prodMap = prodList.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toMap(Product::getCategory, Product::getName, (v1, v2) -> v1 + v2));
//        System.out.println(JSON.toJSONString(prodMap));*/
//        /**
//         * Function.identity()
//         * 返回对象本身类型
//         *
//         */
////        Map<String, Product> collect = prodList.stream().collect(Collectors.toMap(Product::getCategory, Function.identity()));
//        /**
//         * groupingBy,lambda
//         */
///*        Map<String, List<Product>> prodMap = prodList.stream().collect(Collectors.groupingBy(item -> {
//            if (item.getNum() < 3) {
//                return "three";
//            } else {
//                return "other";
//            }
//        }));*/
///*        Map<String, Map<String, List<Product>>> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.groupingBy(item -> {
//            if (item.getNum() < 3) {
//                return "three";
//            } else {
//                return "other";
//            }
//        })));*/
//        /**
//         * filter,lambda,groupingBy
//         */
///*        Map<String, List<Product>> prodMap = prodList.stream().filter(item -> {
//            if (item.getPrice().compareTo(bigDecimal) > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        }).collect(Collectors.groupingBy(Product::getCategory));*/
//        /**
//         * 自定义去重
//         */
////        Map<String, Product> prodMap = prodList.stream().filter(distinctByNum(Product::getCategory)).collect(Collectors.toMap(Product::getCategory, item -> item));
////        Map<String, List<Product>> prodMap = prodList.stream().collect(Collectors.groupingBy(Product::getCategory));
////        System.out.println("前:"+ JSONObject.toJSONString(prodMap));
////        List<Product> collect = prodList.stream().sorted(Comparator.comparing(Product::getName)).collect(Collectors.toList());
////        System.out.println("后:"+JSONObject.toJSONString(collect));
////        List<String> stringList = numsays.asList("a", "vb", "c");
////        Predicate<String> predicate = p -> p.length() == 2;
////        List<String> collect = stringList.stream().filter(predicate).collect(Collectors.toList());
////        System.out.println(collect);
//
//        /**
//         * Optional.ofNullable
//         */
///*        long schemeId = 1111111L;
//        long schemeId1 = 0;
//        SscJoinSupPO sscJoinSupPO = new SscJoinSupPO();
//        sscJoinSupPO.setSchemeId(schemeId1);
//        Long aLong = Optional.ofNullable(sscJoinSupPO.getSchemeId()).orElse(schemeId);
//        Long bLong = null == sscJoinSupPO.getSchemeId() || 0 == sscJoinSupPO.getSchemeId()?schemeId:sscJoinSupPO.getSchemeId();
//        System.out.println(aLong);
//        System.out.println(bLong);*/
//
//        /**
//         * sorted(Comparator.reverseOrder())
//         */
///*        List<Long> collect = prodList.stream().map(Product::getId).filter(item -> item != 1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(collect);*/
//
//        /**
//         * reduce
//         */
///*        String[] strings = {"a", "b","b", "c", "d", "e"};
//        String reduce = numsays.stream(strings).distinct().reduce("", (a, b) -> a + "|" + b);
//        System.out.println(reduce);*/
//        /**
//         * mapping
//         */
///*        List<String> collect = prodList.stream().collect(Collectors.mapping(Product::getCategory, Collectors.toList()));
//        System.out.println(collect);*/
//        /**
//         * try-catch
//         */
///*        intImpl intService = new intImpl();
//        bntImpl bntService = new bntImpl();
//        try {
//            IntPushFwaProtocolBsReqBO reqBO = new IntPushFwaProtocolBsReqBO();
//            IntPushFwaProtocolBsRspBO rspBO = bntService.bntPushFwaProtocolBs(reqBO);
//            System.out.println("111111"+JSON.toJSONString(rspBO));
//
//            IntPushFwaProtocolBsReqBO intPushFwaProtocolBsReqBO = new IntPushFwaProtocolBsReqBO();
//            IntPushFwaProtocolBsRspBO intPushFwaProtocolBsRspBO = intService.intPushFwaProtocolBs(intPushFwaProtocolBsReqBO);
//            System.out.println("222222"+JSON.toJSONString(intPushFwaProtocolBsRspBO));
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("!!!!!!!!!!");
//        System.out.println("!!!!!!!!!!");*/
//        /**
//         * new Function apply mapping
//         */
///*        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("hello");
//        System.out.println(list);
////        Object collect = list.stream().map(new Function<String, String>() {
////            @Override
////            public String apply(String s) {
////                String s1 = s.toUpperCase(Locale.ROOT);
////                return s1;
////            }
////        }).collect(Collectors.toList());
////        System.out.println(collect);
//        List<String> collect = list.stream().collect(Collectors.mapping(item -> item.toUpperCase(Locale.ROOT), Collectors.toList()));
//        System.out.println(collect);*/
//        /**
//         * mapping
//         * 该方法是先对元素使用 Function 进行再加工操作，然后用另一个Collector 归纳。比如我们先去掉 servers 中元素的首字母，然后将它们装入 List
//         */
///*        List<String> servers = new numsayList<>();
//        servers.add("Felordcn");
//        servers.add("Tomcat");
//        servers.add("Jetty");
//        servers.add("Undertow");
//        servers.add("Resin");
//        List<String> collect = servers.stream().collect(Collectors.mapping(item -> item.toUpperCase(Locale.ROOT), Collectors.toList()));
//        System.out.println(collect);*/
//        /**
//         * 抽象类
//         */
///*        AbstractDemo abstractDemo = new AbstractDemo();
//        abstractDemo.method1();
//        AbstractDemo1 abstractDemo1 = new AbstractDemo1();
//        abstractDemo1.method1();*/
//        /**
//         * 十进制十六进制互转加密
//         */
///*        Date createTime = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(createTime);
//        calendar.add(Calendar.SECOND,60);//当前时间累加60秒之后的时间
//        Date expTime = calendar.getTime();
//        String expStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(expTime);
//        System.out.println("expStr：" + expStr);
//        System.out.println("stringToHex16String：" + stringToHex16String(expStr));
//        System.out.println("stringToFixHex16String：" + stringToFixHex16String(expStr));
//        System.out.println("hexStringToString：" + hexStringToString(stringToFixHex16String(expStr)));*/
///*            String str = "dasndlkasddasd";
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < str.length(); i++) {
//                int c = str.charAt(i);
//                sb.append(Integer.toHexString(c).trim().toLowerCase());
//            }
//            //ascii码十六进制6461736e646c6b61736464617364
//            System.out.println("16:" + sb);
//            byte[] baKeyword = new byte[sb.length() / 2];
//            for (int i = 0; i < baKeyword.length; i++) {
//                //Integer.parseInt(String s ,int radix)
//                //radix: 进制
//                byte b = (byte) (0xff & Integer.parseInt(sb.substring(i * 2, i * 2 + 2), 16));
//                System.out.print(b);
//                baKeyword[i] = b;
//            }
//            String resultStr = null;
//            try {
//                resultStr = new String(baKeyword, "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            System.out.println(resultStr);*/
//        /**
//         * format,Calender
//         */
///*        Date now = new Date();
//        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
//        String format1 = format.format(now);
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(now);
//        cal.add(Calendar.MINUTE, 5);
//        Date time = cal.getTime();
//        System.out.println(format1);
//        String format2 = format.format(time);
//        System.out.println(format2);
//        try {
//            Date parse = format.parse(format2);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }*/
//        /**
//         * log
//         */
////        List<String> collect = prodList.stream().map(Product::getName).distinct().collect(Collectors.toList());
////        Map<String, List<Product>> collect1 = prodList.stream().collect(Collectors.groupingBy(Product::getName));
////        System.out.println(collect1);
////        System.out.println(collect.size());
////        System.out.println(collect1.size());
////        log.info("prodList:{} name:{}", prodList, collect);
///*        log.trace("trace日志");
//        log.debug("debug日志");
//        log.info("info日志");
//        log.warn("warn日志");
//        log.error("error日志");*/
//        /**
//         * guava map
//         */
///*        Map<Integer, Integer> map0 = Maps.newHashMap();
//        for (int i = 0; i < 10; i++) {
//            map0.put(i, i);
//        }
//        System.out.println("map0：" + map0);
//
//        Map<Integer, Integer> map1 = Maps.newHashMap(map0);
//        map1.put(10, 10);
//        System.out.println("map1：" + map1);
//
//        //下面的这个写法呢是在初始化list的时候，说明容器的扩容界限值
//        //使用条件：你确定你的容器会装多少个，不确定就用一般形式的
//        //说明：这个容器超过3个还是会自动扩容的。不用担心容量不够用。默认是分配一个容量为16的数组，不够将扩容
//        //详细见后面说明
//        Map<Integer, Integer> map2 = Maps.newHashMapWithExpectedSize(3);
//        *//*Map<String,String> map9 = Maps.newHashMapWithExpecte    dSize();*//*
//        map2.put(1, 1);
//        map2.put(2, 2);
//        map2.put(3, 3);
//        System.out.println("map2：" + map2);
//
//        //LinkedHashMap<K, V> 有序map
//        //Map<Integer,Integer> map3 = Maps.newLinkedHashMap();
//        Map<Integer, Integer> map3 = Maps.newLinkedHashMap(map1);
//        //Map<Integer,Integer> map3 = Maps.newLinkedHashMapWithExpectedSize(11);
//        map3.put(11, 11);
//        System.out.println("map3：" + map3);
//        for (Map.Entry<Integer, Integer> entry : map3.entrySet()){
//            System.out.print("key:" + entry.getKey() + "value:" + entry.getValue() + '\t');
//        }*/
//
////        List<testPO> listPo = new ArrayList<>();
////        for (int i = 0; i < 10000; i++) {
////            testPO po = new testPO();
////            po.setId(i);
////            listPo.add(po);
////        }
////        long start = System.currentTimeMillis();
//////        List<testBO> listBO = new ArrayList<>();
//////        for (testPO po : listPo){
//////            testBO bo = new testBO();
//////            BeanUtils.copyProperties(po, bo);
//////            listBO.add(bo);
//////        }
////        List<testBO> listBO = JSON.parseArray(JSON.toJSONString(listPo, SerializerFeature.WriteMapNullValue), testBO.class);
////        long end = System.currentTimeMillis();
////        long l = end - start;
////        log.info("start:" + start );
////        log.info("end:" + end );
////        log.info("l:" + l );
//        // CPU的核心数 默认就用cpu核心数了
////        System.out.println(Runtime.getRuntime().availableProcessors());
//
////        List<String> servers = new ArrayList<>();
////        servers.add("Felordcn");
////        servers.add("Tomcat");
////        servers.add("Jetty");
////        servers.add("Undertow");
////        servers.add("Resin");
//        /**
//         * joining
//         */
////        //  输出 FelordcnTomcatJettyUndertowResin
////        String collect = servers.stream().collect(Collectors.joining());
////        //  输出 Felordcn,Tomcat,Jetty,Undertow,Resin
////        System.out.println(servers.stream().collect(Collectors.joining(",")));
////        //  输出 [Felordcn,Tomcat,Jetty,Undertow,Resin]
////        System.out.println(servers.stream().collect(Collectors.joining(",", "[", "]")));
//
//        /**
//         * 该方法先执行了一个归纳操作，然后再对归纳的结果进行 Function 函数处理输出一个新的结果。
//         */
//        // 比如我们将servers joining 然后转成大写，结果为： FELORDCN,TOMCAT,JETTY,UNDERTOW,RESIN
////        servers.stream().collect(Collectors.collectingAndThen(Collectors.joining(","), String::toUpperCase));
//
//        /**
//         * partitioningBy
//         */
//
//        /**
//         * counting
//         */
//
//        /**
//         * maxBy/minBy
//         */
//        // Jetty
////        Optional<String> min = servers.stream().collect(Collectors.minBy(Comparator.comparingInt(String::length)));
////        System.out.println(min);
//
//        /**
//         * summingInt/Double/Long
//         * 用来做累加计算。计算元素某个属性的总和,类似 Mysql 的 sum 函数，比如计算各个项目的盈利总和、计算本月的全部工资总和等等。
//         */
////        Integer collect = servers.stream().collect(Collectors.summingInt(s -> s.length()));
////        System.out.println(collect);
//
////        JSONObject dataJson = new JSONObject();
////        dataJson.put("roleId", 405395039912734721L);
////        dataJson.put("roleName", "企业注册角色");
//////        System.out.println("JSONObject:" + dataJson);
////
////        List<RoleBO> list = new ArrayList<>();
////        RoleBO roleBO = new RoleBO();
////        roleBO.setRoleId(405395039912734721L);
////        roleBO.setRoleName("企业注册角色");
////        list.add(roleBO);
//////        System.out.println("list:" + list);
////        String s = JSON.toJSONString(list);
//////        System.out.println(s);
////        JSONArray.parseArray(s);
//
////        String rspJson = "{\"header\":{\"ret\":\"0\",\"msg\":\"查询成功\",\"size\":null},\"data\":{\"isValidate\":true,\"commonUserDto\":{\"" +
////                "id\":\"35dec4261b9f4680ace05eec39ec50ae\",\"userName\":\"guwx\",\"realName\":\"谷文雄\",\"businesslicence\":\"91110000710930464P\",\"companyName\":\"浙江天音管理咨询有限公司\",\"mobilePhone\":\"18515881215\",\"createD" +
////                "ate\":\"2020-07-10 16:00:31\"}}}";
////        String jsonStr2 = JSONObject.toJSONString(JSON.parse(rspJson), SerializerFeature.WriteMapNullValue);
////        System.out.println(jsonStr2);
//
//
////        Set<String> recentMenuSet = new HashSet<>();
////        List<String> recentMenuList = new ArrayList<>();
////        recentMenuList.add("436896838464172005");
////        recentMenuList.add("436896838464172006");
////        recentMenuList.add("436896838464172007");
////        recentMenuList.add("436896838464172008");
////        recentMenuList.add("436896838464172009");
////        System.out.println("list:" + JSON.toJSONString(recentMenuList));
////        for (String s : recentMenuList){
////            recentMenuSet.add(s);
////        }
////        System.out.println("set:" + JSON.toJSONString(recentMenuSet));
//
////        List<String> bkType = new ArrayList<String>(){{
////            add("集团本部");
////            add("电力");
////            add("石油");
////            add("煤炭运输");
////            add("天然气");
////            add("可再生");
////            add("科工服务");
////            add("金融");
////            add("西北");
////            add("集团直属");
////            add("其他");
////            add("长广");
////            add("锦环投");
////        }};
////        String s = JSON.toJSONString(bkType);
////        System.out.println(s);
////        List<String> stringList = JSON.parseArray(s, String.class);
////        System.out.println(stringList);
//
////        String substring = String.valueOf(new SecureRandom().nextDouble() * 1000000).substring(0, 6);
////        System.out.println(substring);
//
////        String str = "1-305775845729763327-305775845729763330-479025907425087488-";
////        System.out.println(str.contains("305775845729763330"));
//
////        String newPassword = "594dc7b36210512a1b8d719f0b71cbfc";
////        final String ORIGINAL_KEY = "1234567890123456";
////        String decryptNewPwd = AesEcbUtil.decryptStr(newPassword, ORIGINAL_KEY);
////        System.out.println(decryptNewPwd);
//
//        //去重
////        prodList = prodList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(()->new TreeSet<> (Comparator.comparing(Product::getNum))), ArrayList::new));
////        System.out.println(prodList);
//
////        System.out.println(wildcardEquals("**/**/iac/**", "/iac/select"));
//        //集合取交集
////        List<String> CHCategoryIds = l3catalogListList.stream().filter(CollectionUtils::isNotEmpty).reduce((a, b) -> {
////            a.retainAll(b);
////            return a;
////        }).get();
//    }

    /**
     * getIp
     * @param request
     * @return
     */
/*    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            int index = ip.indexOf(",");
            return index != -1 ? ip.substring(0, index) : ip;
        } else {
            ip = request.getHeader("X-Real-IP");
            return StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip) ? ip : request.getRemoteAddr();
        }
    }*/

    /**
     * 自定义去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    private static <T> Predicate<T> distinctByNum(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> concurrentHashMap = new ConcurrentHashMap<>();
        return t -> concurrentHashMap.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 上传一般文件到OSS并持久化
     *
     * @param file 文件集合
     * @return List<FileRspBo>
     * @throws Exception
     */
/*    @RequestMapping(value = "/uploadFileToOssAndSave", method = RequestMethod.POST)
    @BusiResponseBody
    public List<FileRspBo> uploadFileToOssAndSave(@RequestParam("file") MultipartFile[] file,
                                                  @RequestParam("agentId") String agentId, HttpServletRequest request) throws Exception {
        log.info("pma::uploadFileToOssAndSave:agentId="+agentId);
        List<FileRspBo> bos = new numsayList<FileRspBo>();
        ReqInfo body = new ReqInfo();
        String userToken = TokenUtils.getUserToken(request);
        log.info("pma::uploadFileToOssAndSave:userToken="+userToken);
        Object principal = SerializeUtils.deserialize(cacheManager.get(userToken.getBytes()));
        if (!StringUtils.hasText(agentId)) {
            throw new ZTBusinessException(BaseRspConstants.RSP_CODE_InvalidParameter, "未携带agentId");
        }
        agentId = DesUtil.strDec(agentId, BaseConstants.AGENT_KEY);
        body = getUserInfo(principal, agentId.trim(), body);
        log.info("pma::uploadFileToOssAndSave:JSONObject.toJSONString(body)="+JSONObject.toJSONString(body));
        System.err.println(ossConfig.getBucketName());
        // 一般文件bucket与加密文件bucket的切换（加密->一般）
        if (ossConfig.getBucketName().contains("-secret")) {
            String temp = ossConfig.getBucketName().substring(0,
                    ossConfig.getBucketName().length() - "-secret".length());
            ossConfig.setBucketName(temp);
        }
        // 遍历文件列表，批量依次上传文件
        for (MultipartFile multipartFile : file) {
            // 设置文件名长度最大为50字节
            //if (multipartFile.getOriginalFilename().length() < 300) {
            // 将文件上传到选择的bucket
            Map<String, Object> m = FileUploadUtil.multipartFileToFile(multipartFile, ossConfig, false);
            log.info("pma::uploadFileToOssAndSave:multipartFileToFile:JSONObject.toJSONString(m)="+ JSONObject.toJSONString(m));
            // 将文件信息通过微服务保存到数据库中
            FileRspBo uploadId = fileUploadService.uploadFileToOss(m);
            log.info("pma::uploadFileToOssAndSave:JSONObject.toJSONString(uploadId)="+JSONObject.toJSONString(uploadId));
            // 前端要求设置的文件上传进度相关属性
            uploadId.setPercentage(100);
            uploadId.setFilePreview(uploadId.getFileType());
            // 设置回参
            bos.add(uploadId);
        }
        if (!CollectionUtils.isEmpty(bos)) {
            //持久化并替换下载url
            UploadFileBOs uploadFileBOs = new UploadFileBOs();
            BeanUtils.copyProperties(body, uploadFileBOs);
            List<UploadFileBO> uploadFileBOList = new numsayList<>();
            UploadFileBO uploadFileBO = new UploadFileBO();
            uploadFileBOList.add(uploadFileBO);
            uploadFileBOs.setUploadFileBOs(uploadFileBOList);
            for (FileRspBo bo : bos) {
                uploadFileBO.setUploadId(bo.getUploadId());
                log.info("pma::uploadFileToOssAndSave:JSONObject.toJSONString(uploadFileBOs)="+JSONObject.toJSONString(uploadFileBOs));
                List<String> msg = uploadRecordService.saveUploadFile(uploadFileBOs);
                if (!CollectionUtils.isEmpty(msg)) {
                    bo.setDownloadUrl(msg.get(0));
                }
            }
        }
        log.info("pma::uploadFileToOssAndSave:END:JSONObject.toJSONString(bos)="+JSONObject.toJSONString(bos));
        return bos;
    }*/
/*    public ReqInfo getUserInfo(Object principal, String appId, ReqInfo body) {

        UserInfo user = null;
        if (principal instanceof UserInfo) {
            user = (UserInfo) principal;
        }
        Map<Long, UserInfo> users = user.getUsers();
        Map<String, OrgAgentInfoBaseApp> apps = user.getAgents();
        Long orgId = null;

        if (apps == null || apps.size() == 0) {
            LogUtil.printMessageLog(user.getUserId(), this.getClass(), "此用户当前身份无已授权应用");
            return body;
        } else {
            if (appId.length() < 10) {

                Map<String, OrgAgentInfoBaseApp> commappIds = user.getAgents();
                for (String key : commappIds.keySet()) {
                    if (appId.equals(key)) {
                        user.setAgentId(null);
                        user.setAppId(commappIds.get(key).getAppId());
                        user.setAppName(commappIds.get(key).getAgentName());

                        body.setAgentId(null);
                        body.setAppId(commappIds.get(key).getAppId());
                        body.setLoginId(user.getLoginId());
                        body.setMobile(user.getMobile());
                        body.setOpenId(user.getOpenId());

                        return body;
                    }
                }

            } else {
                try {
                    orgId = StringUtil.splitAgentId(appId).get(0);
                    user = users.get(Long.valueOf(orgId).longValue());
                    user.setAgentId(DesUtil.strEnc(appId, BaseConstants.AGENT_KEY));
                    user.setAppUrl(apps.get(DesUtil.strEnc(appId, BaseConstants.AGENT_KEY)).getUrl());
                    user.setAppName(apps.get(DesUtil.strEnc(appId, BaseConstants.AGENT_KEY)).getAgentName());

                    body.setAgentId(appId);
                    body.setDeptId(user.getDeptId());
                    body.setOrgId(user.getOrgId());
                    body.setUserId(user.getUserId());
                    body.setPartyId(user.getPartyId());
                    body.setLoginId(user.getLoginId());
                    body.setMobile(user.getMobile());
                    body.setOpenId(user.getOpenId());

                } catch (Exception e) {
                    for (Long key : users.keySet()) {
                        user = users.get(key);
                        break;
                    }
                    e.printStackTrace();
                    user.setOrgId(null);
                    user.setAppUrl(null);
                    user.setAppName(null);
                }
                return body;
                // return user;
            }
        }
        return body;
    }*/

    /**
     * 将指定字符串转换为64长度的16进制
     *
     * @param needStrTransFixHex 需要为转换的定长16进制的字符串
     * @return string
     */
    public static String stringToFixHex16String(String needStrTransFixHex) {
        String hexStr = stringToHex16String(needStrTransFixHex);
        if (StringUtils.isEmpty(hexStr)) {
            log.error("需要转换为64位定长16进制的入参字符串为空！！！！！");
            return null;
        }
        //转换的16进制长度大于64位时，抛出错误信息
        if (hexStr.length() > MAX_DIGITS) {
            log.error("传入的字符串在转换为64位16进制格式时超长！！！！！");
            return null;
        }
        if (hexStr.length() < MAX_DIGITS) {
            //一个字符2字节，因而真正需要补位的字符需要除以2
            Integer randomLength = (MAX_DIGITS - hexStr.length()) / 2;
            String sources = "0123456789";
            Random random = null;
            try {
                random = SecureRandom.getInstanceStrong();
                StringBuilder flag = new StringBuilder();
                //循环数减一是为了增加一个固定字符
                for (int i = 0; i < randomLength - 1; i++) {
                    flag.append(sources.charAt(random.nextInt(9)));
                }
                flag.append(SUPPLEMENT_SYMBOL);
                String fillHex = stringToHex16String(flag.toString());
                hexStr = fillHex + hexStr;
            } catch (NoSuchAlgorithmException e) {
                log.error("NoSuchAlgorithmException:{}", e.toString());
            }
        }
        return hexStr;
    }

    /**
     * 将字符串转换为16进制
     *
     * @param needTransStr 需要转换的字符串
     * @return string
     */
    private static String stringToHex16String(String needTransStr) {
        if (StringUtils.isEmpty(needTransStr)) {
            log.error("需要转换为16进制的入参字符串为空！！！！！");
            return null;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < needTransStr.length(); i++) {
            //获取每个字符
            char c = needTransStr.charAt(i);
            //十进制ascii码
            int ch = needTransStr.charAt(i);
            //十进制ascii码转十六进制ascii码
            String s4 = Integer.toHexString(ch);
            //去掉字符两端空格并转小写
            str.append(s4.trim().toLowerCase());
        }
        return str.toString();
    }

    /**
     * 将16进制转换字符串格式
     *
     * @param needTransHexStr 需要转换位字符串格式的16进制数据
     * @return string
     */
    public static String hexStringToString(String needTransHexStr) {
        if (StringUtils.isEmpty(needTransHexStr)) {
            log.error("传入的需要转换为字符串的16进制入参为空！！！！！");
            return null;
        }
        byte[] baKeyword = new byte[needTransHexStr.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(needTransHexStr.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                log.error("将16进制转换为byte数组出错！！！！！", e);
                return null;
            }
        }
        try {
            needTransHexStr = new String(baKeyword, "UTF-8");
        } catch (Exception e) {
            log.error("将byte数组转换为字符串出错！！！！！", e);
        }
        return needTransHexStr;
    }


    /**
     * 通配符模式
     * @param whitePath - 白名单地址
     * @param reqPath - 请求地址
     * @return
     */
    public static boolean wildcardEquals(String whitePath, String reqPath) {
        String regPath = RegexUtils.getRegPath(whitePath);
        System.out.println("whitePath:" + whitePath);
        System.out.println("regPath:" + regPath);
        System.out.println("reqPath:" + reqPath);
        return Pattern.compile(regPath).matcher(reqPath).matches();
    }

    public static <T, K, U> Collector<T, ?, Map<K,U>> toLinkedMap(
            Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends U> valueMapper)
    {
        return Collectors.toMap(
                keyMapper,
                valueMapper,
                (u, v) -> {
                    throw new IllegalStateException(String.format("Duplicate key %s", u));
                },
                LinkedHashMap::new
        );
    }

    public static void main(String[] args) {
//        String threeDayAgo = LocalDateTime.now().plusDays(-12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00"));
//        try {
//            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(LocalDateTime.now().plusDays(-12).format(DateTimeFormatter.ofPattern("yyyy-MM-dd%")));
//            System.out.println(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        Date createTimeEff = Date.from( LocalDateTime.now().plusDays(-15).atZone( ZoneId.systemDefault()).toInstant());
//        System.out.println(createTimeEff);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -12);
        Date createTimeExp = calendar.getTime();
        calendar.add(Calendar.DATE, -1);
        Date createTimeEff = calendar.getTime();
        System.out.println(createTimeExp);
        System.out.println(createTimeEff);

    }

}
