package grammar;

import apg.Grammar;
import java.io.PrintStream;

public class GrammarUnderTest extends Grammar{

    // public API
    public static Grammar getInstance(){
        if(factoryInstance == null){
            factoryInstance = new GrammarUnderTest(getRules(), getUdts(), getOpcodes());
        }
        return factoryInstance;
    }

    // rule name enum
    public static int ruleCount = 487;
    public enum RuleNames{
        A_TO_F("A-to-F", 438, 3283, 7),
        ABSTRACTSPATIALTYPENAME("abstractSpatialTypeName", 252, 2028, 3),
        ACTION("action", 264, 2055, 1),
        ACTIONIMPORT("actionImport", 265, 2056, 1),
        ACTIONIMPORTCALL("actionImportCall", 29, 282, 1),
        ADDEXPR("addExpr", 202, 1757, 5),
        AGGREGATEEXPR("aggregateExpr", 448, 3338, 27),
        AGGREGATEFROM("aggregateFrom", 450, 3370, 8),
        AGGREGATEITEM("aggregateItem", 447, 3333, 5),
        AGGREGATEMETHOD("aggregateMethod", 452, 3387, 10),
        AGGREGATETRAFO("aggregateTrafo", 446, 3320, 13),
        AGGREGATEWITH("aggregateWith", 449, 3365, 5),
        ALIASANDVALUE("aliasAndValue", 103, 891, 4),
        ALLEXPR("allExpr", 152, 1341, 11),
        ALLOPERATIONSINSCHEMA("allOperationsInSchema", 97, 854, 4),
        ALLOWENTITYREFERENCESPREFERENCE("allowEntityReferencesPreference", 367, 2713, 4),
        ALPHA("ALPHA", 435, 3276, 3),
        ANDEXPR("andExpr", 192, 1705, 5),
        ANNOTATIONEXPR("annotationExpr", 133, 1161, 8),
        ANNOTATIONIDENTIFIER("annotationIdentifier", 372, 2751, 15),
        ANNOTATIONINFRAGMENT("annotationInFragment", 135, 1180, 11),
        ANNOTATIONINQUERY("annotationInQuery", 134, 1169, 11),
        ANNOTATIONQUALIFIER("annotationQualifier", 136, 1191, 1),
        ANNOTATIONSLIST("annotationsList", 371, 2745, 6),
        ANYEXPR("anyExpr", 151, 1328, 13),
        APPLY("apply", 443, 3294, 4),
        APPLYEXPR("applyExpr", 444, 3298, 6),
        APPLYTRAFO("applyTrafo", 445, 3304, 16),
        ARRAY("array", 213, 1824, 10),
        ARRAYOROBJECT("arrayOrObject", 212, 1821, 3),
        ASALIAS("asAlias", 453, 3397, 5),
        AT("AT", 385, 2816, 3),
        AT_OPTION("at-option", 480, 3665, 4),
        AUTHORITY("authority", 399, 2874, 10),
        BASE64B16("base64b16", 284, 2147, 22),
        BASE64B8("base64b8", 285, 2169, 9),
        BASE64CHAR("base64char", 286, 2178, 5),
        BATCHOPTION("batchOption", 53, 439, 3),
        BATCHOPTIONS("batchOptions", 52, 433, 6),
        BEGIN_ARRAY("begin-array", 219, 1862, 6),
        BEGIN_OBJECT("begin-object", 217, 1851, 6),
        BINARY("binary", 282, 2134, 5),
        BINARYVALUE("binaryValue", 283, 2139, 8),
        BOOLCOMMONEXPR("boolCommonExpr", 127, 1102, 1),
        BOOLEANVALUE("booleanValue", 287, 2183, 3),
        BOOLMETHODCALLEXPR("boolMethodCallExpr", 155, 1383, 8),
        BOTTOMCOUNTTRAFO("bottomcountTrafo", 461, 3457, 11),
        BOTTOMPERCENTTRAFO("bottompercentTrafo", 462, 3468, 11),
        BOTTOMSUMTRAFO("bottomsumTrafo", 463, 3479, 11),
        BOUNDACTIONCALL("boundActionCall", 30, 283, 6),
        BOUNDCOMPLEXCOLFUNCTIONCALL("boundComplexColFunctionCall", 34, 310, 7),
        BOUNDCOMPLEXFUNCTIONCALL("boundComplexFunctionCall", 33, 303, 7),
        BOUNDENTITYCOLFUNCTIONCALL("boundEntityColFunctionCall", 32, 296, 7),
        BOUNDENTITYFUNCTIONCALL("boundEntityFunctionCall", 31, 289, 7),
        BOUNDFUNCTIONCALLNOPARENS("boundFunctionCallNoParens", 37, 331, 37),
        BOUNDFUNCTIONEXPR("boundFunctionExpr", 147, 1275, 1),
        BOUNDOPERATION("boundOperation", 28, 250, 32),
        BOUNDPRIMITIVECOLFUNCTIONCALL("boundPrimitiveColFunctionCall", 36, 324, 7),
        BOUNDPRIMITIVEFUNCTIONCALL("boundPrimitiveFunctionCall", 35, 317, 7),
        BWS("BWS", 384, 2810, 6),
        BWS_H("BWS-h", 381, 2796, 4),
        BYTEVALUE("byteValue", 293, 2226, 2),
        CALLBACKPREFERENCE("callbackPreference", 368, 2717, 12),
        CASEMETHODCALLEXPR("caseMethodCallExpr", 189, 1666, 21),
        CASTEXPR("castExpr", 211, 1808, 13),
        CEILINGMETHODCALLEXPR("ceilingMethodCallExpr", 183, 1608, 7),
        CHARINJSON("charInJSON", 225, 1889, 20),
        CLOSE("CLOSE", 395, 2843, 3),
        COLLECTIONLITERAL("collectionLiteral", 322, 2454, 8),
        COLLECTIONNAVIGATION("collectionNavigation", 5, 102, 7),
        COLLECTIONNAVIGATIONEXPR("collectionNavigationExpr", 140, 1200, 15),
        COLLECTIONNAVPATH("collectionNavPath", 6, 109, 17),
        COLLECTIONPATHEXPR("collectionPathExpr", 144, 1230, 28),
        COLON("COLON", 386, 2819, 3),
        COMMA("COMMA", 387, 2822, 3),
        COMMONEXPR("commonExpr", 126, 1067, 35),
        COMPLEXANNOTATIONINFRAGMENT("complexAnnotationInFragment", 124, 1065, 1),
        COMPLEXANNOTATIONINQUERY("complexAnnotationInQuery", 109, 914, 1),
        COMPLEXCOLFUNCTION("complexColFunction", 270, 2067, 1),
        COMPLEXCOLFUNCTIONIMPORT("complexColFunctionImport", 276, 2073, 1),
        COMPLEXCOLFUNCTIONIMPORTCALL("complexColFunctionImportCall", 41, 377, 3),
        COMPLEXCOLPATH("complexColPath", 19, 212, 12),
        COMPLEXCOLPATHEXPR("complexColPathExpr", 143, 1223, 7),
        COMPLEXCOLPROPERTY("complexColProperty", 259, 2048, 1),
        COMPLEXFUNCTION("complexFunction", 269, 2066, 1),
        COMPLEXFUNCTIONIMPORT("complexFunctionImport", 275, 2072, 1),
        COMPLEXFUNCTIONIMPORTCALL("complexFunctionImportCall", 40, 374, 3),
        COMPLEXPATH("complexPath", 20, 224, 12),
        COMPLEXPATHEXPR("complexPathExpr", 145, 1258, 11),
        COMPLEXPROPERTY("complexProperty", 258, 2047, 1),
        COMPLEXTYPENAME("complexTypeName", 243, 1988, 1),
        COMPOUNDKEY("compoundKey", 9, 136, 8),
        COMPUTE("compute", 62, 502, 10),
        COMPUTEDPROPERTY("computedProperty", 64, 518, 1),
        COMPUTEEXPR("computeExpr", 460, 3454, 3),
        COMPUTEITEM("computeItem", 63, 512, 6),
        COMPUTETRAFO("computeTrafo", 459, 3441, 13),
        CONCATMETHODCALLEXPR("concatMethodCallExpr", 156, 1391, 11),
        CONCATTRAFO("concatTrafo", 464, 3490, 13),
        CONCRETESPATIALTYPENAME("concreteSpatialTypeName", 253, 2031, 8),
        CONTAINMENTNAVIGATION("containmentNavigation", 116, 972, 7),
        CONTAINSMETHODCALLEXPR("containsMethodCallExpr", 157, 1402, 11),
        CONTENT_ID("content-id", 358, 2648, 5),
        CONTEXT("context", 113, 918, 3),
        CONTEXTFRAGMENT("contextFragment", 114, 921, 43),
        CONTEXTPROPERTYPATH("contextPropertyPath", 121, 1038, 14),
        CONTINUEONERRORPREFERENCE("continueOnErrorPreference", 369, 2729, 8),
        COUNT("count", 23, 242, 1),
        CROSSJOIN("crossjoin", 49, 413, 9),
        CUSTOMAGGREGATE("customAggregate", 455, 3403, 1),
        CUSTOMFROM("customFrom", 451, 3378, 9),
        CUSTOMFUNCTION("customFunction", 477, 3643, 8),
        CUSTOMNAME("customName", 107, 908, 4),
        CUSTOMQUERYOPTION("customQueryOption", 106, 902, 6),
        CUSTOMVALUE("customValue", 108, 912, 2),
        DATEMETHODCALLEXPR("dateMethodCallExpr", 175, 1558, 7),
        DATETIMEOFFSETVALUE("dateTimeOffsetValue", 301, 2264, 15),
        DATETIMEOFFSETVALUEINURL("dateTimeOffsetValueInUrl", 302, 2279, 15),
        DATEVALUE("dateValue", 300, 2258, 6),
        DAY("day", 311, 2397, 14),
        DAYMETHODCALLEXPR("dayMethodCallExpr", 169, 1516, 7),
        DEC_OCTET("dec-octet", 409, 3020, 16),
        DECIMALVALUE("decimalValue", 288, 2186, 19),
        DELTATOKEN("deltatoken", 101, 881, 5),
        DIGIT("DIGIT", 436, 3279, 1),
        DIRECTMEMBEREXPR("directMemberExpr", 131, 1128, 4),
        DISTANCEMETHODCALLEXPR("distanceMethodCallExpr", 184, 1615, 11),
        DIVBYEXPR("divbyExpr", 206, 1777, 5),
        DIVEXPR("divExpr", 205, 1772, 5),
        DOUBLEVALUE("doubleValue", 289, 2205, 1),
        DQUOTE("DQUOTE", 439, 3290, 1),
        DUMMYSTARTRULE("dummyStartRule", 0, 0, 4),
        DURATION("duration", 303, 2294, 6),
        DURATIONVALUE("durationValue", 304, 2300, 32),
        EACH("each", 22, 241, 1),
        END_ARRAY("end-array", 220, 1868, 5),
        END_OBJECT("end-object", 218, 1857, 5),
        ENDSWITHMETHODCALLEXPR("endsWithMethodCallExpr", 158, 1413, 11),
        ENTITYANNOTATIONINFRAGMENT("entityAnnotationInFragment", 125, 1066, 1),
        ENTITYANNOTATIONINQUERY("entityAnnotationInQuery", 110, 915, 1),
        ENTITYCASTOPTION("entityCastOption", 59, 474, 4),
        ENTITYCASTOPTIONS("entityCastOptions", 58, 464, 10),
        ENTITYCOLFUNCTION("entityColFunction", 268, 2065, 1),
        ENTITYCOLFUNCTIONIMPORT("entityColFunctionImport", 274, 2071, 1),
        ENTITYCOLFUNCTIONIMPORTCALL("entityColFunctionImportCall", 39, 371, 3),
        ENTITYCOLNAVIGATIONPROPERTY("entityColNavigationProperty", 263, 2054, 1),
        ENTITYFUNCTION("entityFunction", 267, 2064, 1),
        ENTITYFUNCTIONIMPORT("entityFunctionImport", 273, 2070, 1),
        ENTITYFUNCTIONIMPORTCALL("entityFunctionImportCall", 38, 368, 3),
        ENTITYIDOPTION("entityIdOption", 57, 461, 3),
        ENTITYNAVIGATIONPROPERTY("entityNavigationProperty", 262, 2053, 1),
        ENTITYOPTIONS("entityOptions", 56, 451, 10),
        ENTITYSET("entitySet", 115, 964, 8),
        ENTITYSETNAME("entitySetName", 240, 1985, 1),
        ENTITYTYPENAME("entityTypeName", 242, 1987, 1),
        ENUM("enum", 316, 2430, 6),
        ENUMERATIONMEMBER("enumerationMember", 246, 1991, 1),
        ENUMERATIONTYPENAME("enumerationTypeName", 245, 1990, 1),
        ENUMMEMBERVALUE("enumMemberValue", 319, 2445, 1),
        ENUMVALUE("enumValue", 317, 2436, 6),
        EQ("EQ", 388, 2825, 1),
        EQ_H("EQ-h", 382, 2800, 4),
        EQEXPR("eqExpr", 194, 1715, 5),
        ESCAPE("escape", 227, 1916, 3),
        EXCLUDEOPERATOR("excludeOperator", 373, 2766, 1),
        EXPAND("expand", 65, 519, 10),
        EXPANDCOUNTOPTION("expandCountOption", 68, 596, 3),
        EXPANDITEM("expandItem", 66, 529, 7),
        EXPANDNAVPATH("expandNavPath", 466, 3530, 22),
        EXPANDOPTION("expandOption", 70, 605, 9),
        EXPANDPATH("expandPath", 67, 536, 60),
        EXPANDREFOPTION("expandRefOption", 69, 599, 6),
        EXPANDTRAFO("expandTrafo", 465, 3503, 27),
        EXPRESSIONALIAS("expressionAlias", 454, 3402, 1),
        FILTER("filter", 72, 625, 6),
        FILTEREXPR("filterExpr", 142, 1218, 5),
        FILTERINPATH("filterInPath", 21, 236, 5),
        FILTERTRAFO("filterTrafo", 467, 3552, 7),
        FIRSTMEMBEREXPR("firstMemberExpr", 129, 1112, 8),
        FLOORMETHODCALLEXPR("floorMethodCallExpr", 182, 1601, 7),
        FORMAT("format", 78, 670, 15),
        FRACTIONALSECONDS("fractionalSeconds", 315, 2428, 2),
        FRACTIONALSECONDSMETHODCALLEXPR("fractionalsecondsMethodCallExpr", 173, 1544, 7),
        FRAGMENT("fragment", 418, 3075, 5),
        FROM("from", 481, 3669, 4),
        FULLCOLLECTIONLITERAL("fullCollectionLiteral", 321, 2451, 3),
        FULLLINESTRINGLITERAL("fullLineStringLiteral", 325, 2475, 3),
        FULLMULTILINESTRINGLITERAL("fullMultiLineStringLiteral", 329, 2494, 3),
        FULLMULTIPOINTLITERAL("fullMultiPointLiteral", 332, 2512, 3),
        FULLMULTIPOLYGONLITERAL("fullMultiPolygonLiteral", 335, 2530, 3),
        FULLPOINTLITERAL("fullPointLiteral", 338, 2548, 3),
        FULLPOLYGONLITERAL("fullPolygonLiteral", 344, 2581, 3),
        FUNCTION("function", 266, 2057, 7),
        FUNCTIONEXPR("functionExpr", 148, 1276, 36),
        FUNCTIONEXPRPARAMETER("functionExprParameter", 150, 1322, 6),
        FUNCTIONEXPRPARAMETERS("functionExprParameters", 149, 1312, 10),
        FUNCTIONIMPORTCALLNOPARENS("functionImportCallNoParens", 44, 386, 7),
        FUNCTIONPARAMETER("functionParameter", 46, 403, 6),
        FUNCTIONPARAMETERS("functionParameters", 45, 393, 10),
        GEEXPR("geExpr", 199, 1740, 5),
        GEOGRAPHYCOLLECTION("geographyCollection", 320, 2446, 5),
        GEOGRAPHYLINESTRING("geographyLineString", 324, 2470, 5),
        GEOGRAPHYMULTILINESTRING("geographyMultiLineString", 328, 2489, 5),
        GEOGRAPHYMULTIPOINT("geographyMultiPoint", 331, 2507, 5),
        GEOGRAPHYMULTIPOLYGON("geographyMultiPolygon", 334, 2525, 5),
        GEOGRAPHYPOINT("geographyPoint", 337, 2543, 5),
        GEOGRAPHYPOLYGON("geographyPolygon", 343, 2576, 5),
        GEOGRAPHYPREFIX("geographyPrefix", 355, 2638, 1),
        GEOLENGTHMETHODCALLEXPR("geoLengthMethodCallExpr", 185, 1626, 7),
        GEOLITERAL("geoLiteral", 323, 2462, 8),
        GEOMETRYCOLLECTION("geometryCollection", 348, 2603, 5),
        GEOMETRYLINESTRING("geometryLineString", 349, 2608, 5),
        GEOMETRYMULTILINESTRING("geometryMultiLineString", 350, 2613, 5),
        GEOMETRYMULTIPOINT("geometryMultiPoint", 351, 2618, 5),
        GEOMETRYMULTIPOLYGON("geometryMultiPolygon", 352, 2623, 5),
        GEOMETRYPOINT("geometryPoint", 353, 2628, 5),
        GEOMETRYPOLYGON("geometryPolygon", 354, 2633, 5),
        GEOMETRYPREFIX("geometryPrefix", 356, 2639, 1),
        GROUPBYELEMENT("groupbyElement", 471, 3591, 3),
        GROUPBYLIST("groupbyList", 470, 3579, 12),
        GROUPBYTRAFO("groupbyTrafo", 469, 3566, 13),
        GROUPINGPROPERTY("groupingProperty", 456, 3404, 11),
        GTEXPR("gtExpr", 198, 1735, 5),
        GUIDVALUE("guidValue", 292, 2211, 15),
        H16("h16", 406, 3004, 2),
        HASEXPR("hasExpr", 201, 1752, 5),
        HASH("HASH", 389, 2826, 1),
        HASSUBSEQUENCEMETHODCALLEXPR("hasSubsequenceMethodCallExpr", 188, 1655, 11),
        HASSUBSETMETHODCALLEXPR("hasSubsetMethodCallExpr", 187, 1644, 11),
        HEADER("header", 357, 2640, 8),
        HEXDIG("HEXDIG", 437, 3280, 3),
        HIER_PART("hier-part", 397, 2858, 7),
        HOST("host", 401, 2890, 4),
        HOUR("hour", 312, 2411, 13),
        HOURMETHODCALLEXPR("hourMethodCallExpr", 170, 1523, 7),
        HTAB("HTAB", 441, 3292, 1),
        ID("id", 60, 478, 6),
        IDENTIFIERCHARACTER("identifierCharacter", 250, 2000, 4),
        IDENTIFIERLEADINGCHARACTER("identifierLeadingCharacter", 249, 1997, 3),
        IDENTITYTRAFO("identityTrafo", 473, 3609, 1),
        IMPLICITVARIABLEEXPR("implicitVariableExpr", 138, 1196, 3),
        INCLUDEANNOTATIONSPREFERENCE("includeAnnotationsPreference", 370, 2737, 8),
        INDEX("index", 77, 663, 7),
        INDEXOFMETHODCALLEXPR("indexOfMethodCallExpr", 159, 1424, 11),
        INEXPR("inExpr", 200, 1745, 7),
        INLINECOUNT("inlinecount", 79, 685, 6),
        INSCOPEVARIABLEEXPR("inscopeVariableExpr", 137, 1192, 4),
        INT16VALUE("int16Value", 295, 2233, 5),
        INT32VALUE("int32Value", 296, 2238, 5),
        INT64VALUE("int64Value", 297, 2243, 5),
        INTERSECTSMETHODCALLEXPR("intersectsMethodCallExpr", 186, 1633, 11),
        IP_LITERAL("IP-literal", 403, 2896, 6),
        IPV4ADDRESS("IPv4address", 408, 3012, 8),
        IPV6ADDRESS("IPv6address", 405, 2912, 92),
        IPVFUTURE("IPvFuture", 404, 2902, 10),
        IRI_IN_HEADER("IRI-in-header", 433, 3270, 4),
        IRI_IN_QUERY("IRI-in-query", 434, 3274, 2),
        ISDEFINEDEXPR("isdefinedExpr", 478, 3651, 7),
        ISOFEXPR("isofExpr", 210, 1795, 13),
        ISOLATION("isolation", 359, 2653, 7),
        KEYPATHLITERAL("keyPathLiteral", 14, 158, 2),
        KEYPATHSEGMENTS("keyPathSegments", 13, 154, 4),
        KEYPREDICATE("keyPredicate", 7, 126, 4),
        KEYPROPERTYALIAS("keyPropertyAlias", 12, 153, 1),
        KEYPROPERTYVALUE("keyPropertyValue", 11, 152, 1),
        KEYVALUEPAIR("keyValuePair", 10, 144, 8),
        LAMBDAPREDICATEEXPR("lambdaPredicateExpr", 153, 1352, 1),
        LAMBDAVARIABLEEXPR("lambdaVariableExpr", 139, 1199, 1),
        LEEXPR("leExpr", 197, 1730, 5),
        LENGTHMETHODCALLEXPR("lengthMethodCallExpr", 160, 1435, 7),
        LEVELS("levels", 71, 614, 11),
        LINESTRINGDATA("lineStringData", 327, 2481, 8),
        LINESTRINGLITERAL("lineStringLiteral", 326, 2478, 3),
        LISTEXPR("listExpr", 191, 1693, 12),
        LS32("ls32", 407, 3006, 6),
        LTEXPR("ltExpr", 196, 1725, 5),
        MATCHESPATTERNMETHODCALLEXPR("matchesPatternMethodCallExpr", 161, 1442, 11),
        MAXDATETIMEMETHODCALLEXPR("maxDateTimeMethodCallExpr", 179, 1584, 5),
        MAXPAGESIZEPREFERENCE("maxpagesizePreference", 374, 2767, 8),
        MEMBER("member", 215, 1844, 4),
        MEMBEREXPR("memberExpr", 130, 1120, 8),
        METADATAOPTION("metadataOption", 55, 448, 3),
        METADATAOPTIONS("metadataOptions", 54, 442, 6),
        METHODCALLEXPR("methodCallExpr", 154, 1353, 30),
        MINDATETIMEMETHODCALLEXPR("minDateTimeMethodCallExpr", 178, 1579, 5),
        MINUTE("minute", 313, 2424, 1),
        MINUTEMETHODCALLEXPR("minuteMethodCallExpr", 171, 1530, 7),
        MODEXPR("modExpr", 207, 1782, 5),
        MONTH("month", 310, 2387, 10),
        MONTHMETHODCALLEXPR("monthMethodCallExpr", 168, 1509, 7),
        MULEXPR("mulExpr", 204, 1767, 5),
        MULTILINESTRINGLITERAL("multiLineStringLiteral", 330, 2497, 10),
        MULTIPOINTLITERAL("multiPointLiteral", 333, 2515, 10),
        MULTIPOLYGONLITERAL("multiPolygonLiteral", 336, 2533, 10),
        NAME_SEPARATOR("name-separator", 222, 1876, 4),
        NAMEANDVALUE("nameAndValue", 104, 895, 4),
        NAMESPACE("namespace", 238, 1978, 6),
        NAMESPACEPART("namespacePart", 239, 1984, 1),
        NANINFINITY("nanInfinity", 291, 2207, 4),
        NAVIGATION("navigation", 117, 979, 11),
        NAVIGATIONPROPERTY("navigationProperty", 261, 2050, 3),
        NEEXPR("neExpr", 195, 1720, 5),
        NEGATEEXPR("negateExpr", 208, 1787, 4),
        NOTEXPR("notExpr", 209, 1791, 4),
        NOWMETHODCALLEXPR("nowMethodCallExpr", 180, 1589, 5),
        NULLVALUE("nullValue", 281, 2133, 1),
        OBJECT("object", 214, 1834, 10),
        OBS_TEXT("obs-text", 379, 2791, 1),
        ODATA_ENTITYID("odata-entityid", 361, 2662, 5),
        ODATA_ERROR("odata-error", 362, 2667, 9),
        ODATA_MAXVERSION("odata-maxversion", 363, 2676, 9),
        ODATA_VERSION("odata-version", 364, 2685, 7),
        ODATAIDENTIFIER("odataIdentifier", 248, 1993, 4),
        ODATARELATIVEURI("odataRelativeUri", 3, 23, 31),
        ODATAURI("odataUri", 1, 4, 4),
        ONETONINE("oneToNine", 307, 2356, 10),
        OPEN("OPEN", 394, 2840, 3),
        OPTIONALLYQUALIFIEDACTIONNAME("optionallyQualifiedActionName", 98, 858, 6),
        OPTIONALLYQUALIFIEDCOMPLEXTYPENAME("optionallyQualifiedComplexTypeName", 237, 1972, 6),
        OPTIONALLYQUALIFIEDENTITYTYPENAME("optionallyQualifiedEntityTypeName", 236, 1966, 6),
        OPTIONALLYQUALIFIEDFUNCTIONNAME("optionallyQualifiedFunctionName", 99, 864, 11),
        OPTIONALLYQUALIFIEDTYPENAME("optionallyQualifiedTypeName", 229, 1926, 13),
        ORDERBY("orderby", 73, 631, 10),
        ORDERBYITEM("orderbyItem", 74, 641, 8),
        ORDINALINDEX("ordinalIndex", 27, 246, 4),
        OREXPR("orExpr", 193, 1710, 5),
        OTHER_DELIMS("other-delims", 422, 3097, 8),
        OWS("OWS", 380, 2792, 4),
        PARAMETERALIAS("parameterAlias", 48, 410, 3),
        PARAMETERNAME("parameterName", 47, 409, 1),
        PARAMETERNAMES("parameterNames", 100, 875, 6),
        PARAMETERVALUE("parameterValue", 105, 899, 3),
        PARENEXPR("parenExpr", 190, 1687, 6),
        PATH_ABEMPTY("path-abempty", 411, 3041, 4),
        PATH_ABSOLUTE("path-absolute", 412, 3045, 9),
        PATH_ROOTLESS("path-rootless", 413, 3054, 6),
        PATHPREFIX("pathPrefix", 457, 3415, 11),
        PATHSEGMENT("pathSegment", 458, 3426, 15),
        PCHAR("pchar", 416, 3064, 6),
        PCHAR_NO_SQUOTE("pchar-no-SQUOTE", 423, 3105, 9),
        PCT_ENCODED("pct-encoded", 419, 3080, 4),
        PCT_ENCODED_NO_DQUOTE("pct-encoded-no-DQUOTE", 432, 3241, 29),
        PCT_ENCODED_NO_SQUOTE("pct-encoded-no-SQUOTE", 424, 3114, 28),
        PCT_ENCODED_UNESCAPED("pct-encoded-unescaped", 431, 3203, 38),
        POINTDATA("pointData", 341, 2560, 4),
        POINTLITERAL("pointLiteral", 340, 2557, 3),
        POLYGONDATA("polygonData", 346, 2587, 8),
        POLYGONLITERAL("polygonLiteral", 345, 2584, 3),
        PORT("port", 402, 2894, 2),
        POSITIONLITERAL("positionLiteral", 342, 2564, 12),
        PREFER("prefer", 365, 2692, 11),
        PREFERENCE("preference", 366, 2703, 10),
        PRIMITIVEANNOTATIONINQUERY("primitiveAnnotationInQuery", 111, 916, 1),
        PRIMITIVECOLANNOTATIONINQUERY("primitiveColAnnotationInQuery", 112, 917, 1),
        PRIMITIVECOLFUNCTION("primitiveColFunction", 272, 2069, 1),
        PRIMITIVECOLFUNCTIONIMPORT("primitiveColFunctionImport", 278, 2075, 1),
        PRIMITIVECOLFUNCTIONIMPORTCALL("primitiveColFunctionImportCall", 43, 383, 3),
        PRIMITIVECOLPATH("primitiveColPath", 17, 203, 5),
        PRIMITIVECOLPROPERTY("primitiveColProperty", 257, 2046, 1),
        PRIMITIVEFUNCTION("primitiveFunction", 271, 2068, 1),
        PRIMITIVEFUNCTIONIMPORT("primitiveFunctionImport", 277, 2074, 1),
        PRIMITIVEFUNCTIONIMPORTCALL("primitiveFunctionImportCall", 42, 380, 3),
        PRIMITIVEKEYPROPERTY("primitiveKeyProperty", 255, 2044, 1),
        PRIMITIVELITERAL("primitiveLiteral", 279, 2076, 33),
        PRIMITIVENONKEYPROPERTY("primitiveNonKeyProperty", 256, 2045, 1),
        PRIMITIVEPATH("primitivePath", 18, 208, 4),
        PRIMITIVEPATHEXPR("primitivePathExpr", 146, 1269, 6),
        PRIMITIVEPROPERTY("primitiveProperty", 254, 2039, 5),
        PRIMITIVETYPENAME("primitiveTypeName", 251, 2004, 24),
        PRIMITIVEVALUE("primitiveValue", 280, 2109, 24),
        PROPERTYPATH("propertyPath", 16, 174, 29),
        PROPERTYPATHEXPR("propertyPathExpr", 132, 1132, 29),
        QCHAR_JSON_SPECIAL("qchar-JSON-special", 226, 1909, 7),
        QCHAR_NO_AMP("qchar-no-AMP", 425, 3142, 11),
        QCHAR_NO_AMP_DQUOTE("qchar-no-AMP-DQUOTE", 429, 3181, 11),
        QCHAR_NO_AMP_EQ("qchar-no-AMP-EQ", 426, 3153, 10),
        QCHAR_NO_AMP_EQ_AT_DOLLAR("qchar-no-AMP-EQ-AT-DOLLAR", 427, 3163, 8),
        QCHAR_NO_AMP_SQUOTE("qchar-no-AMP-SQUOTE", 428, 3171, 10),
        QCHAR_UNESCAPED("qchar-unescaped", 430, 3192, 11),
        QUALIFIEDACTIONNAME("qualifiedActionName", 122, 1052, 4),
        QUALIFIEDCOMPLEXTYPENAME("qualifiedComplexTypeName", 233, 1954, 4),
        QUALIFIEDENTITYTYPENAME("qualifiedEntityTypeName", 232, 1950, 4),
        QUALIFIEDENUMTYPENAME("qualifiedEnumTypeName", 235, 1962, 4),
        QUALIFIEDFUNCTIONNAME("qualifiedFunctionName", 123, 1056, 9),
        QUALIFIEDTYPEDEFINITIONNAME("qualifiedTypeDefinitionName", 234, 1958, 4),
        QUALIFIEDTYPENAME("qualifiedTypeName", 228, 1919, 7),
        QUERY("query", 417, 3070, 5),
        QUERYOPTION("queryOption", 51, 428, 5),
        QUERYOPTIONS("queryOptions", 50, 422, 6),
        QUERYSEGMENT("querySegment", 26, 245, 1),
        QUOTATION_MARK("quotation-mark", 221, 1873, 3),
        REF("ref", 24, 243, 1),
        REG_NAME("reg-name", 410, 3036, 5),
        REQUEST_ID("request-id", 360, 2660, 2),
        RESOURCEPATH("resourcePath", 4, 54, 48),
        RESPONDASYNCPREFERENCE("respondAsyncPreference", 375, 2775, 1),
        RETURNPREFERENCE("returnPreference", 376, 2776, 6),
        RINGLITERAL("ringLiteral", 347, 2595, 8),
        ROLLUPSPEC("rollupSpec", 472, 3594, 15),
        ROOTEXPR("rootExpr", 128, 1103, 9),
        ROUNDMETHODCALLEXPR("roundMethodCallExpr", 181, 1594, 7),
        RWS("RWS", 383, 2804, 6),
        SBYTEVALUE("sbyteValue", 294, 2228, 5),
        SCHEMAVERSION("schemaversion", 80, 691, 9),
        SCHEME("scheme", 398, 2865, 9),
        SEARCH("search", 81, 700, 9),
        SEARCHANDEXPR("searchAndExpr", 86, 734, 7),
        SEARCHCHAR("searchChar", 89, 754, 13),
        SEARCHEXPR("searchExpr", 82, 709, 10),
        SEARCHEXPR_INCOMPLETE("searchExpr-incomplete", 90, 767, 9),
        SEARCHNEGATEEXPR("searchNegateExpr", 84, 725, 4),
        SEARCHOREXPR("searchOrExpr", 85, 729, 5),
        SEARCHPARENEXPR("searchParenExpr", 83, 719, 6),
        SEARCHPHRASE("searchPhrase", 87, 741, 7),
        SEARCHTRAFO("searchTrafo", 468, 3559, 7),
        SEARCHWORD("searchWord", 88, 748, 6),
        SECOND("second", 314, 2425, 3),
        SECONDMETHODCALLEXPR("secondMethodCallExpr", 172, 1537, 7),
        SEGMENT("segment", 414, 3060, 2),
        SEGMENT_NZ("segment-nz", 415, 3062, 2),
        SELECT("select", 91, 776, 10),
        SELECTITEM("selectItem", 92, 786, 15),
        SELECTLIST("selectList", 118, 990, 10),
        SELECTLISTITEM("selectListItem", 119, 1000, 14),
        SELECTLISTPROPERTY("selectListProperty", 120, 1014, 24),
        SELECTOPTION("selectOption", 96, 849, 5),
        SELECTOPTIONPC("selectOptionPC", 95, 842, 7),
        SELECTPATH("selectPath", 94, 833, 9),
        SELECTPROPERTY("selectProperty", 93, 801, 32),
        SEMI("SEMI", 391, 2831, 3),
        SERVICEROOT("serviceRoot", 2, 8, 15),
        SIGN("SIGN", 390, 2827, 4),
        SIMPLEKEY("simpleKey", 8, 130, 6),
        SINGLEENUMVALUE("singleEnumValue", 318, 2442, 3),
        SINGLENAVIGATION("singleNavigation", 15, 160, 14),
        SINGLENAVIGATIONEXPR("singleNavigationExpr", 141, 1215, 3),
        SINGLEQUALIFIEDTYPENAME("singleQualifiedTypeName", 230, 1939, 6),
        SINGLETONENTITY("singletonEntity", 241, 1986, 1),
        SINGLETYPENAME("singleTypeName", 231, 1945, 5),
        SINGLEVALUE("singleValue", 290, 2206, 1),
        SKIP("skip", 75, 649, 7),
        SKIPTOKEN("skiptoken", 102, 886, 5),
        SP("SP", 440, 3291, 1),
        SQUOTE("SQUOTE", 393, 2837, 3),
        SQUOTE_IN_STRING("SQUOTE-in-string", 299, 2255, 3),
        SRIDLITERAL("sridLiteral", 339, 2551, 6),
        STAR("STAR", 392, 2834, 3),
        STARTSWITHMETHODCALLEXPR("startsWithMethodCallExpr", 162, 1453, 11),
        STREAMPROPERTY("streamProperty", 260, 2049, 1),
        STRING("string", 298, 2248, 7),
        STRINGINURL("stringInUrl", 224, 1884, 5),
        SUB_DELIMS("sub-delims", 421, 3091, 6),
        SUBEXPR("subExpr", 203, 1762, 5),
        SUBSTRINGMETHODCALLEXPR("substringMethodCallExpr", 163, 1464, 17),
        SYSTEMAT("systemat", 483, 3677, 4),
        SYSTEMFROM("systemfrom", 484, 3681, 4),
        SYSTEMQUERYOPTION("systemQueryOption", 61, 484, 18),
        SYSTEMTO("systemto", 485, 3685, 4),
        TEMPORALEXPR("temporalExpr", 486, 3689, 5),
        TEMPORALOPTION("temporalOption", 479, 3658, 7),
        TERMNAME("termName", 247, 1992, 1),
        TIMEMETHODCALLEXPR("timeMethodCallExpr", 176, 1565, 7),
        TIMEOFDAYVALUE("timeOfDayValue", 305, 2332, 12),
        TIMEOFDAYVALUEINURL("timeOfDayValueInUrl", 306, 2344, 12),
        TO("to", 482, 3673, 4),
        TOLOWERMETHODCALLEXPR("toLowerMethodCallExpr", 164, 1481, 7),
        TOP("top", 76, 656, 7),
        TOPCOUNTTRAFO("topcountTrafo", 474, 3610, 11),
        TOPPERCENTTRAFO("toppercentTrafo", 475, 3621, 11),
        TOPSUMTRAFO("topsumTrafo", 476, 3632, 11),
        TOTALOFFSETMINUTESMETHODCALLEXPR("totalOffsetMinutesMethodCallExpr", 177, 1572, 7),
        TOTALSECONDSMETHODCALLEXPR("totalsecondsMethodCallExpr", 174, 1551, 7),
        TOUPPERMETHODCALLEXPR("toUpperMethodCallExpr", 165, 1488, 7),
        TRACKCHANGESPREFERENCE("trackChangesPreference", 377, 2782, 4),
        TRIMMETHODCALLEXPR("trimMethodCallExpr", 166, 1495, 7),
        TYPEDEFINITIONNAME("typeDefinitionName", 244, 1989, 1),
        UNRESERVED("unreserved", 420, 3084, 7),
        URI("URI", 396, 2846, 12),
        USERINFO("userinfo", 400, 2884, 6),
        VALUE("value", 25, 244, 1),
        VALUE_SEPARATOR("value-separator", 223, 1880, 4),
        VALUEINURL("valueInUrl", 216, 1848, 3),
        VCHAR("VCHAR", 442, 3293, 1),
        WAITPREFERENCE("waitPreference", 378, 2786, 5),
        YEAR("year", 309, 2375, 12),
        YEARMETHODCALLEXPR("yearMethodCallExpr", 167, 1502, 7),
        ZEROTOFIFTYNINE("zeroToFiftyNine", 308, 2366, 9);
        private String name;
        private int id;
        private int offset;
        private int count;
        RuleNames(String string, int id, int offset, int count){
            this.name = string;
            this.id = id;
            this.offset = offset;
            this.count = count;
        }
        public  String ruleName(){return name;}
        public  int    ruleID(){return id;}
        private int    opcodeOffset(){return offset;}
        private int    opcodeCount(){return count;}
    }

    // UDT name enum
    public static int udtCount = 0;
    public enum UdtNames{
    }

    // private
    private static GrammarUnderTest factoryInstance = null;
    private GrammarUnderTest(Rule[] rules, Udt[] udts, Opcode[] opcodes){
        super(rules, udts, opcodes);
    }

    private static Rule[] getRules(){
    	Rule[] rules = new Rule[487];
        for(RuleNames r : RuleNames.values()){
            rules[r.ruleID()] = getRule(r.ruleID(), r.ruleName(), r.opcodeOffset(), r.opcodeCount());
        }
        return rules;
    }

    private static Udt[] getUdts(){
    	Udt[] udts = new Udt[0];
        return udts;
    }

        // opcodes
    private static Opcode[] getOpcodes(){
    	Opcode[] op = new Opcode[3694];
    	addOpcodes00(op);
    	addOpcodes01(op);
        return op;
    }

    private static void addOpcodes00(Opcode[] op){
        {int[] a = {1,2,3}; op[0] = getOpcodeAlt(a);}
        op[1] = getOpcodeRnm(1, 4); // odataUri
        op[2] = getOpcodeRnm(357, 2640); // header
        op[3] = getOpcodeRnm(280, 2109); // primitiveValue
        {int[] a = {5,6}; op[4] = getOpcodeCat(a);}
        op[5] = getOpcodeRnm(2, 8); // serviceRoot
        op[6] = getOpcodeRep((char)0, (char)1, 7);
        op[7] = getOpcodeRnm(3, 23); // odataRelativeUri
        {int[] a = {9,12,13,14,18,19}; op[8] = getOpcodeCat(a);}
        {int[] a = {10,11}; op[9] = getOpcodeAlt(a);}
        {char[] a = {104,116,116,112,115}; op[10] = getOpcodeTls(a);}
        {char[] a = {104,116,116,112}; op[11] = getOpcodeTls(a);}
        {char[] a = {58,47,47}; op[12] = getOpcodeTls(a);}
        op[13] = getOpcodeRnm(401, 2890); // host
        op[14] = getOpcodeRep((char)0, (char)1, 15);
        {int[] a = {16,17}; op[15] = getOpcodeCat(a);}
        {char[] a = {58}; op[16] = getOpcodeTls(a);}
        op[17] = getOpcodeRnm(402, 2894); // port
        {char[] a = {47}; op[18] = getOpcodeTls(a);}
        op[19] = getOpcodeRep((char)0, Character.MAX_VALUE, 20);
        {int[] a = {21,22}; op[20] = getOpcodeCat(a);}
        op[21] = getOpcodeRnm(415, 3062); // segment-nz
        {char[] a = {47}; op[22] = getOpcodeTls(a);}
        {int[] a = {24,30,34,40,48}; op[23] = getOpcodeAlt(a);}
        {int[] a = {25,26}; op[24] = getOpcodeCat(a);}
        {char[] a = {36,98,97,116,99,104}; op[25] = getOpcodeTbs(a);}
        op[26] = getOpcodeRep((char)0, (char)1, 27);
        {int[] a = {28,29}; op[27] = getOpcodeCat(a);}
        {char[] a = {63}; op[28] = getOpcodeTls(a);}
        op[29] = getOpcodeRnm(52, 433); // batchOptions
        {int[] a = {31,32,33}; op[30] = getOpcodeCat(a);}
        {char[] a = {36,101,110,116,105,116,121}; op[31] = getOpcodeTbs(a);}
        {char[] a = {63}; op[32] = getOpcodeTls(a);}
        op[33] = getOpcodeRnm(56, 451); // entityOptions
        {int[] a = {35,36,37,38,39}; op[34] = getOpcodeCat(a);}
        {char[] a = {36,101,110,116,105,116,121}; op[35] = getOpcodeTbs(a);}
        {char[] a = {47}; op[36] = getOpcodeTls(a);}
        op[37] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        {char[] a = {63}; op[38] = getOpcodeTls(a);}
        op[39] = getOpcodeRnm(58, 464); // entityCastOptions
        {int[] a = {41,42,46}; op[40] = getOpcodeCat(a);}
        {char[] a = {36,109,101,116,97,100,97,116,97}; op[41] = getOpcodeTbs(a);}
        op[42] = getOpcodeRep((char)0, (char)1, 43);
        {int[] a = {44,45}; op[43] = getOpcodeCat(a);}
        {char[] a = {63}; op[44] = getOpcodeTls(a);}
        op[45] = getOpcodeRnm(54, 442); // metadataOptions
        op[46] = getOpcodeRep((char)0, (char)1, 47);
        op[47] = getOpcodeRnm(113, 918); // context
        {int[] a = {49,50}; op[48] = getOpcodeCat(a);}
        op[49] = getOpcodeRnm(4, 54); // resourcePath
        op[50] = getOpcodeRep((char)0, (char)1, 51);
        {int[] a = {52,53}; op[51] = getOpcodeCat(a);}
        {char[] a = {63}; op[52] = getOpcodeTls(a);}
        op[53] = getOpcodeRnm(50, 422); // queryOptions
        {int[] a = {55,59,63,64,68,72,76,80,84,88,92,96}; op[54] = getOpcodeAlt(a);}
        {int[] a = {56,57}; op[55] = getOpcodeCat(a);}
        op[56] = getOpcodeRnm(240, 1985); // entitySetName
        op[57] = getOpcodeRep((char)0, (char)1, 58);
        op[58] = getOpcodeRnm(5, 102); // collectionNavigation
        {int[] a = {60,61}; op[59] = getOpcodeCat(a);}
        op[60] = getOpcodeRnm(241, 1986); // singletonEntity
        op[61] = getOpcodeRep((char)0, (char)1, 62);
        op[62] = getOpcodeRnm(15, 160); // singleNavigation
        op[63] = getOpcodeRnm(29, 282); // actionImportCall
        {int[] a = {65,66}; op[64] = getOpcodeCat(a);}
        op[65] = getOpcodeRnm(39, 371); // entityColFunctionImportCall
        op[66] = getOpcodeRep((char)0, (char)1, 67);
        op[67] = getOpcodeRnm(5, 102); // collectionNavigation
        {int[] a = {69,70}; op[68] = getOpcodeCat(a);}
        op[69] = getOpcodeRnm(38, 368); // entityFunctionImportCall
        op[70] = getOpcodeRep((char)0, (char)1, 71);
        op[71] = getOpcodeRnm(15, 160); // singleNavigation
        {int[] a = {73,74}; op[72] = getOpcodeCat(a);}
        op[73] = getOpcodeRnm(41, 377); // complexColFunctionImportCall
        op[74] = getOpcodeRep((char)0, (char)1, 75);
        op[75] = getOpcodeRnm(19, 212); // complexColPath
        {int[] a = {77,78}; op[76] = getOpcodeCat(a);}
        op[77] = getOpcodeRnm(40, 374); // complexFunctionImportCall
        op[78] = getOpcodeRep((char)0, (char)1, 79);
        op[79] = getOpcodeRnm(20, 224); // complexPath
        {int[] a = {81,82}; op[80] = getOpcodeCat(a);}
        op[81] = getOpcodeRnm(43, 383); // primitiveColFunctionImportCall
        op[82] = getOpcodeRep((char)0, (char)1, 83);
        op[83] = getOpcodeRnm(17, 203); // primitiveColPath
        {int[] a = {85,86}; op[84] = getOpcodeCat(a);}
        op[85] = getOpcodeRnm(42, 380); // primitiveFunctionImportCall
        op[86] = getOpcodeRep((char)0, (char)1, 87);
        op[87] = getOpcodeRnm(18, 208); // primitivePath
        {int[] a = {89,90}; op[88] = getOpcodeCat(a);}
        op[89] = getOpcodeRnm(44, 386); // functionImportCallNoParens
        op[90] = getOpcodeRep((char)0, (char)1, 91);
        op[91] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {93,94}; op[92] = getOpcodeCat(a);}
        op[93] = getOpcodeRnm(49, 413); // crossjoin
        op[94] = getOpcodeRep((char)0, (char)1, 95);
        op[95] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {97,98}; op[96] = getOpcodeCat(a);}
        {char[] a = {36,97,108,108}; op[97] = getOpcodeTbs(a);}
        op[98] = getOpcodeRep((char)0, (char)1, 99);
        {int[] a = {100,101}; op[99] = getOpcodeCat(a);}
        {char[] a = {47}; op[100] = getOpcodeTls(a);}
        op[101] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        {int[] a = {103,107}; op[102] = getOpcodeCat(a);}
        op[103] = getOpcodeRep((char)0, (char)1, 104);
        {int[] a = {105,106}; op[104] = getOpcodeCat(a);}
        {char[] a = {47}; op[105] = getOpcodeTls(a);}
        op[106] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        op[107] = getOpcodeRep((char)0, (char)1, 108);
        op[108] = getOpcodeRnm(6, 109); // collectionNavPath
        {int[] a = {110,114,118,122,123,124,125}; op[109] = getOpcodeAlt(a);}
        {int[] a = {111,112}; op[110] = getOpcodeCat(a);}
        op[111] = getOpcodeRnm(7, 126); // keyPredicate
        op[112] = getOpcodeRep((char)0, (char)1, 113);
        op[113] = getOpcodeRnm(15, 160); // singleNavigation
        {int[] a = {115,116}; op[114] = getOpcodeCat(a);}
        op[115] = getOpcodeRnm(21, 236); // filterInPath
        op[116] = getOpcodeRep((char)0, (char)1, 117);
        op[117] = getOpcodeRnm(5, 102); // collectionNavigation
        {int[] a = {119,120}; op[118] = getOpcodeCat(a);}
        op[119] = getOpcodeRnm(22, 241); // each
        op[120] = getOpcodeRep((char)0, (char)1, 121);
        op[121] = getOpcodeRnm(28, 250); // boundOperation
        op[122] = getOpcodeRnm(28, 250); // boundOperation
        op[123] = getOpcodeRnm(23, 242); // count
        op[124] = getOpcodeRnm(24, 243); // ref
        op[125] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {127,128,129}; op[126] = getOpcodeAlt(a);}
        op[127] = getOpcodeRnm(8, 130); // simpleKey
        op[128] = getOpcodeRnm(9, 136); // compoundKey
        op[129] = getOpcodeRnm(13, 154); // keyPathSegments
        {int[] a = {131,132,135}; op[130] = getOpcodeCat(a);}
        op[131] = getOpcodeRnm(394, 2840); // OPEN
        {int[] a = {133,134}; op[132] = getOpcodeAlt(a);}
        op[133] = getOpcodeRnm(48, 410); // parameterAlias
        op[134] = getOpcodeRnm(11, 152); // keyPropertyValue
        op[135] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {137,138,139,143}; op[136] = getOpcodeCat(a);}
        op[137] = getOpcodeRnm(394, 2840); // OPEN
        op[138] = getOpcodeRnm(10, 144); // keyValuePair
        op[139] = getOpcodeRep((char)0, Character.MAX_VALUE, 140);
        {int[] a = {141,142}; op[140] = getOpcodeCat(a);}
        op[141] = getOpcodeRnm(387, 2822); // COMMA
        op[142] = getOpcodeRnm(10, 144); // keyValuePair
        op[143] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {145,148,149}; op[144] = getOpcodeCat(a);}
        {int[] a = {146,147}; op[145] = getOpcodeAlt(a);}
        op[146] = getOpcodeRnm(255, 2044); // primitiveKeyProperty
        op[147] = getOpcodeRnm(12, 153); // keyPropertyAlias
        op[148] = getOpcodeRnm(388, 2825); // EQ
        {int[] a = {150,151}; op[149] = getOpcodeAlt(a);}
        op[150] = getOpcodeRnm(48, 410); // parameterAlias
        op[151] = getOpcodeRnm(11, 152); // keyPropertyValue
        op[152] = getOpcodeRnm(279, 2076); // primitiveLiteral
        op[153] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[154] = getOpcodeRep((char)1, Character.MAX_VALUE, 155);
        {int[] a = {156,157}; op[155] = getOpcodeCat(a);}
        {char[] a = {47}; op[156] = getOpcodeTls(a);}
        op[157] = getOpcodeRnm(14, 158); // keyPathLiteral
        op[158] = getOpcodeRep((char)0, Character.MAX_VALUE, 159);
        op[159] = getOpcodeRnm(416, 3064); // pchar
        {int[] a = {161,165}; op[160] = getOpcodeCat(a);}
        op[161] = getOpcodeRep((char)0, (char)1, 162);
        {int[] a = {163,164}; op[162] = getOpcodeCat(a);}
        {char[] a = {47}; op[163] = getOpcodeTls(a);}
        op[164] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        op[165] = getOpcodeRep((char)0, (char)1, 166);
        {int[] a = {167,170,171,172,173}; op[166] = getOpcodeAlt(a);}
        {int[] a = {168,169}; op[167] = getOpcodeCat(a);}
        {char[] a = {47}; op[168] = getOpcodeTls(a);}
        op[169] = getOpcodeRnm(16, 174); // propertyPath
        op[170] = getOpcodeRnm(28, 250); // boundOperation
        op[171] = getOpcodeRnm(24, 243); // ref
        op[172] = getOpcodeRnm(25, 244); // value
        op[173] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {175,179,183,187,191,195,199}; op[174] = getOpcodeAlt(a);}
        {int[] a = {176,177}; op[175] = getOpcodeCat(a);}
        op[176] = getOpcodeRnm(263, 2054); // entityColNavigationProperty
        op[177] = getOpcodeRep((char)0, (char)1, 178);
        op[178] = getOpcodeRnm(5, 102); // collectionNavigation
        {int[] a = {180,181}; op[179] = getOpcodeCat(a);}
        op[180] = getOpcodeRnm(262, 2053); // entityNavigationProperty
        op[181] = getOpcodeRep((char)0, (char)1, 182);
        op[182] = getOpcodeRnm(15, 160); // singleNavigation
        {int[] a = {184,185}; op[183] = getOpcodeCat(a);}
        op[184] = getOpcodeRnm(259, 2048); // complexColProperty
        op[185] = getOpcodeRep((char)0, (char)1, 186);
        op[186] = getOpcodeRnm(19, 212); // complexColPath
        {int[] a = {188,189}; op[187] = getOpcodeCat(a);}
        op[188] = getOpcodeRnm(258, 2047); // complexProperty
        op[189] = getOpcodeRep((char)0, (char)1, 190);
        op[190] = getOpcodeRnm(20, 224); // complexPath
        {int[] a = {192,193}; op[191] = getOpcodeCat(a);}
        op[192] = getOpcodeRnm(257, 2046); // primitiveColProperty
        op[193] = getOpcodeRep((char)0, (char)1, 194);
        op[194] = getOpcodeRnm(17, 203); // primitiveColPath
        {int[] a = {196,197}; op[195] = getOpcodeCat(a);}
        op[196] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[197] = getOpcodeRep((char)0, (char)1, 198);
        op[198] = getOpcodeRnm(18, 208); // primitivePath
        {int[] a = {200,201}; op[199] = getOpcodeCat(a);}
        op[200] = getOpcodeRnm(260, 2049); // streamProperty
        op[201] = getOpcodeRep((char)0, (char)1, 202);
        op[202] = getOpcodeRnm(28, 250); // boundOperation
        {int[] a = {204,205,206,207}; op[203] = getOpcodeAlt(a);}
        op[204] = getOpcodeRnm(23, 242); // count
        op[205] = getOpcodeRnm(28, 250); // boundOperation
        op[206] = getOpcodeRnm(27, 246); // ordinalIndex
        op[207] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {209,210,211}; op[208] = getOpcodeAlt(a);}
        op[209] = getOpcodeRnm(25, 244); // value
        op[210] = getOpcodeRnm(28, 250); // boundOperation
        op[211] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {213,214}; op[212] = getOpcodeAlt(a);}
        op[213] = getOpcodeRnm(27, 246); // ordinalIndex
        {int[] a = {215,219}; op[214] = getOpcodeCat(a);}
        op[215] = getOpcodeRep((char)0, (char)1, 216);
        {int[] a = {217,218}; op[216] = getOpcodeCat(a);}
        {char[] a = {47}; op[217] = getOpcodeTls(a);}
        op[218] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        op[219] = getOpcodeRep((char)0, (char)1, 220);
        {int[] a = {221,222,223}; op[220] = getOpcodeAlt(a);}
        op[221] = getOpcodeRnm(23, 242); // count
        op[222] = getOpcodeRnm(28, 250); // boundOperation
        op[223] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {225,229}; op[224] = getOpcodeCat(a);}
        op[225] = getOpcodeRep((char)0, (char)1, 226);
        {int[] a = {227,228}; op[226] = getOpcodeCat(a);}
        {char[] a = {47}; op[227] = getOpcodeTls(a);}
        op[228] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        op[229] = getOpcodeRep((char)0, (char)1, 230);
        {int[] a = {231,234,235}; op[230] = getOpcodeAlt(a);}
        {int[] a = {232,233}; op[231] = getOpcodeCat(a);}
        {char[] a = {47}; op[232] = getOpcodeTls(a);}
        op[233] = getOpcodeRnm(16, 174); // propertyPath
        op[234] = getOpcodeRnm(28, 250); // boundOperation
        op[235] = getOpcodeRnm(26, 245); // querySegment
        {int[] a = {237,238,239,240}; op[236] = getOpcodeCat(a);}
        {char[] a = {47,36,102,105,108,116,101,114}; op[237] = getOpcodeTbs(a);}
        op[238] = getOpcodeRnm(394, 2840); // OPEN
        op[239] = getOpcodeRnm(127, 1102); // boolCommonExpr
        op[240] = getOpcodeRnm(395, 2843); // CLOSE
        {char[] a = {47,36,101,97,99,104}; op[241] = getOpcodeTbs(a);}
        {char[] a = {47,36,99,111,117,110,116}; op[242] = getOpcodeTbs(a);}
        {char[] a = {47,36,114,101,102}; op[243] = getOpcodeTbs(a);}
        {char[] a = {47,36,118,97,108,117,101}; op[244] = getOpcodeTbs(a);}
        {char[] a = {47,36,113,117,101,114,121}; op[245] = getOpcodeTbs(a);}
        {int[] a = {247,248}; op[246] = getOpcodeCat(a);}
        {char[] a = {47}; op[247] = getOpcodeTls(a);}
        op[248] = getOpcodeRep((char)1, Character.MAX_VALUE, 249);
        op[249] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {251,252}; op[250] = getOpcodeCat(a);}
        {char[] a = {47}; op[251] = getOpcodeTls(a);}
        {int[] a = {253,254,258,262,266,270,274,278}; op[252] = getOpcodeAlt(a);}
        op[253] = getOpcodeRnm(30, 283); // boundActionCall
        {int[] a = {255,256}; op[254] = getOpcodeCat(a);}
        op[255] = getOpcodeRnm(32, 296); // boundEntityColFunctionCall
        op[256] = getOpcodeRep((char)0, (char)1, 257);
        op[257] = getOpcodeRnm(5, 102); // collectionNavigation
        {int[] a = {259,260}; op[258] = getOpcodeCat(a);}
        op[259] = getOpcodeRnm(31, 289); // boundEntityFunctionCall
        op[260] = getOpcodeRep((char)0, (char)1, 261);
        op[261] = getOpcodeRnm(15, 160); // singleNavigation
        {int[] a = {263,264}; op[262] = getOpcodeCat(a);}
        op[263] = getOpcodeRnm(34, 310); // boundComplexColFunctionCall
        op[264] = getOpcodeRep((char)0, (char)1, 265);
        op[265] = getOpcodeRnm(19, 212); // complexColPath
        {int[] a = {267,268}; op[266] = getOpcodeCat(a);}
        op[267] = getOpcodeRnm(33, 303); // boundComplexFunctionCall
        op[268] = getOpcodeRep((char)0, (char)1, 269);
        op[269] = getOpcodeRnm(20, 224); // complexPath
        {int[] a = {271,272}; op[270] = getOpcodeCat(a);}
        op[271] = getOpcodeRnm(36, 324); // boundPrimitiveColFunctionCall
        op[272] = getOpcodeRep((char)0, (char)1, 273);
        op[273] = getOpcodeRnm(17, 203); // primitiveColPath
        {int[] a = {275,276}; op[274] = getOpcodeCat(a);}
        op[275] = getOpcodeRnm(35, 317); // boundPrimitiveFunctionCall
        op[276] = getOpcodeRep((char)0, (char)1, 277);
        op[277] = getOpcodeRnm(18, 208); // primitivePath
        {int[] a = {279,280}; op[278] = getOpcodeCat(a);}
        op[279] = getOpcodeRnm(37, 331); // boundFunctionCallNoParens
        op[280] = getOpcodeRep((char)0, (char)1, 281);
        op[281] = getOpcodeRnm(26, 245); // querySegment
        op[282] = getOpcodeRnm(265, 2056); // actionImport
        {int[] a = {284,288}; op[283] = getOpcodeCat(a);}
        op[284] = getOpcodeRep((char)0, (char)1, 285);
        {int[] a = {286,287}; op[285] = getOpcodeCat(a);}
        op[286] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[287] = getOpcodeTls(a);}
        op[288] = getOpcodeRnm(264, 2055); // action
        {int[] a = {290,294,295}; op[289] = getOpcodeCat(a);}
        op[290] = getOpcodeRep((char)0, (char)1, 291);
        {int[] a = {292,293}; op[291] = getOpcodeCat(a);}
        op[292] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[293] = getOpcodeTls(a);}
        op[294] = getOpcodeRnm(267, 2064); // entityFunction
        op[295] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {297,301,302}; op[296] = getOpcodeCat(a);}
        op[297] = getOpcodeRep((char)0, (char)1, 298);
        {int[] a = {299,300}; op[298] = getOpcodeCat(a);}
        op[299] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[300] = getOpcodeTls(a);}
        op[301] = getOpcodeRnm(268, 2065); // entityColFunction
        op[302] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {304,308,309}; op[303] = getOpcodeCat(a);}
        op[304] = getOpcodeRep((char)0, (char)1, 305);
        {int[] a = {306,307}; op[305] = getOpcodeCat(a);}
        op[306] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[307] = getOpcodeTls(a);}
        op[308] = getOpcodeRnm(269, 2066); // complexFunction
        op[309] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {311,315,316}; op[310] = getOpcodeCat(a);}
        op[311] = getOpcodeRep((char)0, (char)1, 312);
        {int[] a = {313,314}; op[312] = getOpcodeCat(a);}
        op[313] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[314] = getOpcodeTls(a);}
        op[315] = getOpcodeRnm(270, 2067); // complexColFunction
        op[316] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {318,322,323}; op[317] = getOpcodeCat(a);}
        op[318] = getOpcodeRep((char)0, (char)1, 319);
        {int[] a = {320,321}; op[319] = getOpcodeCat(a);}
        op[320] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[321] = getOpcodeTls(a);}
        op[322] = getOpcodeRnm(271, 2068); // primitiveFunction
        op[323] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {325,329,330}; op[324] = getOpcodeCat(a);}
        op[325] = getOpcodeRep((char)0, (char)1, 326);
        {int[] a = {327,328}; op[326] = getOpcodeCat(a);}
        op[327] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[328] = getOpcodeTls(a);}
        op[329] = getOpcodeRnm(272, 2069); // primitiveColFunction
        op[330] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {332,338,344,350,356,362}; op[331] = getOpcodeAlt(a);}
        {int[] a = {333,337}; op[332] = getOpcodeCat(a);}
        op[333] = getOpcodeRep((char)0, (char)1, 334);
        {int[] a = {335,336}; op[334] = getOpcodeCat(a);}
        op[335] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[336] = getOpcodeTls(a);}
        op[337] = getOpcodeRnm(267, 2064); // entityFunction
        {int[] a = {339,343}; op[338] = getOpcodeCat(a);}
        op[339] = getOpcodeRep((char)0, (char)1, 340);
        {int[] a = {341,342}; op[340] = getOpcodeCat(a);}
        op[341] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[342] = getOpcodeTls(a);}
        op[343] = getOpcodeRnm(268, 2065); // entityColFunction
        {int[] a = {345,349}; op[344] = getOpcodeCat(a);}
        op[345] = getOpcodeRep((char)0, (char)1, 346);
        {int[] a = {347,348}; op[346] = getOpcodeCat(a);}
        op[347] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[348] = getOpcodeTls(a);}
        op[349] = getOpcodeRnm(269, 2066); // complexFunction
        {int[] a = {351,355}; op[350] = getOpcodeCat(a);}
        op[351] = getOpcodeRep((char)0, (char)1, 352);
        {int[] a = {353,354}; op[352] = getOpcodeCat(a);}
        op[353] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[354] = getOpcodeTls(a);}
        op[355] = getOpcodeRnm(270, 2067); // complexColFunction
        {int[] a = {357,361}; op[356] = getOpcodeCat(a);}
        op[357] = getOpcodeRep((char)0, (char)1, 358);
        {int[] a = {359,360}; op[358] = getOpcodeCat(a);}
        op[359] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[360] = getOpcodeTls(a);}
        op[361] = getOpcodeRnm(271, 2068); // primitiveFunction
        {int[] a = {363,367}; op[362] = getOpcodeCat(a);}
        op[363] = getOpcodeRep((char)0, (char)1, 364);
        {int[] a = {365,366}; op[364] = getOpcodeCat(a);}
        op[365] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[366] = getOpcodeTls(a);}
        op[367] = getOpcodeRnm(272, 2069); // primitiveColFunction
        {int[] a = {369,370}; op[368] = getOpcodeCat(a);}
        op[369] = getOpcodeRnm(273, 2070); // entityFunctionImport
        op[370] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {372,373}; op[371] = getOpcodeCat(a);}
        op[372] = getOpcodeRnm(274, 2071); // entityColFunctionImport
        op[373] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {375,376}; op[374] = getOpcodeCat(a);}
        op[375] = getOpcodeRnm(275, 2072); // complexFunctionImport
        op[376] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {378,379}; op[377] = getOpcodeCat(a);}
        op[378] = getOpcodeRnm(276, 2073); // complexColFunctionImport
        op[379] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {381,382}; op[380] = getOpcodeCat(a);}
        op[381] = getOpcodeRnm(277, 2074); // primitiveFunctionImport
        op[382] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {384,385}; op[383] = getOpcodeCat(a);}
        op[384] = getOpcodeRnm(278, 2075); // primitiveColFunctionImport
        op[385] = getOpcodeRnm(45, 393); // functionParameters
        {int[] a = {387,388,389,390,391,392}; op[386] = getOpcodeAlt(a);}
        op[387] = getOpcodeRnm(273, 2070); // entityFunctionImport
        op[388] = getOpcodeRnm(274, 2071); // entityColFunctionImport
        op[389] = getOpcodeRnm(275, 2072); // complexFunctionImport
        op[390] = getOpcodeRnm(276, 2073); // complexColFunctionImport
        op[391] = getOpcodeRnm(277, 2074); // primitiveFunctionImport
        op[392] = getOpcodeRnm(278, 2075); // primitiveColFunctionImport
        {int[] a = {394,395,402}; op[393] = getOpcodeCat(a);}
        op[394] = getOpcodeRnm(394, 2840); // OPEN
        op[395] = getOpcodeRep((char)0, (char)1, 396);
        {int[] a = {397,398}; op[396] = getOpcodeCat(a);}
        op[397] = getOpcodeRnm(46, 403); // functionParameter
        op[398] = getOpcodeRep((char)0, Character.MAX_VALUE, 399);
        {int[] a = {400,401}; op[399] = getOpcodeCat(a);}
        op[400] = getOpcodeRnm(387, 2822); // COMMA
        op[401] = getOpcodeRnm(46, 403); // functionParameter
        op[402] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {404,405,406}; op[403] = getOpcodeCat(a);}
        op[404] = getOpcodeRnm(47, 409); // parameterName
        op[405] = getOpcodeRnm(388, 2825); // EQ
        {int[] a = {407,408}; op[406] = getOpcodeAlt(a);}
        op[407] = getOpcodeRnm(48, 410); // parameterAlias
        op[408] = getOpcodeRnm(279, 2076); // primitiveLiteral
        op[409] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {411,412}; op[410] = getOpcodeCat(a);}
        op[411] = getOpcodeRnm(385, 2816); // AT
        op[412] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {414,415,416,417,421}; op[413] = getOpcodeCat(a);}
        {char[] a = {36,99,114,111,115,115,106,111,105,110}; op[414] = getOpcodeTbs(a);}
        op[415] = getOpcodeRnm(394, 2840); // OPEN
        op[416] = getOpcodeRnm(240, 1985); // entitySetName
        op[417] = getOpcodeRep((char)0, Character.MAX_VALUE, 418);
        {int[] a = {419,420}; op[418] = getOpcodeCat(a);}
        op[419] = getOpcodeRnm(387, 2822); // COMMA
        op[420] = getOpcodeRnm(240, 1985); // entitySetName
        op[421] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {423,424}; op[422] = getOpcodeCat(a);}
        op[423] = getOpcodeRnm(51, 428); // queryOption
        op[424] = getOpcodeRep((char)0, Character.MAX_VALUE, 425);
        {int[] a = {426,427}; op[425] = getOpcodeCat(a);}
        {char[] a = {38}; op[426] = getOpcodeTls(a);}
        op[427] = getOpcodeRnm(51, 428); // queryOption
        {int[] a = {429,430,431,432}; op[428] = getOpcodeAlt(a);}
        op[429] = getOpcodeRnm(61, 484); // systemQueryOption
        op[430] = getOpcodeRnm(103, 891); // aliasAndValue
        op[431] = getOpcodeRnm(104, 895); // nameAndValue
        op[432] = getOpcodeRnm(106, 902); // customQueryOption
        {int[] a = {434,435}; op[433] = getOpcodeCat(a);}
        op[434] = getOpcodeRnm(53, 439); // batchOption
        op[435] = getOpcodeRep((char)0, Character.MAX_VALUE, 436);
        {int[] a = {437,438}; op[436] = getOpcodeCat(a);}
        {char[] a = {38}; op[437] = getOpcodeTls(a);}
        op[438] = getOpcodeRnm(53, 439); // batchOption
        {int[] a = {440,441}; op[439] = getOpcodeAlt(a);}
        op[440] = getOpcodeRnm(78, 670); // format
        op[441] = getOpcodeRnm(106, 902); // customQueryOption
        {int[] a = {443,444}; op[442] = getOpcodeCat(a);}
        op[443] = getOpcodeRnm(55, 448); // metadataOption
        op[444] = getOpcodeRep((char)0, Character.MAX_VALUE, 445);
        {int[] a = {446,447}; op[445] = getOpcodeCat(a);}
        {char[] a = {38}; op[446] = getOpcodeTls(a);}
        op[447] = getOpcodeRnm(55, 448); // metadataOption
        {int[] a = {449,450}; op[448] = getOpcodeAlt(a);}
        op[449] = getOpcodeRnm(78, 670); // format
        op[450] = getOpcodeRnm(106, 902); // customQueryOption
        {int[] a = {452,456,457}; op[451] = getOpcodeCat(a);}
        op[452] = getOpcodeRep((char)0, Character.MAX_VALUE, 453);
        {int[] a = {454,455}; op[453] = getOpcodeCat(a);}
        op[454] = getOpcodeRnm(57, 461); // entityIdOption
        {char[] a = {38}; op[455] = getOpcodeTls(a);}
        op[456] = getOpcodeRnm(60, 478); // id
        op[457] = getOpcodeRep((char)0, Character.MAX_VALUE, 458);
        {int[] a = {459,460}; op[458] = getOpcodeCat(a);}
        {char[] a = {38}; op[459] = getOpcodeTls(a);}
        op[460] = getOpcodeRnm(57, 461); // entityIdOption
        {int[] a = {462,463}; op[461] = getOpcodeAlt(a);}
        op[462] = getOpcodeRnm(78, 670); // format
        op[463] = getOpcodeRnm(106, 902); // customQueryOption
        {int[] a = {465,469,470}; op[464] = getOpcodeCat(a);}
        op[465] = getOpcodeRep((char)0, Character.MAX_VALUE, 466);
        {int[] a = {467,468}; op[466] = getOpcodeCat(a);}
        op[467] = getOpcodeRnm(59, 474); // entityCastOption
        {char[] a = {38}; op[468] = getOpcodeTls(a);}
        op[469] = getOpcodeRnm(60, 478); // id
        op[470] = getOpcodeRep((char)0, Character.MAX_VALUE, 471);
        {int[] a = {472,473}; op[471] = getOpcodeCat(a);}
        {char[] a = {38}; op[472] = getOpcodeTls(a);}
        op[473] = getOpcodeRnm(59, 474); // entityCastOption
        {int[] a = {475,476,477}; op[474] = getOpcodeAlt(a);}
        op[475] = getOpcodeRnm(57, 461); // entityIdOption
        op[476] = getOpcodeRnm(65, 519); // expand
        op[477] = getOpcodeRnm(91, 776); // select
        {int[] a = {479,482,483}; op[478] = getOpcodeCat(a);}
        {int[] a = {480,481}; op[479] = getOpcodeAlt(a);}
        {char[] a = {36,105,100}; op[480] = getOpcodeTls(a);}
        {char[] a = {105,100}; op[481] = getOpcodeTls(a);}
        op[482] = getOpcodeRnm(388, 2825); // EQ
        op[483] = getOpcodeRnm(434, 3274); // IRI-in-query
        {int[] a = {485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501}; op[484] = getOpcodeAlt(a);}
        op[485] = getOpcodeRnm(62, 502); // compute
        op[486] = getOpcodeRnm(101, 881); // deltatoken
        op[487] = getOpcodeRnm(65, 519); // expand
        op[488] = getOpcodeRnm(72, 625); // filter
        op[489] = getOpcodeRnm(78, 670); // format
        op[490] = getOpcodeRnm(60, 478); // id
        op[491] = getOpcodeRnm(79, 685); // inlinecount
        op[492] = getOpcodeRnm(73, 631); // orderby
        op[493] = getOpcodeRnm(80, 691); // schemaversion
        op[494] = getOpcodeRnm(81, 700); // search
        op[495] = getOpcodeRnm(91, 776); // select
        op[496] = getOpcodeRnm(75, 649); // skip
        op[497] = getOpcodeRnm(102, 886); // skiptoken
        op[498] = getOpcodeRnm(76, 656); // top
        op[499] = getOpcodeRnm(77, 663); // index
        op[500] = getOpcodeRnm(443, 3294); // apply
        op[501] = getOpcodeRnm(479, 3658); // temporalOption
        {int[] a = {503,506,507,508}; op[502] = getOpcodeCat(a);}
        {int[] a = {504,505}; op[503] = getOpcodeAlt(a);}
        {char[] a = {36,99,111,109,112,117,116,101}; op[504] = getOpcodeTls(a);}
        {char[] a = {99,111,109,112,117,116,101}; op[505] = getOpcodeTls(a);}
        op[506] = getOpcodeRnm(388, 2825); // EQ
        op[507] = getOpcodeRnm(63, 512); // computeItem
        op[508] = getOpcodeRep((char)0, Character.MAX_VALUE, 509);
        {int[] a = {510,511}; op[509] = getOpcodeCat(a);}
        op[510] = getOpcodeRnm(387, 2822); // COMMA
        op[511] = getOpcodeRnm(63, 512); // computeItem
        {int[] a = {513,514,515,516,517}; op[512] = getOpcodeCat(a);}
        op[513] = getOpcodeRnm(126, 1067); // commonExpr
        op[514] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {97,115}; op[515] = getOpcodeTls(a);}
        op[516] = getOpcodeRnm(383, 2804); // RWS
        op[517] = getOpcodeRnm(64, 518); // computedProperty
        op[518] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {520,523,524,525}; op[519] = getOpcodeCat(a);}
        {int[] a = {521,522}; op[520] = getOpcodeAlt(a);}
        {char[] a = {36,101,120,112,97,110,100}; op[521] = getOpcodeTls(a);}
        {char[] a = {101,120,112,97,110,100}; op[522] = getOpcodeTls(a);}
        op[523] = getOpcodeRnm(388, 2825); // EQ
        op[524] = getOpcodeRnm(66, 529); // expandItem
        op[525] = getOpcodeRep((char)0, Character.MAX_VALUE, 526);
        {int[] a = {527,528}; op[526] = getOpcodeCat(a);}
        op[527] = getOpcodeRnm(387, 2822); // COMMA
        op[528] = getOpcodeRnm(66, 529); // expandItem
        {int[] a = {530,531,532}; op[529] = getOpcodeAlt(a);}
        {char[] a = {36,118,97,108,117,101}; op[530] = getOpcodeTls(a);}
        op[531] = getOpcodeRnm(67, 536); // expandPath
        {int[] a = {533,534,535}; op[532] = getOpcodeCat(a);}
        op[533] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        {char[] a = {47}; op[534] = getOpcodeTls(a);}
        op[535] = getOpcodeRnm(67, 536); // expandPath
        {int[] a = {537,545}; op[536] = getOpcodeCat(a);}
        op[537] = getOpcodeRep((char)0, Character.MAX_VALUE, 538);
        {int[] a = {539,544}; op[538] = getOpcodeCat(a);}
        {int[] a = {540,541,542,543}; op[539] = getOpcodeAlt(a);}
        op[540] = getOpcodeRnm(258, 2047); // complexProperty
        op[541] = getOpcodeRnm(259, 2048); // complexColProperty
        op[542] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        op[543] = getOpcodeRnm(109, 914); // complexAnnotationInQuery
        {char[] a = {47}; op[544] = getOpcodeTls(a);}
        {int[] a = {546,555,556}; op[545] = getOpcodeAlt(a);}
        {int[] a = {547,548}; op[546] = getOpcodeCat(a);}
        op[547] = getOpcodeRnm(392, 2834); // STAR
        op[548] = getOpcodeRep((char)0, (char)1, 549);
        {int[] a = {550,551}; op[549] = getOpcodeAlt(a);}
        op[550] = getOpcodeRnm(24, 243); // ref
        {int[] a = {552,553,554}; op[551] = getOpcodeCat(a);}
        op[552] = getOpcodeRnm(394, 2840); // OPEN
        op[553] = getOpcodeRnm(71, 614); // levels
        op[554] = getOpcodeRnm(395, 2843); // CLOSE
        op[555] = getOpcodeRnm(260, 2049); // streamProperty
        {int[] a = {557,560,564}; op[556] = getOpcodeCat(a);}
        {int[] a = {558,559}; op[557] = getOpcodeAlt(a);}
        op[558] = getOpcodeRnm(261, 2050); // navigationProperty
        op[559] = getOpcodeRnm(110, 915); // entityAnnotationInQuery
        op[560] = getOpcodeRep((char)0, (char)1, 561);
        {int[] a = {562,563}; op[561] = getOpcodeCat(a);}
        {char[] a = {47}; op[562] = getOpcodeTls(a);}
        op[563] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        op[564] = getOpcodeRep((char)0, (char)1, 565);
        {int[] a = {566,577,588}; op[565] = getOpcodeAlt(a);}
        {int[] a = {567,568}; op[566] = getOpcodeCat(a);}
        op[567] = getOpcodeRnm(24, 243); // ref
        op[568] = getOpcodeRep((char)0, (char)1, 569);
        {int[] a = {570,571,572,576}; op[569] = getOpcodeCat(a);}
        op[570] = getOpcodeRnm(394, 2840); // OPEN
        op[571] = getOpcodeRnm(69, 599); // expandRefOption
        op[572] = getOpcodeRep((char)0, Character.MAX_VALUE, 573);
        {int[] a = {574,575}; op[573] = getOpcodeCat(a);}
        op[574] = getOpcodeRnm(391, 2831); // SEMI
        op[575] = getOpcodeRnm(69, 599); // expandRefOption
        op[576] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {578,579}; op[577] = getOpcodeCat(a);}
        op[578] = getOpcodeRnm(23, 242); // count
        op[579] = getOpcodeRep((char)0, (char)1, 580);
        {int[] a = {581,582,583,587}; op[580] = getOpcodeCat(a);}
        op[581] = getOpcodeRnm(394, 2840); // OPEN
        op[582] = getOpcodeRnm(68, 596); // expandCountOption
        op[583] = getOpcodeRep((char)0, Character.MAX_VALUE, 584);
        {int[] a = {585,586}; op[584] = getOpcodeCat(a);}
        op[585] = getOpcodeRnm(391, 2831); // SEMI
        op[586] = getOpcodeRnm(68, 596); // expandCountOption
        op[587] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {589,590,591,595}; op[588] = getOpcodeCat(a);}
        op[589] = getOpcodeRnm(394, 2840); // OPEN
        op[590] = getOpcodeRnm(70, 605); // expandOption
        op[591] = getOpcodeRep((char)0, Character.MAX_VALUE, 592);
        {int[] a = {593,594}; op[592] = getOpcodeCat(a);}
        op[593] = getOpcodeRnm(391, 2831); // SEMI
        op[594] = getOpcodeRnm(70, 605); // expandOption
        op[595] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {597,598}; op[596] = getOpcodeAlt(a);}
        op[597] = getOpcodeRnm(72, 625); // filter
        op[598] = getOpcodeRnm(81, 700); // search
        {int[] a = {600,601,602,603,604}; op[599] = getOpcodeAlt(a);}
        op[600] = getOpcodeRnm(68, 596); // expandCountOption
        op[601] = getOpcodeRnm(73, 631); // orderby
        op[602] = getOpcodeRnm(75, 649); // skip
        op[603] = getOpcodeRnm(76, 656); // top
        op[604] = getOpcodeRnm(79, 685); // inlinecount
        {int[] a = {606,607,608,609,610,611,612,613}; op[605] = getOpcodeAlt(a);}
        op[606] = getOpcodeRnm(69, 599); // expandRefOption
        op[607] = getOpcodeRnm(91, 776); // select
        op[608] = getOpcodeRnm(65, 519); // expand
        op[609] = getOpcodeRnm(62, 502); // compute
        op[610] = getOpcodeRnm(71, 614); // levels
        op[611] = getOpcodeRnm(103, 891); // aliasAndValue
        op[612] = getOpcodeRnm(443, 3294); // apply
        op[613] = getOpcodeRnm(479, 3658); // temporalOption
        {int[] a = {615,618,619}; op[614] = getOpcodeCat(a);}
        {int[] a = {616,617}; op[615] = getOpcodeAlt(a);}
        {char[] a = {36,108,101,118,101,108,115}; op[616] = getOpcodeTls(a);}
        {char[] a = {108,101,118,101,108,115}; op[617] = getOpcodeTls(a);}
        op[618] = getOpcodeRnm(388, 2825); // EQ
        {int[] a = {620,624}; op[619] = getOpcodeAlt(a);}
        {int[] a = {621,622}; op[620] = getOpcodeCat(a);}
        op[621] = getOpcodeRnm(307, 2356); // oneToNine
        op[622] = getOpcodeRep((char)0, Character.MAX_VALUE, 623);
        op[623] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {109,97,120}; op[624] = getOpcodeTls(a);}
        {int[] a = {626,629,630}; op[625] = getOpcodeCat(a);}
        {int[] a = {627,628}; op[626] = getOpcodeAlt(a);}
        {char[] a = {36,102,105,108,116,101,114}; op[627] = getOpcodeTls(a);}
        {char[] a = {102,105,108,116,101,114}; op[628] = getOpcodeTls(a);}
        op[629] = getOpcodeRnm(388, 2825); // EQ
        op[630] = getOpcodeRnm(127, 1102); // boolCommonExpr
        {int[] a = {632,635,636,637}; op[631] = getOpcodeCat(a);}
        {int[] a = {633,634}; op[632] = getOpcodeAlt(a);}
        {char[] a = {36,111,114,100,101,114,98,121}; op[633] = getOpcodeTls(a);}
        {char[] a = {111,114,100,101,114,98,121}; op[634] = getOpcodeTls(a);}
        op[635] = getOpcodeRnm(388, 2825); // EQ
        op[636] = getOpcodeRnm(74, 641); // orderbyItem
        op[637] = getOpcodeRep((char)0, Character.MAX_VALUE, 638);
        {int[] a = {639,640}; op[638] = getOpcodeCat(a);}
        op[639] = getOpcodeRnm(387, 2822); // COMMA
        op[640] = getOpcodeRnm(74, 641); // orderbyItem
        {int[] a = {642,643}; op[641] = getOpcodeCat(a);}
        op[642] = getOpcodeRnm(126, 1067); // commonExpr
        op[643] = getOpcodeRep((char)0, (char)1, 644);
        {int[] a = {645,646}; op[644] = getOpcodeCat(a);}
        op[645] = getOpcodeRnm(383, 2804); // RWS
        {int[] a = {647,648}; op[646] = getOpcodeAlt(a);}
        {char[] a = {97,115,99}; op[647] = getOpcodeTls(a);}
        {char[] a = {100,101,115,99}; op[648] = getOpcodeTls(a);}
        {int[] a = {650,653,654}; op[649] = getOpcodeCat(a);}
        {int[] a = {651,652}; op[650] = getOpcodeAlt(a);}
        {char[] a = {36,115,107,105,112}; op[651] = getOpcodeTls(a);}
        {char[] a = {115,107,105,112}; op[652] = getOpcodeTls(a);}
        op[653] = getOpcodeRnm(388, 2825); // EQ
        op[654] = getOpcodeRep((char)1, Character.MAX_VALUE, 655);
        op[655] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {657,660,661}; op[656] = getOpcodeCat(a);}
        {int[] a = {658,659}; op[657] = getOpcodeAlt(a);}
        {char[] a = {36,116,111,112}; op[658] = getOpcodeTls(a);}
        {char[] a = {116,111,112}; op[659] = getOpcodeTls(a);}
        op[660] = getOpcodeRnm(388, 2825); // EQ
        op[661] = getOpcodeRep((char)1, Character.MAX_VALUE, 662);
        op[662] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {664,667,668}; op[663] = getOpcodeCat(a);}
        {int[] a = {665,666}; op[664] = getOpcodeAlt(a);}
        {char[] a = {36,105,110,100,101,120}; op[665] = getOpcodeTls(a);}
        {char[] a = {105,110,100,101,120}; op[666] = getOpcodeTls(a);}
        op[667] = getOpcodeRnm(388, 2825); // EQ
        op[668] = getOpcodeRep((char)1, Character.MAX_VALUE, 669);
        op[669] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {671,674,675}; op[670] = getOpcodeCat(a);}
        {int[] a = {672,673}; op[671] = getOpcodeAlt(a);}
        {char[] a = {36,102,111,114,109,97,116}; op[672] = getOpcodeTls(a);}
        {char[] a = {102,111,114,109,97,116}; op[673] = getOpcodeTls(a);}
        op[674] = getOpcodeRnm(388, 2825); // EQ
        {int[] a = {676,677,678,679}; op[675] = getOpcodeAlt(a);}
        {char[] a = {97,116,111,109}; op[676] = getOpcodeTls(a);}
        {char[] a = {106,115,111,110}; op[677] = getOpcodeTls(a);}
        {char[] a = {120,109,108}; op[678] = getOpcodeTls(a);}
        {int[] a = {680,682,683}; op[679] = getOpcodeCat(a);}
        op[680] = getOpcodeRep((char)1, Character.MAX_VALUE, 681);
        op[681] = getOpcodeRnm(416, 3064); // pchar
        {char[] a = {47}; op[682] = getOpcodeTls(a);}
        op[683] = getOpcodeRep((char)1, Character.MAX_VALUE, 684);
        op[684] = getOpcodeRnm(416, 3064); // pchar
        {int[] a = {686,689,690}; op[685] = getOpcodeCat(a);}
        {int[] a = {687,688}; op[686] = getOpcodeAlt(a);}
        {char[] a = {36,99,111,117,110,116}; op[687] = getOpcodeTls(a);}
        {char[] a = {99,111,117,110,116}; op[688] = getOpcodeTls(a);}
        op[689] = getOpcodeRnm(388, 2825); // EQ
        op[690] = getOpcodeRnm(287, 2183); // booleanValue
        {int[] a = {692,695,696}; op[691] = getOpcodeCat(a);}
        {int[] a = {693,694}; op[692] = getOpcodeAlt(a);}
        {char[] a = {36,115,99,104,101,109,97,118,101,114,115,105,111,110}; op[693] = getOpcodeTls(a);}
        {char[] a = {115,99,104,101,109,97,118,101,114,115,105,111,110}; op[694] = getOpcodeTls(a);}
        op[695] = getOpcodeRnm(388, 2825); // EQ
        {int[] a = {697,698}; op[696] = getOpcodeAlt(a);}
        op[697] = getOpcodeRnm(392, 2834); // STAR
        op[698] = getOpcodeRep((char)1, Character.MAX_VALUE, 699);
        op[699] = getOpcodeRnm(420, 3084); // unreserved
        {int[] a = {701,704,705,706}; op[700] = getOpcodeCat(a);}
        {int[] a = {702,703}; op[701] = getOpcodeAlt(a);}
        {char[] a = {36,115,101,97,114,99,104}; op[702] = getOpcodeTls(a);}
        {char[] a = {115,101,97,114,99,104}; op[703] = getOpcodeTls(a);}
        op[704] = getOpcodeRnm(388, 2825); // EQ
        op[705] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {707,708}; op[706] = getOpcodeAlt(a);}
        op[707] = getOpcodeRnm(82, 709); // searchExpr
        op[708] = getOpcodeRnm(90, 767); // searchExpr-incomplete
        {int[] a = {710,715}; op[709] = getOpcodeCat(a);}
        {int[] a = {711,712,713,714}; op[710] = getOpcodeAlt(a);}
        op[711] = getOpcodeRnm(83, 719); // searchParenExpr
        op[712] = getOpcodeRnm(84, 725); // searchNegateExpr
        op[713] = getOpcodeRnm(87, 741); // searchPhrase
        op[714] = getOpcodeRnm(88, 748); // searchWord
        op[715] = getOpcodeRep((char)0, (char)1, 716);
        {int[] a = {717,718}; op[716] = getOpcodeAlt(a);}
        op[717] = getOpcodeRnm(85, 729); // searchOrExpr
        op[718] = getOpcodeRnm(86, 734); // searchAndExpr
        {int[] a = {720,721,722,723,724}; op[719] = getOpcodeCat(a);}
        op[720] = getOpcodeRnm(394, 2840); // OPEN
        op[721] = getOpcodeRnm(384, 2810); // BWS
        op[722] = getOpcodeRnm(82, 709); // searchExpr
        op[723] = getOpcodeRnm(384, 2810); // BWS
        op[724] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {726,727,728}; op[725] = getOpcodeCat(a);}
        {char[] a = {78,79,84}; op[726] = getOpcodeTbs(a);}
        op[727] = getOpcodeRnm(383, 2804); // RWS
        op[728] = getOpcodeRnm(82, 709); // searchExpr
        {int[] a = {730,731,732,733}; op[729] = getOpcodeCat(a);}
        op[730] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {79,82}; op[731] = getOpcodeTbs(a);}
        op[732] = getOpcodeRnm(383, 2804); // RWS
        op[733] = getOpcodeRnm(82, 709); // searchExpr
        {int[] a = {735,736,740}; op[734] = getOpcodeCat(a);}
        op[735] = getOpcodeRnm(383, 2804); // RWS
        op[736] = getOpcodeRep((char)0, (char)1, 737);
        {int[] a = {738,739}; op[737] = getOpcodeCat(a);}
        {char[] a = {65,78,68}; op[738] = getOpcodeTbs(a);}
        op[739] = getOpcodeRnm(383, 2804); // RWS
        op[740] = getOpcodeRnm(82, 709); // searchExpr
        {int[] a = {742,743,747}; op[741] = getOpcodeCat(a);}
        op[742] = getOpcodeRnm(221, 1873); // quotation-mark
        op[743] = getOpcodeRep((char)1, Character.MAX_VALUE, 744);
        {int[] a = {745,746}; op[744] = getOpcodeAlt(a);}
        op[745] = getOpcodeRnm(429, 3181); // qchar-no-AMP-DQUOTE
        op[746] = getOpcodeRnm(440, 3291); // SP
        op[747] = getOpcodeRnm(221, 1873); // quotation-mark
        {int[] a = {749,750}; op[748] = getOpcodeCat(a);}
        op[749] = getOpcodeRnm(89, 754); // searchChar
        op[750] = getOpcodeRep((char)0, Character.MAX_VALUE, 751);
        {int[] a = {752,753}; op[751] = getOpcodeAlt(a);}
        op[752] = getOpcodeRnm(89, 754); // searchChar
        op[753] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {755,756,757,758,759,760,761,762,763,764,765,766}; op[754] = getOpcodeAlt(a);}
        op[755] = getOpcodeRnm(420, 3084); // unreserved
        op[756] = getOpcodeRnm(432, 3241); // pct-encoded-no-DQUOTE
        {char[] a = {33}; op[757] = getOpcodeTls(a);}
        {char[] a = {42}; op[758] = getOpcodeTls(a);}
        {char[] a = {43}; op[759] = getOpcodeTls(a);}
        {char[] a = {44}; op[760] = getOpcodeTls(a);}
        {char[] a = {58}; op[761] = getOpcodeTls(a);}
        {char[] a = {64}; op[762] = getOpcodeTls(a);}
        {char[] a = {47}; op[763] = getOpcodeTls(a);}
        {char[] a = {63}; op[764] = getOpcodeTls(a);}
        {char[] a = {36}; op[765] = getOpcodeTls(a);}
        {char[] a = {61}; op[766] = getOpcodeTls(a);}
        {int[] a = {768,769,775}; op[767] = getOpcodeCat(a);}
        op[768] = getOpcodeRnm(393, 2837); // SQUOTE
        op[769] = getOpcodeRep((char)0, Character.MAX_VALUE, 770);
        {int[] a = {771,772,773,774}; op[770] = getOpcodeAlt(a);}
        op[771] = getOpcodeRnm(299, 2255); // SQUOTE-in-string
        op[772] = getOpcodeRnm(428, 3171); // qchar-no-AMP-SQUOTE
        op[773] = getOpcodeRnm(221, 1873); // quotation-mark
        op[774] = getOpcodeRnm(440, 3291); // SP
        op[775] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {777,780,781,782}; op[776] = getOpcodeCat(a);}
        {int[] a = {778,779}; op[777] = getOpcodeAlt(a);}
        {char[] a = {36,115,101,108,101,99,116}; op[778] = getOpcodeTls(a);}
        {char[] a = {115,101,108,101,99,116}; op[779] = getOpcodeTls(a);}
        op[780] = getOpcodeRnm(388, 2825); // EQ
        op[781] = getOpcodeRnm(92, 786); // selectItem
        op[782] = getOpcodeRep((char)0, Character.MAX_VALUE, 783);
        {int[] a = {784,785}; op[783] = getOpcodeCat(a);}
        op[784] = getOpcodeRnm(387, 2822); // COMMA
        op[785] = getOpcodeRnm(92, 786); // selectItem
        {int[] a = {787,788,789,790,791,792}; op[786] = getOpcodeAlt(a);}
        op[787] = getOpcodeRnm(392, 2834); // STAR
        op[788] = getOpcodeRnm(97, 854); // allOperationsInSchema
        op[789] = getOpcodeRnm(93, 801); // selectProperty
        op[790] = getOpcodeRnm(98, 858); // optionallyQualifiedActionName
        op[791] = getOpcodeRnm(99, 864); // optionallyQualifiedFunctionName
        {int[] a = {793,796,797}; op[792] = getOpcodeCat(a);}
        {int[] a = {794,795}; op[793] = getOpcodeAlt(a);}
        op[794] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        op[795] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        {char[] a = {47}; op[796] = getOpcodeTls(a);}
        {int[] a = {798,799,800}; op[797] = getOpcodeAlt(a);}
        op[798] = getOpcodeRnm(93, 801); // selectProperty
        op[799] = getOpcodeRnm(98, 858); // optionallyQualifiedActionName
        op[800] = getOpcodeRnm(99, 864); // optionallyQualifiedFunctionName
        {int[] a = {802,803,804,817,818}; op[801] = getOpcodeAlt(a);}
        op[802] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[803] = getOpcodeRnm(111, 916); // primitiveAnnotationInQuery
        {int[] a = {805,808}; op[804] = getOpcodeCat(a);}
        {int[] a = {806,807}; op[805] = getOpcodeAlt(a);}
        op[806] = getOpcodeRnm(257, 2046); // primitiveColProperty
        op[807] = getOpcodeRnm(112, 917); // primitiveColAnnotationInQuery
        op[808] = getOpcodeRep((char)0, (char)1, 809);
        {int[] a = {810,811,812,816}; op[809] = getOpcodeCat(a);}
        op[810] = getOpcodeRnm(394, 2840); // OPEN
        op[811] = getOpcodeRnm(95, 842); // selectOptionPC
        op[812] = getOpcodeRep((char)0, Character.MAX_VALUE, 813);
        {int[] a = {814,815}; op[813] = getOpcodeCat(a);}
        op[814] = getOpcodeRnm(391, 2831); // SEMI
        op[815] = getOpcodeRnm(95, 842); // selectOptionPC
        op[816] = getOpcodeRnm(395, 2843); // CLOSE
        op[817] = getOpcodeRnm(261, 2050); // navigationProperty
        {int[] a = {819,820}; op[818] = getOpcodeCat(a);}
        op[819] = getOpcodeRnm(94, 833); // selectPath
        op[820] = getOpcodeRep((char)0, (char)1, 821);
        {int[] a = {822,830}; op[821] = getOpcodeAlt(a);}
        {int[] a = {823,824,825,829}; op[822] = getOpcodeCat(a);}
        op[823] = getOpcodeRnm(394, 2840); // OPEN
        op[824] = getOpcodeRnm(96, 849); // selectOption
        op[825] = getOpcodeRep((char)0, Character.MAX_VALUE, 826);
        {int[] a = {827,828}; op[826] = getOpcodeCat(a);}
        op[827] = getOpcodeRnm(391, 2831); // SEMI
        op[828] = getOpcodeRnm(96, 849); // selectOption
        op[829] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {831,832}; op[830] = getOpcodeCat(a);}
        {char[] a = {47}; op[831] = getOpcodeTls(a);}
        op[832] = getOpcodeRnm(93, 801); // selectProperty
        {int[] a = {834,838}; op[833] = getOpcodeCat(a);}
        {int[] a = {835,836,837}; op[834] = getOpcodeAlt(a);}
        op[835] = getOpcodeRnm(258, 2047); // complexProperty
        op[836] = getOpcodeRnm(259, 2048); // complexColProperty
        op[837] = getOpcodeRnm(109, 914); // complexAnnotationInQuery
        op[838] = getOpcodeRep((char)0, (char)1, 839);
        {int[] a = {840,841}; op[839] = getOpcodeCat(a);}
        {char[] a = {47}; op[840] = getOpcodeTls(a);}
        op[841] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        {int[] a = {843,844,845,846,847,848}; op[842] = getOpcodeAlt(a);}
        op[843] = getOpcodeRnm(72, 625); // filter
        op[844] = getOpcodeRnm(81, 700); // search
        op[845] = getOpcodeRnm(79, 685); // inlinecount
        op[846] = getOpcodeRnm(73, 631); // orderby
        op[847] = getOpcodeRnm(75, 649); // skip
        op[848] = getOpcodeRnm(76, 656); // top
        {int[] a = {850,851,852,853}; op[849] = getOpcodeAlt(a);}
        op[850] = getOpcodeRnm(95, 842); // selectOptionPC
        op[851] = getOpcodeRnm(62, 502); // compute
        op[852] = getOpcodeRnm(91, 776); // select
        op[853] = getOpcodeRnm(103, 891); // aliasAndValue
        {int[] a = {855,856,857}; op[854] = getOpcodeCat(a);}
        op[855] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[856] = getOpcodeTls(a);}
        op[857] = getOpcodeRnm(392, 2834); // STAR
        {int[] a = {859,863}; op[858] = getOpcodeCat(a);}
        op[859] = getOpcodeRep((char)0, (char)1, 860);
        {int[] a = {861,862}; op[860] = getOpcodeCat(a);}
        op[861] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[862] = getOpcodeTls(a);}
        op[863] = getOpcodeRnm(264, 2055); // action
        {int[] a = {865,869,870}; op[864] = getOpcodeCat(a);}
        op[865] = getOpcodeRep((char)0, (char)1, 866);
        {int[] a = {867,868}; op[866] = getOpcodeCat(a);}
        op[867] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[868] = getOpcodeTls(a);}
        op[869] = getOpcodeRnm(266, 2057); // function
        op[870] = getOpcodeRep((char)0, (char)1, 871);
        {int[] a = {872,873,874}; op[871] = getOpcodeCat(a);}
        op[872] = getOpcodeRnm(394, 2840); // OPEN
        op[873] = getOpcodeRnm(100, 875); // parameterNames
        op[874] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {876,877}; op[875] = getOpcodeCat(a);}
        op[876] = getOpcodeRnm(47, 409); // parameterName
        op[877] = getOpcodeRep((char)0, Character.MAX_VALUE, 878);
        {int[] a = {879,880}; op[878] = getOpcodeCat(a);}
        op[879] = getOpcodeRnm(387, 2822); // COMMA
        op[880] = getOpcodeRnm(47, 409); // parameterName
        {int[] a = {882,883,884}; op[881] = getOpcodeCat(a);}
        {char[] a = {36,100,101,108,116,97,116,111,107,101,110}; op[882] = getOpcodeTls(a);}
        op[883] = getOpcodeRnm(388, 2825); // EQ
        op[884] = getOpcodeRep((char)1, Character.MAX_VALUE, 885);
        op[885] = getOpcodeRnm(425, 3142); // qchar-no-AMP
        {int[] a = {887,888,889}; op[886] = getOpcodeCat(a);}
        {char[] a = {36,115,107,105,112,116,111,107,101,110}; op[887] = getOpcodeTls(a);}
        op[888] = getOpcodeRnm(388, 2825); // EQ
        op[889] = getOpcodeRep((char)1, Character.MAX_VALUE, 890);
        op[890] = getOpcodeRnm(425, 3142); // qchar-no-AMP
        {int[] a = {892,893,894}; op[891] = getOpcodeCat(a);}
        op[892] = getOpcodeRnm(48, 410); // parameterAlias
        op[893] = getOpcodeRnm(388, 2825); // EQ
        op[894] = getOpcodeRnm(105, 899); // parameterValue
        {int[] a = {896,897,898}; op[895] = getOpcodeCat(a);}
        op[896] = getOpcodeRnm(47, 409); // parameterName
        op[897] = getOpcodeRnm(388, 2825); // EQ
        op[898] = getOpcodeRnm(105, 899); // parameterValue
        {int[] a = {900,901}; op[899] = getOpcodeAlt(a);}
        op[900] = getOpcodeRnm(212, 1821); // arrayOrObject
        op[901] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {903,904}; op[902] = getOpcodeCat(a);}
        op[903] = getOpcodeRnm(107, 908); // customName
        op[904] = getOpcodeRep((char)0, (char)1, 905);
        {int[] a = {906,907}; op[905] = getOpcodeCat(a);}
        op[906] = getOpcodeRnm(388, 2825); // EQ
        op[907] = getOpcodeRnm(108, 912); // customValue
        {int[] a = {909,910}; op[908] = getOpcodeCat(a);}
        op[909] = getOpcodeRnm(427, 3163); // qchar-no-AMP-EQ-AT-DOLLAR
        op[910] = getOpcodeRep((char)0, Character.MAX_VALUE, 911);
        op[911] = getOpcodeRnm(426, 3153); // qchar-no-AMP-EQ
        op[912] = getOpcodeRep((char)0, Character.MAX_VALUE, 913);
        op[913] = getOpcodeRnm(425, 3142); // qchar-no-AMP
        op[914] = getOpcodeRnm(134, 1169); // annotationInQuery
        op[915] = getOpcodeRnm(134, 1169); // annotationInQuery
        op[916] = getOpcodeRnm(134, 1169); // annotationInQuery
        op[917] = getOpcodeRnm(134, 1169); // annotationInQuery
        {int[] a = {919,920}; op[918] = getOpcodeCat(a);}
        {char[] a = {35}; op[919] = getOpcodeTls(a);}
        op[920] = getOpcodeRnm(114, 921); // contextFragment
        {int[] a = {922,923,924,925,926,939,943,949,956}; op[921] = getOpcodeAlt(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40,36,114,101,102,41}; op[922] = getOpcodeTbs(a);}
        {char[] a = {36,114,101,102}; op[923] = getOpcodeTbs(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40,69,100,109,46,69,110,116,105,116,121,84,121,112,101,41}; op[924] = getOpcodeTbs(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40,69,100,109,46,67,111,109,112,108,101,120,84,121,112,101,41}; op[925] = getOpcodeTbs(a);}
        {int[] a = {927,928,937}; op[926] = getOpcodeCat(a);}
        op[927] = getOpcodeRnm(241, 1986); // singletonEntity
        op[928] = getOpcodeRep((char)0, (char)1, 929);
        {int[] a = {930,931,933}; op[929] = getOpcodeCat(a);}
        op[930] = getOpcodeRnm(117, 979); // navigation
        op[931] = getOpcodeRep((char)0, Character.MAX_VALUE, 932);
        op[932] = getOpcodeRnm(116, 972); // containmentNavigation
        op[933] = getOpcodeRep((char)0, (char)1, 934);
        {int[] a = {935,936}; op[934] = getOpcodeCat(a);}
        {char[] a = {47}; op[935] = getOpcodeTls(a);}
        op[936] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[937] = getOpcodeRep((char)0, (char)1, 938);
        op[938] = getOpcodeRnm(118, 990); // selectList
        {int[] a = {940,941}; op[939] = getOpcodeCat(a);}
        op[940] = getOpcodeRnm(228, 1919); // qualifiedTypeName
        op[941] = getOpcodeRep((char)0, (char)1, 942);
        op[942] = getOpcodeRnm(118, 990); // selectList
        {int[] a = {944,945}; op[943] = getOpcodeCat(a);}
        op[944] = getOpcodeRnm(115, 964); // entitySet
        {int[] a = {946,947,948}; op[945] = getOpcodeAlt(a);}
        {char[] a = {47,36,100,101,108,101,116,101,100,69,110,116,105,116,121}; op[946] = getOpcodeTbs(a);}
        {char[] a = {47,36,108,105,110,107}; op[947] = getOpcodeTbs(a);}
        {char[] a = {47,36,100,101,108,101,116,101,100,76,105,110,107}; op[948] = getOpcodeTbs(a);}
        {int[] a = {950,951,952,953,954}; op[949] = getOpcodeCat(a);}
        op[950] = getOpcodeRnm(115, 964); // entitySet
        op[951] = getOpcodeRnm(7, 126); // keyPredicate
        {char[] a = {47}; op[952] = getOpcodeTls(a);}
        op[953] = getOpcodeRnm(121, 1038); // contextPropertyPath
        op[954] = getOpcodeRep((char)0, (char)1, 955);
        op[955] = getOpcodeRnm(118, 990); // selectList
        {int[] a = {957,958,960}; op[956] = getOpcodeCat(a);}
        op[957] = getOpcodeRnm(115, 964); // entitySet
        op[958] = getOpcodeRep((char)0, (char)1, 959);
        op[959] = getOpcodeRnm(118, 990); // selectList
        op[960] = getOpcodeRep((char)0, (char)1, 961);
        {int[] a = {962,963}; op[961] = getOpcodeAlt(a);}
        {char[] a = {47,36,101,110,116,105,116,121}; op[962] = getOpcodeTbs(a);}
        {char[] a = {47,36,100,101,108,116,97}; op[963] = getOpcodeTbs(a);}
        {int[] a = {965,966,968}; op[964] = getOpcodeCat(a);}
        op[965] = getOpcodeRnm(240, 1985); // entitySetName
        op[966] = getOpcodeRep((char)0, Character.MAX_VALUE, 967);
        op[967] = getOpcodeRnm(116, 972); // containmentNavigation
        op[968] = getOpcodeRep((char)0, (char)1, 969);
        {int[] a = {970,971}; op[969] = getOpcodeCat(a);}
        {char[] a = {47}; op[970] = getOpcodeTls(a);}
        op[971] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        {int[] a = {973,974,978}; op[972] = getOpcodeCat(a);}
        op[973] = getOpcodeRnm(7, 126); // keyPredicate
        op[974] = getOpcodeRep((char)0, (char)1, 975);
        {int[] a = {976,977}; op[975] = getOpcodeCat(a);}
        {char[] a = {47}; op[976] = getOpcodeTls(a);}
        op[977] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[978] = getOpcodeRnm(117, 979); // navigation
        {int[] a = {980,988,989}; op[979] = getOpcodeCat(a);}
        op[980] = getOpcodeRep((char)0, Character.MAX_VALUE, 981);
        {int[] a = {982,983,984}; op[981] = getOpcodeCat(a);}
        {char[] a = {47}; op[982] = getOpcodeTls(a);}
        op[983] = getOpcodeRnm(258, 2047); // complexProperty
        op[984] = getOpcodeRep((char)0, (char)1, 985);
        {int[] a = {986,987}; op[985] = getOpcodeCat(a);}
        {char[] a = {47}; op[986] = getOpcodeTls(a);}
        op[987] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {char[] a = {47}; op[988] = getOpcodeTls(a);}
        op[989] = getOpcodeRnm(261, 2050); // navigationProperty
        {int[] a = {991,992,999}; op[990] = getOpcodeCat(a);}
        op[991] = getOpcodeRnm(394, 2840); // OPEN
        op[992] = getOpcodeRep((char)0, (char)1, 993);
        {int[] a = {994,995}; op[993] = getOpcodeCat(a);}
        op[994] = getOpcodeRnm(119, 1000); // selectListItem
        op[995] = getOpcodeRep((char)0, Character.MAX_VALUE, 996);
        {int[] a = {997,998}; op[996] = getOpcodeCat(a);}
        op[997] = getOpcodeRnm(387, 2822); // COMMA
        op[998] = getOpcodeRnm(119, 1000); // selectListItem
        op[999] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1001,1002,1003}; op[1000] = getOpcodeAlt(a);}
        op[1001] = getOpcodeRnm(392, 2834); // STAR
        op[1002] = getOpcodeRnm(97, 854); // allOperationsInSchema
        {int[] a = {1004,1010}; op[1003] = getOpcodeCat(a);}
        op[1004] = getOpcodeRep((char)0, (char)1, 1005);
        {int[] a = {1006,1009}; op[1005] = getOpcodeCat(a);}
        {int[] a = {1007,1008}; op[1006] = getOpcodeAlt(a);}
        op[1007] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[1008] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {char[] a = {47}; op[1009] = getOpcodeTls(a);}
        {int[] a = {1011,1012,1013}; op[1010] = getOpcodeAlt(a);}
        op[1011] = getOpcodeRnm(122, 1052); // qualifiedActionName
        op[1012] = getOpcodeRnm(123, 1056); // qualifiedFunctionName
        op[1013] = getOpcodeRnm(120, 1014); // selectListProperty
        {int[] a = {1015,1016,1017,1025}; op[1014] = getOpcodeAlt(a);}
        op[1015] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[1016] = getOpcodeRnm(257, 2046); // primitiveColProperty
        {int[] a = {1018,1021,1023}; op[1017] = getOpcodeCat(a);}
        {int[] a = {1019,1020}; op[1018] = getOpcodeAlt(a);}
        op[1019] = getOpcodeRnm(261, 2050); // navigationProperty
        op[1020] = getOpcodeRnm(125, 1066); // entityAnnotationInFragment
        op[1021] = getOpcodeRep((char)0, (char)1, 1022);
        {char[] a = {43}; op[1022] = getOpcodeTls(a);}
        op[1023] = getOpcodeRep((char)0, (char)1, 1024);
        op[1024] = getOpcodeRnm(118, 990); // selectList
        {int[] a = {1026,1030,1034}; op[1025] = getOpcodeCat(a);}
        {int[] a = {1027,1028,1029}; op[1026] = getOpcodeAlt(a);}
        op[1027] = getOpcodeRnm(258, 2047); // complexProperty
        op[1028] = getOpcodeRnm(259, 2048); // complexColProperty
        op[1029] = getOpcodeRnm(124, 1065); // complexAnnotationInFragment
        op[1030] = getOpcodeRep((char)0, (char)1, 1031);
        {int[] a = {1032,1033}; op[1031] = getOpcodeCat(a);}
        {char[] a = {47}; op[1032] = getOpcodeTls(a);}
        op[1033] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        op[1034] = getOpcodeRep((char)0, (char)1, 1035);
        {int[] a = {1036,1037}; op[1035] = getOpcodeCat(a);}
        {char[] a = {47}; op[1036] = getOpcodeTls(a);}
        op[1037] = getOpcodeRnm(120, 1014); // selectListProperty
        {int[] a = {1039,1040,1041,1042}; op[1038] = getOpcodeAlt(a);}
        op[1039] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[1040] = getOpcodeRnm(257, 2046); // primitiveColProperty
        op[1041] = getOpcodeRnm(259, 2048); // complexColProperty
        {int[] a = {1043,1044}; op[1042] = getOpcodeCat(a);}
        op[1043] = getOpcodeRnm(258, 2047); // complexProperty
        op[1044] = getOpcodeRep((char)0, (char)1, 1045);
        {int[] a = {1046,1050,1051}; op[1045] = getOpcodeCat(a);}
        op[1046] = getOpcodeRep((char)0, (char)1, 1047);
        {int[] a = {1048,1049}; op[1047] = getOpcodeCat(a);}
        {char[] a = {47}; op[1048] = getOpcodeTls(a);}
        op[1049] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {char[] a = {47}; op[1050] = getOpcodeTls(a);}
        op[1051] = getOpcodeRnm(121, 1038); // contextPropertyPath
        {int[] a = {1053,1054,1055}; op[1052] = getOpcodeCat(a);}
        op[1053] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1054] = getOpcodeTls(a);}
        op[1055] = getOpcodeRnm(264, 2055); // action
        {int[] a = {1057,1058,1059,1060}; op[1056] = getOpcodeCat(a);}
        op[1057] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1058] = getOpcodeTls(a);}
        op[1059] = getOpcodeRnm(266, 2057); // function
        op[1060] = getOpcodeRep((char)0, (char)1, 1061);
        {int[] a = {1062,1063,1064}; op[1061] = getOpcodeCat(a);}
        op[1062] = getOpcodeRnm(394, 2840); // OPEN
        op[1063] = getOpcodeRnm(100, 875); // parameterNames
        op[1064] = getOpcodeRnm(395, 2843); // CLOSE
        op[1065] = getOpcodeRnm(135, 1180); // annotationInFragment
        op[1066] = getOpcodeRnm(135, 1180); // annotationInFragment
        {int[] a = {1068,1080,1088,1098}; op[1067] = getOpcodeCat(a);}
        {int[] a = {1069,1070,1071,1072,1073,1074,1075,1076,1077,1078,1079}; op[1068] = getOpcodeAlt(a);}
        op[1069] = getOpcodeRnm(279, 2076); // primitiveLiteral
        op[1070] = getOpcodeRnm(212, 1821); // arrayOrObject
        op[1071] = getOpcodeRnm(128, 1103); // rootExpr
        op[1072] = getOpcodeRnm(129, 1112); // firstMemberExpr
        op[1073] = getOpcodeRnm(148, 1276); // functionExpr
        op[1074] = getOpcodeRnm(208, 1787); // negateExpr
        op[1075] = getOpcodeRnm(154, 1353); // methodCallExpr
        op[1076] = getOpcodeRnm(190, 1687); // parenExpr
        op[1077] = getOpcodeRnm(211, 1808); // castExpr
        op[1078] = getOpcodeRnm(210, 1795); // isofExpr
        op[1079] = getOpcodeRnm(209, 1791); // notExpr
        op[1080] = getOpcodeRep((char)0, (char)1, 1081);
        {int[] a = {1082,1083,1084,1085,1086,1087}; op[1081] = getOpcodeAlt(a);}
        op[1082] = getOpcodeRnm(202, 1757); // addExpr
        op[1083] = getOpcodeRnm(203, 1762); // subExpr
        op[1084] = getOpcodeRnm(204, 1767); // mulExpr
        op[1085] = getOpcodeRnm(205, 1772); // divExpr
        op[1086] = getOpcodeRnm(206, 1777); // divbyExpr
        op[1087] = getOpcodeRnm(207, 1782); // modExpr
        op[1088] = getOpcodeRep((char)0, (char)1, 1089);
        {int[] a = {1090,1091,1092,1093,1094,1095,1096,1097}; op[1089] = getOpcodeAlt(a);}
        op[1090] = getOpcodeRnm(194, 1715); // eqExpr
        op[1091] = getOpcodeRnm(195, 1720); // neExpr
        op[1092] = getOpcodeRnm(196, 1725); // ltExpr
        op[1093] = getOpcodeRnm(197, 1730); // leExpr
        op[1094] = getOpcodeRnm(198, 1735); // gtExpr
        op[1095] = getOpcodeRnm(199, 1740); // geExpr
        op[1096] = getOpcodeRnm(201, 1752); // hasExpr
        op[1097] = getOpcodeRnm(200, 1745); // inExpr
        op[1098] = getOpcodeRep((char)0, (char)1, 1099);
        {int[] a = {1100,1101}; op[1099] = getOpcodeAlt(a);}
        op[1100] = getOpcodeRnm(192, 1705); // andExpr
        op[1101] = getOpcodeRnm(193, 1710); // orExpr
        op[1102] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1104,1105,1110}; op[1103] = getOpcodeCat(a);}
        {char[] a = {36,114,111,111,116,47}; op[1104] = getOpcodeTbs(a);}
        {int[] a = {1106,1109}; op[1105] = getOpcodeAlt(a);}
        {int[] a = {1107,1108}; op[1106] = getOpcodeCat(a);}
        op[1107] = getOpcodeRnm(240, 1985); // entitySetName
        op[1108] = getOpcodeRnm(7, 126); // keyPredicate
        op[1109] = getOpcodeRnm(241, 1986); // singletonEntity
        op[1110] = getOpcodeRep((char)0, (char)1, 1111);
        op[1111] = getOpcodeRnm(141, 1215); // singleNavigationExpr
        {int[] a = {1113,1114}; op[1112] = getOpcodeAlt(a);}
        op[1113] = getOpcodeRnm(130, 1120); // memberExpr
        {int[] a = {1115,1116}; op[1114] = getOpcodeCat(a);}
        op[1115] = getOpcodeRnm(137, 1192); // inscopeVariableExpr
        op[1116] = getOpcodeRep((char)0, (char)1, 1117);
        {int[] a = {1118,1119}; op[1117] = getOpcodeCat(a);}
        {char[] a = {47}; op[1118] = getOpcodeTls(a);}
        op[1119] = getOpcodeRnm(130, 1120); // memberExpr
        {int[] a = {1121,1122}; op[1120] = getOpcodeAlt(a);}
        op[1121] = getOpcodeRnm(131, 1128); // directMemberExpr
        {int[] a = {1123,1126,1127}; op[1122] = getOpcodeCat(a);}
        {int[] a = {1124,1125}; op[1123] = getOpcodeAlt(a);}
        op[1124] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        op[1125] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        {char[] a = {47}; op[1126] = getOpcodeTls(a);}
        op[1127] = getOpcodeRnm(131, 1128); // directMemberExpr
        {int[] a = {1129,1130,1131}; op[1128] = getOpcodeAlt(a);}
        op[1129] = getOpcodeRnm(132, 1132); // propertyPathExpr
        op[1130] = getOpcodeRnm(147, 1275); // boundFunctionExpr
        op[1131] = getOpcodeRnm(133, 1161); // annotationExpr
        {int[] a = {1133,1137,1141,1145,1149,1153,1157}; op[1132] = getOpcodeAlt(a);}
        {int[] a = {1134,1135}; op[1133] = getOpcodeCat(a);}
        op[1134] = getOpcodeRnm(263, 2054); // entityColNavigationProperty
        op[1135] = getOpcodeRep((char)0, (char)1, 1136);
        op[1136] = getOpcodeRnm(140, 1200); // collectionNavigationExpr
        {int[] a = {1138,1139}; op[1137] = getOpcodeCat(a);}
        op[1138] = getOpcodeRnm(262, 2053); // entityNavigationProperty
        op[1139] = getOpcodeRep((char)0, (char)1, 1140);
        op[1140] = getOpcodeRnm(141, 1215); // singleNavigationExpr
        {int[] a = {1142,1143}; op[1141] = getOpcodeCat(a);}
        op[1142] = getOpcodeRnm(259, 2048); // complexColProperty
        op[1143] = getOpcodeRep((char)0, (char)1, 1144);
        op[1144] = getOpcodeRnm(143, 1223); // complexColPathExpr
        {int[] a = {1146,1147}; op[1145] = getOpcodeCat(a);}
        op[1146] = getOpcodeRnm(258, 2047); // complexProperty
        op[1147] = getOpcodeRep((char)0, (char)1, 1148);
        op[1148] = getOpcodeRnm(145, 1258); // complexPathExpr
        {int[] a = {1150,1151}; op[1149] = getOpcodeCat(a);}
        op[1150] = getOpcodeRnm(257, 2046); // primitiveColProperty
        op[1151] = getOpcodeRep((char)0, (char)1, 1152);
        op[1152] = getOpcodeRnm(144, 1230); // collectionPathExpr
        {int[] a = {1154,1155}; op[1153] = getOpcodeCat(a);}
        op[1154] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[1155] = getOpcodeRep((char)0, (char)1, 1156);
        op[1156] = getOpcodeRnm(146, 1269); // primitivePathExpr
        {int[] a = {1158,1159}; op[1157] = getOpcodeCat(a);}
        op[1158] = getOpcodeRnm(260, 2049); // streamProperty
        op[1159] = getOpcodeRep((char)0, (char)1, 1160);
        op[1160] = getOpcodeRnm(146, 1269); // primitivePathExpr
        {int[] a = {1162,1163}; op[1161] = getOpcodeCat(a);}
        op[1162] = getOpcodeRnm(134, 1169); // annotationInQuery
        op[1163] = getOpcodeRep((char)0, (char)1, 1164);
        {int[] a = {1165,1166,1167,1168}; op[1164] = getOpcodeAlt(a);}
        op[1165] = getOpcodeRnm(144, 1230); // collectionPathExpr
        op[1166] = getOpcodeRnm(141, 1215); // singleNavigationExpr
        op[1167] = getOpcodeRnm(145, 1258); // complexPathExpr
        op[1168] = getOpcodeRnm(146, 1269); // primitivePathExpr
        {int[] a = {1170,1171,1175,1176}; op[1169] = getOpcodeCat(a);}
        op[1170] = getOpcodeRnm(385, 2816); // AT
        op[1171] = getOpcodeRep((char)0, (char)1, 1172);
        {int[] a = {1173,1174}; op[1172] = getOpcodeCat(a);}
        op[1173] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1174] = getOpcodeTls(a);}
        op[1175] = getOpcodeRnm(247, 1992); // termName
        op[1176] = getOpcodeRep((char)0, (char)1, 1177);
        {int[] a = {1178,1179}; op[1177] = getOpcodeCat(a);}
        op[1178] = getOpcodeRnm(389, 2826); // HASH
        op[1179] = getOpcodeRnm(136, 1191); // annotationQualifier
        {int[] a = {1181,1182,1186,1187}; op[1180] = getOpcodeCat(a);}
        op[1181] = getOpcodeRnm(385, 2816); // AT
        op[1182] = getOpcodeRep((char)0, (char)1, 1183);
        {int[] a = {1184,1185}; op[1183] = getOpcodeCat(a);}
        op[1184] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1185] = getOpcodeTls(a);}
        op[1186] = getOpcodeRnm(247, 1992); // termName
        op[1187] = getOpcodeRep((char)0, (char)1, 1188);
        {int[] a = {1189,1190}; op[1188] = getOpcodeCat(a);}
        {char[] a = {35}; op[1189] = getOpcodeTls(a);}
        op[1190] = getOpcodeRnm(136, 1191); // annotationQualifier
        op[1191] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {1193,1194,1195}; op[1192] = getOpcodeAlt(a);}
        op[1193] = getOpcodeRnm(138, 1196); // implicitVariableExpr
        op[1194] = getOpcodeRnm(48, 410); // parameterAlias
        op[1195] = getOpcodeRnm(139, 1199); // lambdaVariableExpr
        {int[] a = {1197,1198}; op[1196] = getOpcodeAlt(a);}
        {char[] a = {36,105,116}; op[1197] = getOpcodeTbs(a);}
        {char[] a = {36,116,104,105,115}; op[1198] = getOpcodeTbs(a);}
        op[1199] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {1201,1205}; op[1200] = getOpcodeCat(a);}
        op[1201] = getOpcodeRep((char)0, (char)1, 1202);
        {int[] a = {1203,1204}; op[1202] = getOpcodeCat(a);}
        {char[] a = {47}; op[1203] = getOpcodeTls(a);}
        op[1204] = getOpcodeRnm(236, 1966); // optionallyQualifiedEntityTypeName
        {int[] a = {1206,1207,1211}; op[1205] = getOpcodeAlt(a);}
        op[1206] = getOpcodeRnm(144, 1230); // collectionPathExpr
        {int[] a = {1208,1209}; op[1207] = getOpcodeCat(a);}
        op[1208] = getOpcodeRnm(7, 126); // keyPredicate
        op[1209] = getOpcodeRep((char)0, (char)1, 1210);
        op[1210] = getOpcodeRnm(141, 1215); // singleNavigationExpr
        {int[] a = {1212,1213}; op[1211] = getOpcodeCat(a);}
        op[1212] = getOpcodeRnm(142, 1218); // filterExpr
        op[1213] = getOpcodeRep((char)0, (char)1, 1214);
        op[1214] = getOpcodeRnm(140, 1200); // collectionNavigationExpr
        {int[] a = {1216,1217}; op[1215] = getOpcodeCat(a);}
        {char[] a = {47}; op[1216] = getOpcodeTls(a);}
        op[1217] = getOpcodeRnm(130, 1120); // memberExpr
        {int[] a = {1219,1220,1221,1222}; op[1218] = getOpcodeCat(a);}
        {char[] a = {47,36,102,105,108,116,101,114}; op[1219] = getOpcodeTbs(a);}
        op[1220] = getOpcodeRnm(394, 2840); // OPEN
        op[1221] = getOpcodeRnm(127, 1102); // boolCommonExpr
        op[1222] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1224,1225}; op[1223] = getOpcodeAlt(a);}
        op[1224] = getOpcodeRnm(144, 1230); // collectionPathExpr
        {int[] a = {1226,1227,1228}; op[1225] = getOpcodeCat(a);}
        {char[] a = {47}; op[1226] = getOpcodeTls(a);}
        op[1227] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        op[1228] = getOpcodeRep((char)0, (char)1, 1229);
        op[1229] = getOpcodeRnm(144, 1230); // collectionPathExpr
        {int[] a = {1231,1242,1246,1249,1252,1255}; op[1230] = getOpcodeAlt(a);}
        {int[] a = {1232,1233}; op[1231] = getOpcodeCat(a);}
        op[1232] = getOpcodeRnm(23, 242); // count
        op[1233] = getOpcodeRep((char)0, (char)1, 1234);
        {int[] a = {1235,1236,1237,1241}; op[1234] = getOpcodeCat(a);}
        op[1235] = getOpcodeRnm(394, 2840); // OPEN
        op[1236] = getOpcodeRnm(68, 596); // expandCountOption
        op[1237] = getOpcodeRep((char)0, Character.MAX_VALUE, 1238);
        {int[] a = {1239,1240}; op[1238] = getOpcodeCat(a);}
        op[1239] = getOpcodeRnm(391, 2831); // SEMI
        op[1240] = getOpcodeRnm(68, 596); // expandCountOption
        op[1241] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1243,1244}; op[1242] = getOpcodeCat(a);}
        op[1243] = getOpcodeRnm(142, 1218); // filterExpr
        op[1244] = getOpcodeRep((char)0, (char)1, 1245);
        op[1245] = getOpcodeRnm(144, 1230); // collectionPathExpr
        {int[] a = {1247,1248}; op[1246] = getOpcodeCat(a);}
        {char[] a = {47}; op[1247] = getOpcodeTls(a);}
        op[1248] = getOpcodeRnm(151, 1328); // anyExpr
        {int[] a = {1250,1251}; op[1249] = getOpcodeCat(a);}
        {char[] a = {47}; op[1250] = getOpcodeTls(a);}
        op[1251] = getOpcodeRnm(152, 1341); // allExpr
        {int[] a = {1253,1254}; op[1252] = getOpcodeCat(a);}
        {char[] a = {47}; op[1253] = getOpcodeTls(a);}
        op[1254] = getOpcodeRnm(147, 1275); // boundFunctionExpr
        {int[] a = {1256,1257}; op[1255] = getOpcodeCat(a);}
        {char[] a = {47}; op[1256] = getOpcodeTls(a);}
        op[1257] = getOpcodeRnm(133, 1161); // annotationExpr
        {int[] a = {1259,1262}; op[1258] = getOpcodeAlt(a);}
        {int[] a = {1260,1261}; op[1259] = getOpcodeCat(a);}
        {char[] a = {47}; op[1260] = getOpcodeTls(a);}
        op[1261] = getOpcodeRnm(131, 1128); // directMemberExpr
        {int[] a = {1263,1264,1265}; op[1262] = getOpcodeCat(a);}
        {char[] a = {47}; op[1263] = getOpcodeTls(a);}
        op[1264] = getOpcodeRnm(237, 1972); // optionallyQualifiedComplexTypeName
        op[1265] = getOpcodeRep((char)0, (char)1, 1266);
        {int[] a = {1267,1268}; op[1266] = getOpcodeCat(a);}
        {char[] a = {47}; op[1267] = getOpcodeTls(a);}
        op[1268] = getOpcodeRnm(131, 1128); // directMemberExpr
        {int[] a = {1270,1271}; op[1269] = getOpcodeCat(a);}
        {char[] a = {47}; op[1270] = getOpcodeTls(a);}
        op[1271] = getOpcodeRep((char)0, (char)1, 1272);
        {int[] a = {1273,1274}; op[1272] = getOpcodeAlt(a);}
        op[1273] = getOpcodeRnm(133, 1161); // annotationExpr
        op[1274] = getOpcodeRnm(147, 1275); // boundFunctionExpr
        op[1275] = getOpcodeRnm(148, 1276); // functionExpr
        {int[] a = {1277,1281}; op[1276] = getOpcodeCat(a);}
        op[1277] = getOpcodeRep((char)0, (char)1, 1278);
        {int[] a = {1279,1280}; op[1278] = getOpcodeCat(a);}
        op[1279] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1280] = getOpcodeTls(a);}
        {int[] a = {1282,1287,1292,1297,1302,1307}; op[1281] = getOpcodeAlt(a);}
        {int[] a = {1283,1284,1285}; op[1282] = getOpcodeCat(a);}
        op[1283] = getOpcodeRnm(268, 2065); // entityColFunction
        op[1284] = getOpcodeRnm(149, 1312); // functionExprParameters
        op[1285] = getOpcodeRep((char)0, (char)1, 1286);
        op[1286] = getOpcodeRnm(140, 1200); // collectionNavigationExpr
        {int[] a = {1288,1289,1290}; op[1287] = getOpcodeCat(a);}
        op[1288] = getOpcodeRnm(267, 2064); // entityFunction
        op[1289] = getOpcodeRnm(149, 1312); // functionExprParameters
        op[1290] = getOpcodeRep((char)0, (char)1, 1291);
        op[1291] = getOpcodeRnm(141, 1215); // singleNavigationExpr
        {int[] a = {1293,1294,1295}; op[1292] = getOpcodeCat(a);}
        op[1293] = getOpcodeRnm(270, 2067); // complexColFunction
        op[1294] = getOpcodeRnm(149, 1312); // functionExprParameters
        op[1295] = getOpcodeRep((char)0, (char)1, 1296);
        op[1296] = getOpcodeRnm(143, 1223); // complexColPathExpr
        {int[] a = {1298,1299,1300}; op[1297] = getOpcodeCat(a);}
        op[1298] = getOpcodeRnm(269, 2066); // complexFunction
        op[1299] = getOpcodeRnm(149, 1312); // functionExprParameters
        op[1300] = getOpcodeRep((char)0, (char)1, 1301);
        op[1301] = getOpcodeRnm(145, 1258); // complexPathExpr
        {int[] a = {1303,1304,1305}; op[1302] = getOpcodeCat(a);}
        op[1303] = getOpcodeRnm(272, 2069); // primitiveColFunction
        op[1304] = getOpcodeRnm(149, 1312); // functionExprParameters
        op[1305] = getOpcodeRep((char)0, (char)1, 1306);
        op[1306] = getOpcodeRnm(144, 1230); // collectionPathExpr
        {int[] a = {1308,1309,1310}; op[1307] = getOpcodeCat(a);}
        op[1308] = getOpcodeRnm(271, 2068); // primitiveFunction
        op[1309] = getOpcodeRnm(149, 1312); // functionExprParameters
        op[1310] = getOpcodeRep((char)0, (char)1, 1311);
        op[1311] = getOpcodeRnm(146, 1269); // primitivePathExpr
        {int[] a = {1313,1314,1321}; op[1312] = getOpcodeCat(a);}
        op[1313] = getOpcodeRnm(394, 2840); // OPEN
        op[1314] = getOpcodeRep((char)0, (char)1, 1315);
        {int[] a = {1316,1317}; op[1315] = getOpcodeCat(a);}
        op[1316] = getOpcodeRnm(150, 1322); // functionExprParameter
        op[1317] = getOpcodeRep((char)0, Character.MAX_VALUE, 1318);
        {int[] a = {1319,1320}; op[1318] = getOpcodeCat(a);}
        op[1319] = getOpcodeRnm(387, 2822); // COMMA
        op[1320] = getOpcodeRnm(150, 1322); // functionExprParameter
        op[1321] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1323,1324,1325}; op[1322] = getOpcodeCat(a);}
        op[1323] = getOpcodeRnm(47, 409); // parameterName
        op[1324] = getOpcodeRnm(388, 2825); // EQ
        {int[] a = {1326,1327}; op[1325] = getOpcodeAlt(a);}
        op[1326] = getOpcodeRnm(48, 410); // parameterAlias
        op[1327] = getOpcodeRnm(105, 899); // parameterValue
        {int[] a = {1329,1330,1331,1332,1339,1340}; op[1328] = getOpcodeCat(a);}
        {char[] a = {97,110,121}; op[1329] = getOpcodeTls(a);}
        op[1330] = getOpcodeRnm(394, 2840); // OPEN
        op[1331] = getOpcodeRnm(384, 2810); // BWS
        op[1332] = getOpcodeRep((char)0, (char)1, 1333);
        {int[] a = {1334,1335,1336,1337,1338}; op[1333] = getOpcodeCat(a);}
        op[1334] = getOpcodeRnm(139, 1199); // lambdaVariableExpr
        op[1335] = getOpcodeRnm(384, 2810); // BWS
        op[1336] = getOpcodeRnm(386, 2819); // COLON
        op[1337] = getOpcodeRnm(384, 2810); // BWS
        op[1338] = getOpcodeRnm(153, 1352); // lambdaPredicateExpr
        op[1339] = getOpcodeRnm(384, 2810); // BWS
        op[1340] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1342,1343,1344,1345,1346,1347,1348,1349,1350,1351}; op[1341] = getOpcodeCat(a);}
        {char[] a = {97,108,108}; op[1342] = getOpcodeTls(a);}
        op[1343] = getOpcodeRnm(394, 2840); // OPEN
        op[1344] = getOpcodeRnm(384, 2810); // BWS
        op[1345] = getOpcodeRnm(139, 1199); // lambdaVariableExpr
        op[1346] = getOpcodeRnm(384, 2810); // BWS
        op[1347] = getOpcodeRnm(386, 2819); // COLON
        op[1348] = getOpcodeRnm(384, 2810); // BWS
        op[1349] = getOpcodeRnm(153, 1352); // lambdaPredicateExpr
        op[1350] = getOpcodeRnm(384, 2810); // BWS
        op[1351] = getOpcodeRnm(395, 2843); // CLOSE
        op[1352] = getOpcodeRnm(127, 1102); // boolCommonExpr
        {int[] a = {1354,1355,1356,1357,1358,1359,1360,1361,1362,1363,1364,1365,1366,1367,1368,1369,1370,1371,1372,1373,1374,1375,1376,1377,1378,1379,1380,1381,1382}; op[1353] = getOpcodeAlt(a);}
        op[1354] = getOpcodeRnm(159, 1424); // indexOfMethodCallExpr
        op[1355] = getOpcodeRnm(164, 1481); // toLowerMethodCallExpr
        op[1356] = getOpcodeRnm(165, 1488); // toUpperMethodCallExpr
        op[1357] = getOpcodeRnm(166, 1495); // trimMethodCallExpr
        op[1358] = getOpcodeRnm(163, 1464); // substringMethodCallExpr
        op[1359] = getOpcodeRnm(156, 1391); // concatMethodCallExpr
        op[1360] = getOpcodeRnm(160, 1435); // lengthMethodCallExpr
        op[1361] = getOpcodeRnm(161, 1442); // matchesPatternMethodCallExpr
        op[1362] = getOpcodeRnm(167, 1502); // yearMethodCallExpr
        op[1363] = getOpcodeRnm(168, 1509); // monthMethodCallExpr
        op[1364] = getOpcodeRnm(169, 1516); // dayMethodCallExpr
        op[1365] = getOpcodeRnm(170, 1523); // hourMethodCallExpr
        op[1366] = getOpcodeRnm(171, 1530); // minuteMethodCallExpr
        op[1367] = getOpcodeRnm(172, 1537); // secondMethodCallExpr
        op[1368] = getOpcodeRnm(173, 1544); // fractionalsecondsMethodCallExpr
        op[1369] = getOpcodeRnm(174, 1551); // totalsecondsMethodCallExpr
        op[1370] = getOpcodeRnm(175, 1558); // dateMethodCallExpr
        op[1371] = getOpcodeRnm(176, 1565); // timeMethodCallExpr
        op[1372] = getOpcodeRnm(181, 1594); // roundMethodCallExpr
        op[1373] = getOpcodeRnm(182, 1601); // floorMethodCallExpr
        op[1374] = getOpcodeRnm(183, 1608); // ceilingMethodCallExpr
        op[1375] = getOpcodeRnm(184, 1615); // distanceMethodCallExpr
        op[1376] = getOpcodeRnm(185, 1626); // geoLengthMethodCallExpr
        op[1377] = getOpcodeRnm(177, 1572); // totalOffsetMinutesMethodCallExpr
        op[1378] = getOpcodeRnm(178, 1579); // minDateTimeMethodCallExpr
        op[1379] = getOpcodeRnm(179, 1584); // maxDateTimeMethodCallExpr
        op[1380] = getOpcodeRnm(180, 1589); // nowMethodCallExpr
        op[1381] = getOpcodeRnm(189, 1666); // caseMethodCallExpr
        op[1382] = getOpcodeRnm(155, 1383); // boolMethodCallExpr
        {int[] a = {1384,1385,1386,1387,1388,1389,1390}; op[1383] = getOpcodeAlt(a);}
        op[1384] = getOpcodeRnm(158, 1413); // endsWithMethodCallExpr
        op[1385] = getOpcodeRnm(162, 1453); // startsWithMethodCallExpr
        op[1386] = getOpcodeRnm(157, 1402); // containsMethodCallExpr
        op[1387] = getOpcodeRnm(186, 1633); // intersectsMethodCallExpr
        op[1388] = getOpcodeRnm(187, 1644); // hasSubsetMethodCallExpr
        op[1389] = getOpcodeRnm(188, 1655); // hasSubsequenceMethodCallExpr
        op[1390] = getOpcodeRnm(478, 3651); // isdefinedExpr
        {int[] a = {1392,1393,1394,1395,1396,1397,1398,1399,1400,1401}; op[1391] = getOpcodeCat(a);}
        {char[] a = {99,111,110,99,97,116}; op[1392] = getOpcodeTls(a);}
        op[1393] = getOpcodeRnm(394, 2840); // OPEN
        op[1394] = getOpcodeRnm(384, 2810); // BWS
        op[1395] = getOpcodeRnm(126, 1067); // commonExpr
        op[1396] = getOpcodeRnm(384, 2810); // BWS
        op[1397] = getOpcodeRnm(387, 2822); // COMMA
        op[1398] = getOpcodeRnm(384, 2810); // BWS
        op[1399] = getOpcodeRnm(126, 1067); // commonExpr
        op[1400] = getOpcodeRnm(384, 2810); // BWS
        op[1401] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1403,1404,1405,1406,1407,1408,1409,1410,1411,1412}; op[1402] = getOpcodeCat(a);}
        {char[] a = {99,111,110,116,97,105,110,115}; op[1403] = getOpcodeTls(a);}
        op[1404] = getOpcodeRnm(394, 2840); // OPEN
        op[1405] = getOpcodeRnm(384, 2810); // BWS
        op[1406] = getOpcodeRnm(126, 1067); // commonExpr
        op[1407] = getOpcodeRnm(384, 2810); // BWS
        op[1408] = getOpcodeRnm(387, 2822); // COMMA
        op[1409] = getOpcodeRnm(384, 2810); // BWS
        op[1410] = getOpcodeRnm(126, 1067); // commonExpr
        op[1411] = getOpcodeRnm(384, 2810); // BWS
        op[1412] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1414,1415,1416,1417,1418,1419,1420,1421,1422,1423}; op[1413] = getOpcodeCat(a);}
        {char[] a = {101,110,100,115,119,105,116,104}; op[1414] = getOpcodeTls(a);}
        op[1415] = getOpcodeRnm(394, 2840); // OPEN
        op[1416] = getOpcodeRnm(384, 2810); // BWS
        op[1417] = getOpcodeRnm(126, 1067); // commonExpr
        op[1418] = getOpcodeRnm(384, 2810); // BWS
        op[1419] = getOpcodeRnm(387, 2822); // COMMA
        op[1420] = getOpcodeRnm(384, 2810); // BWS
        op[1421] = getOpcodeRnm(126, 1067); // commonExpr
        op[1422] = getOpcodeRnm(384, 2810); // BWS
        op[1423] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1425,1426,1427,1428,1429,1430,1431,1432,1433,1434}; op[1424] = getOpcodeCat(a);}
        {char[] a = {105,110,100,101,120,111,102}; op[1425] = getOpcodeTls(a);}
        op[1426] = getOpcodeRnm(394, 2840); // OPEN
        op[1427] = getOpcodeRnm(384, 2810); // BWS
        op[1428] = getOpcodeRnm(126, 1067); // commonExpr
        op[1429] = getOpcodeRnm(384, 2810); // BWS
        op[1430] = getOpcodeRnm(387, 2822); // COMMA
        op[1431] = getOpcodeRnm(384, 2810); // BWS
        op[1432] = getOpcodeRnm(126, 1067); // commonExpr
        op[1433] = getOpcodeRnm(384, 2810); // BWS
        op[1434] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1436,1437,1438,1439,1440,1441}; op[1435] = getOpcodeCat(a);}
        {char[] a = {108,101,110,103,116,104}; op[1436] = getOpcodeTls(a);}
        op[1437] = getOpcodeRnm(394, 2840); // OPEN
        op[1438] = getOpcodeRnm(384, 2810); // BWS
        op[1439] = getOpcodeRnm(126, 1067); // commonExpr
        op[1440] = getOpcodeRnm(384, 2810); // BWS
        op[1441] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1443,1444,1445,1446,1447,1448,1449,1450,1451,1452}; op[1442] = getOpcodeCat(a);}
        {char[] a = {109,97,116,99,104,101,115,80,97,116,116,101,114,110}; op[1443] = getOpcodeTls(a);}
        op[1444] = getOpcodeRnm(394, 2840); // OPEN
        op[1445] = getOpcodeRnm(384, 2810); // BWS
        op[1446] = getOpcodeRnm(126, 1067); // commonExpr
        op[1447] = getOpcodeRnm(384, 2810); // BWS
        op[1448] = getOpcodeRnm(387, 2822); // COMMA
        op[1449] = getOpcodeRnm(384, 2810); // BWS
        op[1450] = getOpcodeRnm(126, 1067); // commonExpr
        op[1451] = getOpcodeRnm(384, 2810); // BWS
        op[1452] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1454,1455,1456,1457,1458,1459,1460,1461,1462,1463}; op[1453] = getOpcodeCat(a);}
        {char[] a = {115,116,97,114,116,115,119,105,116,104}; op[1454] = getOpcodeTls(a);}
        op[1455] = getOpcodeRnm(394, 2840); // OPEN
        op[1456] = getOpcodeRnm(384, 2810); // BWS
        op[1457] = getOpcodeRnm(126, 1067); // commonExpr
        op[1458] = getOpcodeRnm(384, 2810); // BWS
        op[1459] = getOpcodeRnm(387, 2822); // COMMA
        op[1460] = getOpcodeRnm(384, 2810); // BWS
        op[1461] = getOpcodeRnm(126, 1067); // commonExpr
        op[1462] = getOpcodeRnm(384, 2810); // BWS
        op[1463] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1465,1466,1467,1468,1469,1470,1471,1472,1473,1474,1480}; op[1464] = getOpcodeCat(a);}
        {char[] a = {115,117,98,115,116,114,105,110,103}; op[1465] = getOpcodeTls(a);}
        op[1466] = getOpcodeRnm(394, 2840); // OPEN
        op[1467] = getOpcodeRnm(384, 2810); // BWS
        op[1468] = getOpcodeRnm(126, 1067); // commonExpr
        op[1469] = getOpcodeRnm(384, 2810); // BWS
        op[1470] = getOpcodeRnm(387, 2822); // COMMA
        op[1471] = getOpcodeRnm(384, 2810); // BWS
        op[1472] = getOpcodeRnm(126, 1067); // commonExpr
        op[1473] = getOpcodeRnm(384, 2810); // BWS
        op[1474] = getOpcodeRep((char)0, (char)1, 1475);
        {int[] a = {1476,1477,1478,1479}; op[1475] = getOpcodeCat(a);}
        op[1476] = getOpcodeRnm(387, 2822); // COMMA
        op[1477] = getOpcodeRnm(384, 2810); // BWS
        op[1478] = getOpcodeRnm(126, 1067); // commonExpr
        op[1479] = getOpcodeRnm(384, 2810); // BWS
        op[1480] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1482,1483,1484,1485,1486,1487}; op[1481] = getOpcodeCat(a);}
        {char[] a = {116,111,108,111,119,101,114}; op[1482] = getOpcodeTls(a);}
        op[1483] = getOpcodeRnm(394, 2840); // OPEN
        op[1484] = getOpcodeRnm(384, 2810); // BWS
        op[1485] = getOpcodeRnm(126, 1067); // commonExpr
        op[1486] = getOpcodeRnm(384, 2810); // BWS
        op[1487] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1489,1490,1491,1492,1493,1494}; op[1488] = getOpcodeCat(a);}
        {char[] a = {116,111,117,112,112,101,114}; op[1489] = getOpcodeTls(a);}
        op[1490] = getOpcodeRnm(394, 2840); // OPEN
        op[1491] = getOpcodeRnm(384, 2810); // BWS
        op[1492] = getOpcodeRnm(126, 1067); // commonExpr
        op[1493] = getOpcodeRnm(384, 2810); // BWS
        op[1494] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1496,1497,1498,1499,1500,1501}; op[1495] = getOpcodeCat(a);}
        {char[] a = {116,114,105,109}; op[1496] = getOpcodeTls(a);}
        op[1497] = getOpcodeRnm(394, 2840); // OPEN
        op[1498] = getOpcodeRnm(384, 2810); // BWS
        op[1499] = getOpcodeRnm(126, 1067); // commonExpr
        op[1500] = getOpcodeRnm(384, 2810); // BWS
        op[1501] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1503,1504,1505,1506,1507,1508}; op[1502] = getOpcodeCat(a);}
        {char[] a = {121,101,97,114}; op[1503] = getOpcodeTls(a);}
        op[1504] = getOpcodeRnm(394, 2840); // OPEN
        op[1505] = getOpcodeRnm(384, 2810); // BWS
        op[1506] = getOpcodeRnm(126, 1067); // commonExpr
        op[1507] = getOpcodeRnm(384, 2810); // BWS
        op[1508] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1510,1511,1512,1513,1514,1515}; op[1509] = getOpcodeCat(a);}
        {char[] a = {109,111,110,116,104}; op[1510] = getOpcodeTls(a);}
        op[1511] = getOpcodeRnm(394, 2840); // OPEN
        op[1512] = getOpcodeRnm(384, 2810); // BWS
        op[1513] = getOpcodeRnm(126, 1067); // commonExpr
        op[1514] = getOpcodeRnm(384, 2810); // BWS
        op[1515] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1517,1518,1519,1520,1521,1522}; op[1516] = getOpcodeCat(a);}
        {char[] a = {100,97,121}; op[1517] = getOpcodeTls(a);}
        op[1518] = getOpcodeRnm(394, 2840); // OPEN
        op[1519] = getOpcodeRnm(384, 2810); // BWS
        op[1520] = getOpcodeRnm(126, 1067); // commonExpr
        op[1521] = getOpcodeRnm(384, 2810); // BWS
        op[1522] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1524,1525,1526,1527,1528,1529}; op[1523] = getOpcodeCat(a);}
        {char[] a = {104,111,117,114}; op[1524] = getOpcodeTls(a);}
        op[1525] = getOpcodeRnm(394, 2840); // OPEN
        op[1526] = getOpcodeRnm(384, 2810); // BWS
        op[1527] = getOpcodeRnm(126, 1067); // commonExpr
        op[1528] = getOpcodeRnm(384, 2810); // BWS
        op[1529] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1531,1532,1533,1534,1535,1536}; op[1530] = getOpcodeCat(a);}
        {char[] a = {109,105,110,117,116,101}; op[1531] = getOpcodeTls(a);}
        op[1532] = getOpcodeRnm(394, 2840); // OPEN
        op[1533] = getOpcodeRnm(384, 2810); // BWS
        op[1534] = getOpcodeRnm(126, 1067); // commonExpr
        op[1535] = getOpcodeRnm(384, 2810); // BWS
        op[1536] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1538,1539,1540,1541,1542,1543}; op[1537] = getOpcodeCat(a);}
        {char[] a = {115,101,99,111,110,100}; op[1538] = getOpcodeTls(a);}
        op[1539] = getOpcodeRnm(394, 2840); // OPEN
        op[1540] = getOpcodeRnm(384, 2810); // BWS
        op[1541] = getOpcodeRnm(126, 1067); // commonExpr
        op[1542] = getOpcodeRnm(384, 2810); // BWS
        op[1543] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1545,1546,1547,1548,1549,1550}; op[1544] = getOpcodeCat(a);}
        {char[] a = {102,114,97,99,116,105,111,110,97,108,115,101,99,111,110,100,115}; op[1545] = getOpcodeTls(a);}
        op[1546] = getOpcodeRnm(394, 2840); // OPEN
        op[1547] = getOpcodeRnm(384, 2810); // BWS
        op[1548] = getOpcodeRnm(126, 1067); // commonExpr
        op[1549] = getOpcodeRnm(384, 2810); // BWS
        op[1550] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1552,1553,1554,1555,1556,1557}; op[1551] = getOpcodeCat(a);}
        {char[] a = {116,111,116,97,108,115,101,99,111,110,100,115}; op[1552] = getOpcodeTls(a);}
        op[1553] = getOpcodeRnm(394, 2840); // OPEN
        op[1554] = getOpcodeRnm(384, 2810); // BWS
        op[1555] = getOpcodeRnm(126, 1067); // commonExpr
        op[1556] = getOpcodeRnm(384, 2810); // BWS
        op[1557] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1559,1560,1561,1562,1563,1564}; op[1558] = getOpcodeCat(a);}
        {char[] a = {100,97,116,101}; op[1559] = getOpcodeTls(a);}
        op[1560] = getOpcodeRnm(394, 2840); // OPEN
        op[1561] = getOpcodeRnm(384, 2810); // BWS
        op[1562] = getOpcodeRnm(126, 1067); // commonExpr
        op[1563] = getOpcodeRnm(384, 2810); // BWS
        op[1564] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1566,1567,1568,1569,1570,1571}; op[1565] = getOpcodeCat(a);}
        {char[] a = {116,105,109,101}; op[1566] = getOpcodeTls(a);}
        op[1567] = getOpcodeRnm(394, 2840); // OPEN
        op[1568] = getOpcodeRnm(384, 2810); // BWS
        op[1569] = getOpcodeRnm(126, 1067); // commonExpr
        op[1570] = getOpcodeRnm(384, 2810); // BWS
        op[1571] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1573,1574,1575,1576,1577,1578}; op[1572] = getOpcodeCat(a);}
        {char[] a = {116,111,116,97,108,111,102,102,115,101,116,109,105,110,117,116,101,115}; op[1573] = getOpcodeTls(a);}
        op[1574] = getOpcodeRnm(394, 2840); // OPEN
        op[1575] = getOpcodeRnm(384, 2810); // BWS
        op[1576] = getOpcodeRnm(126, 1067); // commonExpr
        op[1577] = getOpcodeRnm(384, 2810); // BWS
        op[1578] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1580,1581,1582,1583}; op[1579] = getOpcodeCat(a);}
        {char[] a = {109,105,110,100,97,116,101,116,105,109,101}; op[1580] = getOpcodeTls(a);}
        op[1581] = getOpcodeRnm(394, 2840); // OPEN
        op[1582] = getOpcodeRnm(384, 2810); // BWS
        op[1583] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1585,1586,1587,1588}; op[1584] = getOpcodeCat(a);}
        {char[] a = {109,97,120,100,97,116,101,116,105,109,101}; op[1585] = getOpcodeTls(a);}
        op[1586] = getOpcodeRnm(394, 2840); // OPEN
        op[1587] = getOpcodeRnm(384, 2810); // BWS
        op[1588] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1590,1591,1592,1593}; op[1589] = getOpcodeCat(a);}
        {char[] a = {110,111,119}; op[1590] = getOpcodeTls(a);}
        op[1591] = getOpcodeRnm(394, 2840); // OPEN
        op[1592] = getOpcodeRnm(384, 2810); // BWS
        op[1593] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1595,1596,1597,1598,1599,1600}; op[1594] = getOpcodeCat(a);}
        {char[] a = {114,111,117,110,100}; op[1595] = getOpcodeTls(a);}
        op[1596] = getOpcodeRnm(394, 2840); // OPEN
        op[1597] = getOpcodeRnm(384, 2810); // BWS
        op[1598] = getOpcodeRnm(126, 1067); // commonExpr
        op[1599] = getOpcodeRnm(384, 2810); // BWS
        op[1600] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1602,1603,1604,1605,1606,1607}; op[1601] = getOpcodeCat(a);}
        {char[] a = {102,108,111,111,114}; op[1602] = getOpcodeTls(a);}
        op[1603] = getOpcodeRnm(394, 2840); // OPEN
        op[1604] = getOpcodeRnm(384, 2810); // BWS
        op[1605] = getOpcodeRnm(126, 1067); // commonExpr
        op[1606] = getOpcodeRnm(384, 2810); // BWS
        op[1607] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1609,1610,1611,1612,1613,1614}; op[1608] = getOpcodeCat(a);}
        {char[] a = {99,101,105,108,105,110,103}; op[1609] = getOpcodeTls(a);}
        op[1610] = getOpcodeRnm(394, 2840); // OPEN
        op[1611] = getOpcodeRnm(384, 2810); // BWS
        op[1612] = getOpcodeRnm(126, 1067); // commonExpr
        op[1613] = getOpcodeRnm(384, 2810); // BWS
        op[1614] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1616,1617,1618,1619,1620,1621,1622,1623,1624,1625}; op[1615] = getOpcodeCat(a);}
        {char[] a = {103,101,111,46,100,105,115,116,97,110,99,101}; op[1616] = getOpcodeTls(a);}
        op[1617] = getOpcodeRnm(394, 2840); // OPEN
        op[1618] = getOpcodeRnm(384, 2810); // BWS
        op[1619] = getOpcodeRnm(126, 1067); // commonExpr
        op[1620] = getOpcodeRnm(384, 2810); // BWS
        op[1621] = getOpcodeRnm(387, 2822); // COMMA
        op[1622] = getOpcodeRnm(384, 2810); // BWS
        op[1623] = getOpcodeRnm(126, 1067); // commonExpr
        op[1624] = getOpcodeRnm(384, 2810); // BWS
        op[1625] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1627,1628,1629,1630,1631,1632}; op[1626] = getOpcodeCat(a);}
        {char[] a = {103,101,111,46,108,101,110,103,116,104}; op[1627] = getOpcodeTls(a);}
        op[1628] = getOpcodeRnm(394, 2840); // OPEN
        op[1629] = getOpcodeRnm(384, 2810); // BWS
        op[1630] = getOpcodeRnm(126, 1067); // commonExpr
        op[1631] = getOpcodeRnm(384, 2810); // BWS
        op[1632] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1634,1635,1636,1637,1638,1639,1640,1641,1642,1643}; op[1633] = getOpcodeCat(a);}
        {char[] a = {103,101,111,46,105,110,116,101,114,115,101,99,116,115}; op[1634] = getOpcodeTls(a);}
        op[1635] = getOpcodeRnm(394, 2840); // OPEN
        op[1636] = getOpcodeRnm(384, 2810); // BWS
        op[1637] = getOpcodeRnm(126, 1067); // commonExpr
        op[1638] = getOpcodeRnm(384, 2810); // BWS
        op[1639] = getOpcodeRnm(387, 2822); // COMMA
        op[1640] = getOpcodeRnm(384, 2810); // BWS
        op[1641] = getOpcodeRnm(126, 1067); // commonExpr
        op[1642] = getOpcodeRnm(384, 2810); // BWS
        op[1643] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1645,1646,1647,1648,1649,1650,1651,1652,1653,1654}; op[1644] = getOpcodeCat(a);}
        {char[] a = {104,97,115,115,117,98,115,101,116}; op[1645] = getOpcodeTls(a);}
        op[1646] = getOpcodeRnm(394, 2840); // OPEN
        op[1647] = getOpcodeRnm(384, 2810); // BWS
        op[1648] = getOpcodeRnm(126, 1067); // commonExpr
        op[1649] = getOpcodeRnm(384, 2810); // BWS
        op[1650] = getOpcodeRnm(387, 2822); // COMMA
        op[1651] = getOpcodeRnm(384, 2810); // BWS
        op[1652] = getOpcodeRnm(126, 1067); // commonExpr
        op[1653] = getOpcodeRnm(384, 2810); // BWS
        op[1654] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1656,1657,1658,1659,1660,1661,1662,1663,1664,1665}; op[1655] = getOpcodeCat(a);}
        {char[] a = {104,97,115,115,117,98,115,101,113,117,101,110,99,101}; op[1656] = getOpcodeTls(a);}
        op[1657] = getOpcodeRnm(394, 2840); // OPEN
        op[1658] = getOpcodeRnm(384, 2810); // BWS
        op[1659] = getOpcodeRnm(126, 1067); // commonExpr
        op[1660] = getOpcodeRnm(384, 2810); // BWS
        op[1661] = getOpcodeRnm(387, 2822); // COMMA
        op[1662] = getOpcodeRnm(384, 2810); // BWS
        op[1663] = getOpcodeRnm(126, 1067); // commonExpr
        op[1664] = getOpcodeRnm(384, 2810); // BWS
        op[1665] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1667,1668,1669,1670,1671,1672,1673,1674,1675,1676,1686}; op[1666] = getOpcodeCat(a);}
        {char[] a = {99,97,115,101}; op[1667] = getOpcodeTls(a);}
        op[1668] = getOpcodeRnm(394, 2840); // OPEN
        op[1669] = getOpcodeRnm(384, 2810); // BWS
        op[1670] = getOpcodeRnm(127, 1102); // boolCommonExpr
        op[1671] = getOpcodeRnm(384, 2810); // BWS
        op[1672] = getOpcodeRnm(386, 2819); // COLON
        op[1673] = getOpcodeRnm(384, 2810); // BWS
        op[1674] = getOpcodeRnm(126, 1067); // commonExpr
        op[1675] = getOpcodeRnm(384, 2810); // BWS
        op[1676] = getOpcodeRep((char)0, Character.MAX_VALUE, 1677);
        {int[] a = {1678,1679,1680,1681,1682,1683,1684,1685}; op[1677] = getOpcodeCat(a);}
        op[1678] = getOpcodeRnm(387, 2822); // COMMA
        op[1679] = getOpcodeRnm(384, 2810); // BWS
        op[1680] = getOpcodeRnm(127, 1102); // boolCommonExpr
        op[1681] = getOpcodeRnm(384, 2810); // BWS
        op[1682] = getOpcodeRnm(386, 2819); // COLON
        op[1683] = getOpcodeRnm(384, 2810); // BWS
        op[1684] = getOpcodeRnm(126, 1067); // commonExpr
        op[1685] = getOpcodeRnm(384, 2810); // BWS
        op[1686] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1688,1689,1690,1691,1692}; op[1687] = getOpcodeCat(a);}
        op[1688] = getOpcodeRnm(394, 2840); // OPEN
        op[1689] = getOpcodeRnm(384, 2810); // BWS
        op[1690] = getOpcodeRnm(126, 1067); // commonExpr
        op[1691] = getOpcodeRnm(384, 2810); // BWS
        op[1692] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1694,1695,1696,1697,1698,1704}; op[1693] = getOpcodeCat(a);}
        op[1694] = getOpcodeRnm(394, 2840); // OPEN
        op[1695] = getOpcodeRnm(384, 2810); // BWS
        op[1696] = getOpcodeRnm(279, 2076); // primitiveLiteral
        op[1697] = getOpcodeRnm(384, 2810); // BWS
        op[1698] = getOpcodeRep((char)0, Character.MAX_VALUE, 1699);
        {int[] a = {1700,1701,1702,1703}; op[1699] = getOpcodeCat(a);}
        op[1700] = getOpcodeRnm(387, 2822); // COMMA
        op[1701] = getOpcodeRnm(384, 2810); // BWS
        op[1702] = getOpcodeRnm(279, 2076); // primitiveLiteral
        op[1703] = getOpcodeRnm(384, 2810); // BWS
        op[1704] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1706,1707,1708,1709}; op[1705] = getOpcodeCat(a);}
        op[1706] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {97,110,100}; op[1707] = getOpcodeTls(a);}
        op[1708] = getOpcodeRnm(383, 2804); // RWS
        op[1709] = getOpcodeRnm(127, 1102); // boolCommonExpr
        {int[] a = {1711,1712,1713,1714}; op[1710] = getOpcodeCat(a);}
        op[1711] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {111,114}; op[1712] = getOpcodeTls(a);}
        op[1713] = getOpcodeRnm(383, 2804); // RWS
        op[1714] = getOpcodeRnm(127, 1102); // boolCommonExpr
        {int[] a = {1716,1717,1718,1719}; op[1715] = getOpcodeCat(a);}
        op[1716] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {101,113}; op[1717] = getOpcodeTls(a);}
        op[1718] = getOpcodeRnm(383, 2804); // RWS
        op[1719] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1721,1722,1723,1724}; op[1720] = getOpcodeCat(a);}
        op[1721] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {110,101}; op[1722] = getOpcodeTls(a);}
        op[1723] = getOpcodeRnm(383, 2804); // RWS
        op[1724] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1726,1727,1728,1729}; op[1725] = getOpcodeCat(a);}
        op[1726] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {108,116}; op[1727] = getOpcodeTls(a);}
        op[1728] = getOpcodeRnm(383, 2804); // RWS
        op[1729] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1731,1732,1733,1734}; op[1730] = getOpcodeCat(a);}
        op[1731] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {108,101}; op[1732] = getOpcodeTls(a);}
        op[1733] = getOpcodeRnm(383, 2804); // RWS
        op[1734] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1736,1737,1738,1739}; op[1735] = getOpcodeCat(a);}
        op[1736] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {103,116}; op[1737] = getOpcodeTls(a);}
        op[1738] = getOpcodeRnm(383, 2804); // RWS
        op[1739] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1741,1742,1743,1744}; op[1740] = getOpcodeCat(a);}
        op[1741] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {103,101}; op[1742] = getOpcodeTls(a);}
        op[1743] = getOpcodeRnm(383, 2804); // RWS
        op[1744] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1746,1747,1748,1749}; op[1745] = getOpcodeCat(a);}
        op[1746] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {105,110}; op[1747] = getOpcodeTls(a);}
        op[1748] = getOpcodeRnm(383, 2804); // RWS
        {int[] a = {1750,1751}; op[1749] = getOpcodeAlt(a);}
        op[1750] = getOpcodeRnm(191, 1693); // listExpr
        op[1751] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1753,1754,1755,1756}; op[1752] = getOpcodeCat(a);}
        op[1753] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {104,97,115}; op[1754] = getOpcodeTls(a);}
        op[1755] = getOpcodeRnm(383, 2804); // RWS
        op[1756] = getOpcodeRnm(316, 2430); // enum
        {int[] a = {1758,1759,1760,1761}; op[1757] = getOpcodeCat(a);}
        op[1758] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {97,100,100}; op[1759] = getOpcodeTls(a);}
        op[1760] = getOpcodeRnm(383, 2804); // RWS
        op[1761] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1763,1764,1765,1766}; op[1762] = getOpcodeCat(a);}
        op[1763] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {115,117,98}; op[1764] = getOpcodeTls(a);}
        op[1765] = getOpcodeRnm(383, 2804); // RWS
        op[1766] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1768,1769,1770,1771}; op[1767] = getOpcodeCat(a);}
        op[1768] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {109,117,108}; op[1769] = getOpcodeTls(a);}
        op[1770] = getOpcodeRnm(383, 2804); // RWS
        op[1771] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1773,1774,1775,1776}; op[1772] = getOpcodeCat(a);}
        op[1773] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {100,105,118}; op[1774] = getOpcodeTls(a);}
        op[1775] = getOpcodeRnm(383, 2804); // RWS
        op[1776] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1778,1779,1780,1781}; op[1777] = getOpcodeCat(a);}
        op[1778] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {100,105,118,98,121}; op[1779] = getOpcodeTls(a);}
        op[1780] = getOpcodeRnm(383, 2804); // RWS
        op[1781] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1783,1784,1785,1786}; op[1782] = getOpcodeCat(a);}
        op[1783] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {109,111,100}; op[1784] = getOpcodeTls(a);}
        op[1785] = getOpcodeRnm(383, 2804); // RWS
        op[1786] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1788,1789,1790}; op[1787] = getOpcodeCat(a);}
        {char[] a = {45}; op[1788] = getOpcodeTls(a);}
        op[1789] = getOpcodeRnm(384, 2810); // BWS
        op[1790] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1792,1793,1794}; op[1791] = getOpcodeCat(a);}
        {char[] a = {110,111,116}; op[1792] = getOpcodeTls(a);}
        op[1793] = getOpcodeRnm(383, 2804); // RWS
        op[1794] = getOpcodeRnm(127, 1102); // boolCommonExpr
        {int[] a = {1796,1797,1798,1799,1805,1806,1807}; op[1795] = getOpcodeCat(a);}
        {char[] a = {105,115,111,102}; op[1796] = getOpcodeTls(a);}
        op[1797] = getOpcodeRnm(394, 2840); // OPEN
        op[1798] = getOpcodeRnm(384, 2810); // BWS
        op[1799] = getOpcodeRep((char)0, (char)1, 1800);
        {int[] a = {1801,1802,1803,1804}; op[1800] = getOpcodeCat(a);}
        op[1801] = getOpcodeRnm(126, 1067); // commonExpr
        op[1802] = getOpcodeRnm(384, 2810); // BWS
        op[1803] = getOpcodeRnm(387, 2822); // COMMA
        op[1804] = getOpcodeRnm(384, 2810); // BWS
        op[1805] = getOpcodeRnm(229, 1926); // optionallyQualifiedTypeName
        op[1806] = getOpcodeRnm(384, 2810); // BWS
        op[1807] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1809,1810,1811,1812,1818,1819,1820}; op[1808] = getOpcodeCat(a);}
        {char[] a = {99,97,115,116}; op[1809] = getOpcodeTls(a);}
        op[1810] = getOpcodeRnm(394, 2840); // OPEN
        op[1811] = getOpcodeRnm(384, 2810); // BWS
        op[1812] = getOpcodeRep((char)0, (char)1, 1813);
        {int[] a = {1814,1815,1816,1817}; op[1813] = getOpcodeCat(a);}
        op[1814] = getOpcodeRnm(126, 1067); // commonExpr
        op[1815] = getOpcodeRnm(384, 2810); // BWS
        op[1816] = getOpcodeRnm(387, 2822); // COMMA
        op[1817] = getOpcodeRnm(384, 2810); // BWS
        op[1818] = getOpcodeRnm(229, 1926); // optionallyQualifiedTypeName
        op[1819] = getOpcodeRnm(384, 2810); // BWS
        op[1820] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1822,1823}; op[1821] = getOpcodeAlt(a);}
        op[1822] = getOpcodeRnm(213, 1824); // array
        op[1823] = getOpcodeRnm(214, 1834); // object
        {int[] a = {1825,1826,1833}; op[1824] = getOpcodeCat(a);}
        op[1825] = getOpcodeRnm(219, 1862); // begin-array
        op[1826] = getOpcodeRep((char)0, (char)1, 1827);
        {int[] a = {1828,1829}; op[1827] = getOpcodeCat(a);}
        op[1828] = getOpcodeRnm(216, 1848); // valueInUrl
        op[1829] = getOpcodeRep((char)0, Character.MAX_VALUE, 1830);
        {int[] a = {1831,1832}; op[1830] = getOpcodeCat(a);}
        op[1831] = getOpcodeRnm(223, 1880); // value-separator
        op[1832] = getOpcodeRnm(216, 1848); // valueInUrl
        op[1833] = getOpcodeRnm(220, 1868); // end-array
        {int[] a = {1835,1836,1843}; op[1834] = getOpcodeCat(a);}
        op[1835] = getOpcodeRnm(217, 1851); // begin-object
        op[1836] = getOpcodeRep((char)0, (char)1, 1837);
        {int[] a = {1838,1839}; op[1837] = getOpcodeCat(a);}
        op[1838] = getOpcodeRnm(215, 1844); // member
        op[1839] = getOpcodeRep((char)0, Character.MAX_VALUE, 1840);
        {int[] a = {1841,1842}; op[1840] = getOpcodeCat(a);}
        op[1841] = getOpcodeRnm(223, 1880); // value-separator
        op[1842] = getOpcodeRnm(215, 1844); // member
        op[1843] = getOpcodeRnm(218, 1857); // end-object
        {int[] a = {1845,1846,1847}; op[1844] = getOpcodeCat(a);}
        op[1845] = getOpcodeRnm(224, 1884); // stringInUrl
        op[1846] = getOpcodeRnm(222, 1876); // name-separator
        op[1847] = getOpcodeRnm(216, 1848); // valueInUrl
        {int[] a = {1849,1850}; op[1848] = getOpcodeAlt(a);}
        op[1849] = getOpcodeRnm(224, 1884); // stringInUrl
        op[1850] = getOpcodeRnm(126, 1067); // commonExpr
        {int[] a = {1852,1853,1856}; op[1851] = getOpcodeCat(a);}
        op[1852] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1854,1855}; op[1853] = getOpcodeAlt(a);}
        {char[] a = {123}; op[1854] = getOpcodeTls(a);}
        {char[] a = {37,55,66}; op[1855] = getOpcodeTls(a);}
        op[1856] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1858,1859}; op[1857] = getOpcodeCat(a);}
        op[1858] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1860,1861}; op[1859] = getOpcodeAlt(a);}
        {char[] a = {125}; op[1860] = getOpcodeTls(a);}
        {char[] a = {37,55,68}; op[1861] = getOpcodeTls(a);}
        {int[] a = {1863,1864,1867}; op[1862] = getOpcodeCat(a);}
        op[1863] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1865,1866}; op[1864] = getOpcodeAlt(a);}
        {char[] a = {91}; op[1865] = getOpcodeTls(a);}
        {char[] a = {37,53,66}; op[1866] = getOpcodeTls(a);}
        op[1867] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1869,1870}; op[1868] = getOpcodeCat(a);}
        op[1869] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1871,1872}; op[1870] = getOpcodeAlt(a);}
        {char[] a = {93}; op[1871] = getOpcodeTls(a);}
        {char[] a = {37,53,68}; op[1872] = getOpcodeTls(a);}
        {int[] a = {1874,1875}; op[1873] = getOpcodeAlt(a);}
        op[1874] = getOpcodeRnm(439, 3290); // DQUOTE
        {char[] a = {37,50,50}; op[1875] = getOpcodeTls(a);}
        {int[] a = {1877,1878,1879}; op[1876] = getOpcodeCat(a);}
        op[1877] = getOpcodeRnm(384, 2810); // BWS
        op[1878] = getOpcodeRnm(386, 2819); // COLON
        op[1879] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1881,1882,1883}; op[1880] = getOpcodeCat(a);}
        op[1881] = getOpcodeRnm(384, 2810); // BWS
        op[1882] = getOpcodeRnm(387, 2822); // COMMA
        op[1883] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {1885,1886,1888}; op[1884] = getOpcodeCat(a);}
        op[1885] = getOpcodeRnm(221, 1873); // quotation-mark
        op[1886] = getOpcodeRep((char)0, Character.MAX_VALUE, 1887);
        op[1887] = getOpcodeRnm(225, 1889); // charInJSON
        op[1888] = getOpcodeRnm(221, 1873); // quotation-mark
        {int[] a = {1890,1891,1892}; op[1889] = getOpcodeAlt(a);}
        op[1890] = getOpcodeRnm(430, 3192); // qchar-unescaped
        op[1891] = getOpcodeRnm(226, 1909); // qchar-JSON-special
        {int[] a = {1893,1894}; op[1892] = getOpcodeCat(a);}
        op[1893] = getOpcodeRnm(227, 1916); // escape
        {int[] a = {1895,1896,1897,1900,1901,1902,1903,1904,1905}; op[1894] = getOpcodeAlt(a);}
        op[1895] = getOpcodeRnm(221, 1873); // quotation-mark
        op[1896] = getOpcodeRnm(227, 1916); // escape
        {int[] a = {1898,1899}; op[1897] = getOpcodeAlt(a);}
        {char[] a = {47}; op[1898] = getOpcodeTls(a);}
        {char[] a = {37,50,70}; op[1899] = getOpcodeTls(a);}
        {char[] a = {98}; op[1900] = getOpcodeTbs(a);}
        {char[] a = {102}; op[1901] = getOpcodeTbs(a);}
        {char[] a = {110}; op[1902] = getOpcodeTbs(a);}
        {char[] a = {114}; op[1903] = getOpcodeTbs(a);}
        {char[] a = {116}; op[1904] = getOpcodeTbs(a);}
        {int[] a = {1906,1907}; op[1905] = getOpcodeCat(a);}
        {char[] a = {117}; op[1906] = getOpcodeTbs(a);}
        op[1907] = getOpcodeRep((char)4, (char)4, 1908);
        op[1908] = getOpcodeRnm(437, 3280); // HEXDIG
        {int[] a = {1910,1911,1912,1913,1914,1915}; op[1909] = getOpcodeAlt(a);}
        op[1910] = getOpcodeRnm(440, 3291); // SP
        {char[] a = {58}; op[1911] = getOpcodeTls(a);}
        {char[] a = {123}; op[1912] = getOpcodeTls(a);}
        {char[] a = {125}; op[1913] = getOpcodeTls(a);}
        {char[] a = {91}; op[1914] = getOpcodeTls(a);}
        {char[] a = {93}; op[1915] = getOpcodeTls(a);}
        {int[] a = {1917,1918}; op[1916] = getOpcodeAlt(a);}
        {char[] a = {92}; op[1917] = getOpcodeTls(a);}
        {char[] a = {37,53,67}; op[1918] = getOpcodeTls(a);}
        {int[] a = {1920,1921}; op[1919] = getOpcodeAlt(a);}
        op[1920] = getOpcodeRnm(230, 1939); // singleQualifiedTypeName
        {int[] a = {1922,1923,1924,1925}; op[1921] = getOpcodeCat(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110}; op[1922] = getOpcodeTbs(a);}
        op[1923] = getOpcodeRnm(394, 2840); // OPEN
        op[1924] = getOpcodeRnm(230, 1939); // singleQualifiedTypeName
        op[1925] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1927,1928,1933,1934}; op[1926] = getOpcodeAlt(a);}
        op[1927] = getOpcodeRnm(230, 1939); // singleQualifiedTypeName
        {int[] a = {1929,1930,1931,1932}; op[1928] = getOpcodeCat(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110}; op[1929] = getOpcodeTbs(a);}
        op[1930] = getOpcodeRnm(394, 2840); // OPEN
        op[1931] = getOpcodeRnm(230, 1939); // singleQualifiedTypeName
        op[1932] = getOpcodeRnm(395, 2843); // CLOSE
        op[1933] = getOpcodeRnm(231, 1945); // singleTypeName
        {int[] a = {1935,1936,1937,1938}; op[1934] = getOpcodeCat(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110}; op[1935] = getOpcodeTbs(a);}
        op[1936] = getOpcodeRnm(394, 2840); // OPEN
        op[1937] = getOpcodeRnm(231, 1945); // singleTypeName
        op[1938] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {1940,1941,1942,1943,1944}; op[1939] = getOpcodeAlt(a);}
        op[1940] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[1941] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        op[1942] = getOpcodeRnm(234, 1958); // qualifiedTypeDefinitionName
        op[1943] = getOpcodeRnm(235, 1962); // qualifiedEnumTypeName
        op[1944] = getOpcodeRnm(251, 2004); // primitiveTypeName
        {int[] a = {1946,1947,1948,1949}; op[1945] = getOpcodeAlt(a);}
        op[1946] = getOpcodeRnm(242, 1987); // entityTypeName
        op[1947] = getOpcodeRnm(243, 1988); // complexTypeName
        op[1948] = getOpcodeRnm(244, 1989); // typeDefinitionName
        op[1949] = getOpcodeRnm(245, 1990); // enumerationTypeName
        {int[] a = {1951,1952,1953}; op[1950] = getOpcodeCat(a);}
        op[1951] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1952] = getOpcodeTls(a);}
        op[1953] = getOpcodeRnm(242, 1987); // entityTypeName
        {int[] a = {1955,1956,1957}; op[1954] = getOpcodeCat(a);}
        op[1955] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1956] = getOpcodeTls(a);}
        op[1957] = getOpcodeRnm(243, 1988); // complexTypeName
        {int[] a = {1959,1960,1961}; op[1958] = getOpcodeCat(a);}
        op[1959] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1960] = getOpcodeTls(a);}
        op[1961] = getOpcodeRnm(244, 1989); // typeDefinitionName
        {int[] a = {1963,1964,1965}; op[1962] = getOpcodeCat(a);}
        op[1963] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1964] = getOpcodeTls(a);}
        op[1965] = getOpcodeRnm(245, 1990); // enumerationTypeName
        {int[] a = {1967,1971}; op[1966] = getOpcodeCat(a);}
        op[1967] = getOpcodeRep((char)0, (char)1, 1968);
        {int[] a = {1969,1970}; op[1968] = getOpcodeCat(a);}
        op[1969] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1970] = getOpcodeTls(a);}
        op[1971] = getOpcodeRnm(242, 1987); // entityTypeName
        {int[] a = {1973,1977}; op[1972] = getOpcodeCat(a);}
        op[1973] = getOpcodeRep((char)0, (char)1, 1974);
        {int[] a = {1975,1976}; op[1974] = getOpcodeCat(a);}
        op[1975] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[1976] = getOpcodeTls(a);}
        op[1977] = getOpcodeRnm(243, 1988); // complexTypeName
        {int[] a = {1979,1980}; op[1978] = getOpcodeCat(a);}
        op[1979] = getOpcodeRnm(239, 1984); // namespacePart
        op[1980] = getOpcodeRep((char)0, Character.MAX_VALUE, 1981);
        {int[] a = {1982,1983}; op[1981] = getOpcodeCat(a);}
        {char[] a = {46}; op[1982] = getOpcodeTls(a);}
        op[1983] = getOpcodeRnm(239, 1984); // namespacePart
        op[1984] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1985] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1986] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1987] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1988] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1989] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1990] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1991] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[1992] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {1994,1995}; op[1993] = getOpcodeCat(a);}
        op[1994] = getOpcodeRnm(249, 1997); // identifierLeadingCharacter
        op[1995] = getOpcodeRep((char)0, (char)127, 1996);
        op[1996] = getOpcodeRnm(250, 2000); // identifierCharacter
        {int[] a = {1998,1999}; op[1997] = getOpcodeAlt(a);}
        op[1998] = getOpcodeRnm(435, 3276); // ALPHA
        {char[] a = {95}; op[1999] = getOpcodeTls(a);}
    }
    private static void addOpcodes01(Opcode[] op){
        {int[] a = {2001,2002,2003}; op[2000] = getOpcodeAlt(a);}
        op[2001] = getOpcodeRnm(435, 3276); // ALPHA
        {char[] a = {95}; op[2002] = getOpcodeTls(a);}
        op[2003] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2005,2006}; op[2004] = getOpcodeCat(a);}
        {char[] a = {69,100,109,46}; op[2005] = getOpcodeTbs(a);}
        {int[] a = {2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023,2024}; op[2006] = getOpcodeAlt(a);}
        {char[] a = {66,105,110,97,114,121}; op[2007] = getOpcodeTbs(a);}
        {char[] a = {66,111,111,108,101,97,110}; op[2008] = getOpcodeTbs(a);}
        {char[] a = {66,121,116,101}; op[2009] = getOpcodeTbs(a);}
        {char[] a = {68,97,116,101}; op[2010] = getOpcodeTbs(a);}
        {char[] a = {68,97,116,101,84,105,109,101,79,102,102,115,101,116}; op[2011] = getOpcodeTbs(a);}
        {char[] a = {68,101,99,105,109,97,108}; op[2012] = getOpcodeTbs(a);}
        {char[] a = {68,111,117,98,108,101}; op[2013] = getOpcodeTbs(a);}
        {char[] a = {68,117,114,97,116,105,111,110}; op[2014] = getOpcodeTbs(a);}
        {char[] a = {71,117,105,100}; op[2015] = getOpcodeTbs(a);}
        {char[] a = {73,110,116,49,54}; op[2016] = getOpcodeTbs(a);}
        {char[] a = {73,110,116,51,50}; op[2017] = getOpcodeTbs(a);}
        {char[] a = {73,110,116,54,52}; op[2018] = getOpcodeTbs(a);}
        {char[] a = {83,66,121,116,101}; op[2019] = getOpcodeTbs(a);}
        {char[] a = {83,105,110,103,108,101}; op[2020] = getOpcodeTbs(a);}
        {char[] a = {83,116,114,101,97,109}; op[2021] = getOpcodeTbs(a);}
        {char[] a = {83,116,114,105,110,103}; op[2022] = getOpcodeTbs(a);}
        {char[] a = {84,105,109,101,79,102,68,97,121}; op[2023] = getOpcodeTbs(a);}
        {int[] a = {2025,2026}; op[2024] = getOpcodeCat(a);}
        op[2025] = getOpcodeRnm(252, 2028); // abstractSpatialTypeName
        op[2026] = getOpcodeRep((char)0, (char)1, 2027);
        op[2027] = getOpcodeRnm(253, 2031); // concreteSpatialTypeName
        {int[] a = {2029,2030}; op[2028] = getOpcodeAlt(a);}
        {char[] a = {71,101,111,103,114,97,112,104,121}; op[2029] = getOpcodeTbs(a);}
        {char[] a = {71,101,111,109,101,116,114,121}; op[2030] = getOpcodeTbs(a);}
        {int[] a = {2032,2033,2034,2035,2036,2037,2038}; op[2031] = getOpcodeAlt(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110}; op[2032] = getOpcodeTbs(a);}
        {char[] a = {76,105,110,101,83,116,114,105,110,103}; op[2033] = getOpcodeTbs(a);}
        {char[] a = {77,117,108,116,105,76,105,110,101,83,116,114,105,110,103}; op[2034] = getOpcodeTbs(a);}
        {char[] a = {77,117,108,116,105,80,111,105,110,116}; op[2035] = getOpcodeTbs(a);}
        {char[] a = {77,117,108,116,105,80,111,108,121,103,111,110}; op[2036] = getOpcodeTbs(a);}
        {char[] a = {80,111,105,110,116}; op[2037] = getOpcodeTbs(a);}
        {char[] a = {80,111,108,121,103,111,110}; op[2038] = getOpcodeTbs(a);}
        {int[] a = {2040,2041,2042,2043}; op[2039] = getOpcodeAlt(a);}
        op[2040] = getOpcodeRnm(255, 2044); // primitiveKeyProperty
        op[2041] = getOpcodeRnm(256, 2045); // primitiveNonKeyProperty
        op[2042] = getOpcodeRnm(454, 3402); // expressionAlias
        op[2043] = getOpcodeRnm(455, 3403); // customAggregate
        op[2044] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2045] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2046] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2047] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2048] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2049] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {2051,2052}; op[2050] = getOpcodeAlt(a);}
        op[2051] = getOpcodeRnm(262, 2053); // entityNavigationProperty
        op[2052] = getOpcodeRnm(263, 2054); // entityColNavigationProperty
        op[2053] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2054] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2055] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2056] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {2058,2059,2060,2061,2062,2063}; op[2057] = getOpcodeAlt(a);}
        op[2058] = getOpcodeRnm(267, 2064); // entityFunction
        op[2059] = getOpcodeRnm(268, 2065); // entityColFunction
        op[2060] = getOpcodeRnm(269, 2066); // complexFunction
        op[2061] = getOpcodeRnm(270, 2067); // complexColFunction
        op[2062] = getOpcodeRnm(271, 2068); // primitiveFunction
        op[2063] = getOpcodeRnm(272, 2069); // primitiveColFunction
        op[2064] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2065] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2066] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2067] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2068] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2069] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2070] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2071] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2072] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2073] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2074] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[2075] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {2077,2078,2079,2080,2081,2082,2083,2084,2085,2086,2087,2088,2089,2090,2091,2092,2093,2094,2095,2096,2097,2098,2099,2100,2101,2102,2103,2104,2105,2106,2107,2108}; op[2076] = getOpcodeAlt(a);}
        op[2077] = getOpcodeRnm(281, 2133); // nullValue
        op[2078] = getOpcodeRnm(287, 2183); // booleanValue
        op[2079] = getOpcodeRnm(292, 2211); // guidValue
        op[2080] = getOpcodeRnm(302, 2279); // dateTimeOffsetValueInUrl
        op[2081] = getOpcodeRnm(300, 2258); // dateValue
        op[2082] = getOpcodeRnm(306, 2344); // timeOfDayValueInUrl
        op[2083] = getOpcodeRnm(288, 2186); // decimalValue
        op[2084] = getOpcodeRnm(289, 2205); // doubleValue
        op[2085] = getOpcodeRnm(290, 2206); // singleValue
        op[2086] = getOpcodeRnm(294, 2228); // sbyteValue
        op[2087] = getOpcodeRnm(293, 2226); // byteValue
        op[2088] = getOpcodeRnm(295, 2233); // int16Value
        op[2089] = getOpcodeRnm(296, 2238); // int32Value
        op[2090] = getOpcodeRnm(297, 2243); // int64Value
        op[2091] = getOpcodeRnm(298, 2248); // string
        op[2092] = getOpcodeRnm(303, 2294); // duration
        op[2093] = getOpcodeRnm(316, 2430); // enum
        op[2094] = getOpcodeRnm(282, 2134); // binary
        op[2095] = getOpcodeRnm(320, 2446); // geographyCollection
        op[2096] = getOpcodeRnm(324, 2470); // geographyLineString
        op[2097] = getOpcodeRnm(328, 2489); // geographyMultiLineString
        op[2098] = getOpcodeRnm(331, 2507); // geographyMultiPoint
        op[2099] = getOpcodeRnm(334, 2525); // geographyMultiPolygon
        op[2100] = getOpcodeRnm(337, 2543); // geographyPoint
        op[2101] = getOpcodeRnm(343, 2576); // geographyPolygon
        op[2102] = getOpcodeRnm(348, 2603); // geometryCollection
        op[2103] = getOpcodeRnm(349, 2608); // geometryLineString
        op[2104] = getOpcodeRnm(350, 2613); // geometryMultiLineString
        op[2105] = getOpcodeRnm(351, 2618); // geometryMultiPoint
        op[2106] = getOpcodeRnm(352, 2623); // geometryMultiPolygon
        op[2107] = getOpcodeRnm(353, 2628); // geometryPoint
        op[2108] = getOpcodeRnm(354, 2633); // geometryPolygon
        {int[] a = {2110,2111,2112,2113,2114,2115,2116,2117,2118,2119,2120,2121,2122,2123,2124,2125,2126,2127,2128,2129,2130,2131,2132}; op[2109] = getOpcodeAlt(a);}
        op[2110] = getOpcodeRnm(287, 2183); // booleanValue
        op[2111] = getOpcodeRnm(292, 2211); // guidValue
        op[2112] = getOpcodeRnm(304, 2300); // durationValue
        op[2113] = getOpcodeRnm(301, 2264); // dateTimeOffsetValue
        op[2114] = getOpcodeRnm(300, 2258); // dateValue
        op[2115] = getOpcodeRnm(305, 2332); // timeOfDayValue
        op[2116] = getOpcodeRnm(317, 2436); // enumValue
        op[2117] = getOpcodeRnm(321, 2451); // fullCollectionLiteral
        op[2118] = getOpcodeRnm(325, 2475); // fullLineStringLiteral
        op[2119] = getOpcodeRnm(332, 2512); // fullMultiPointLiteral
        op[2120] = getOpcodeRnm(329, 2494); // fullMultiLineStringLiteral
        op[2121] = getOpcodeRnm(335, 2530); // fullMultiPolygonLiteral
        op[2122] = getOpcodeRnm(338, 2548); // fullPointLiteral
        op[2123] = getOpcodeRnm(344, 2581); // fullPolygonLiteral
        op[2124] = getOpcodeRnm(288, 2186); // decimalValue
        op[2125] = getOpcodeRnm(289, 2205); // doubleValue
        op[2126] = getOpcodeRnm(290, 2206); // singleValue
        op[2127] = getOpcodeRnm(294, 2228); // sbyteValue
        op[2128] = getOpcodeRnm(293, 2226); // byteValue
        op[2129] = getOpcodeRnm(295, 2233); // int16Value
        op[2130] = getOpcodeRnm(296, 2238); // int32Value
        op[2131] = getOpcodeRnm(297, 2243); // int64Value
        op[2132] = getOpcodeRnm(283, 2139); // binaryValue
        {char[] a = {110,117,108,108}; op[2133] = getOpcodeTbs(a);}
        {int[] a = {2135,2136,2137,2138}; op[2134] = getOpcodeCat(a);}
        {char[] a = {98,105,110,97,114,121}; op[2135] = getOpcodeTls(a);}
        op[2136] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2137] = getOpcodeRnm(283, 2139); // binaryValue
        op[2138] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2140,2143}; op[2139] = getOpcodeCat(a);}
        op[2140] = getOpcodeRep((char)0, Character.MAX_VALUE, 2141);
        op[2141] = getOpcodeRep((char)4, (char)4, 2142);
        op[2142] = getOpcodeRnm(286, 2178); // base64char
        op[2143] = getOpcodeRep((char)0, (char)1, 2144);
        {int[] a = {2145,2146}; op[2144] = getOpcodeAlt(a);}
        op[2145] = getOpcodeRnm(284, 2147); // base64b16
        op[2146] = getOpcodeRnm(285, 2169); // base64b8
        {int[] a = {2148,2150,2167}; op[2147] = getOpcodeCat(a);}
        op[2148] = getOpcodeRep((char)2, (char)2, 2149);
        op[2149] = getOpcodeRnm(286, 2178); // base64char
        {int[] a = {2151,2152,2153,2154,2155,2156,2157,2158,2159,2160,2161,2162,2163,2164,2165,2166}; op[2150] = getOpcodeAlt(a);}
        {char[] a = {65}; op[2151] = getOpcodeTbs(a);}
        {char[] a = {69}; op[2152] = getOpcodeTbs(a);}
        {char[] a = {73}; op[2153] = getOpcodeTbs(a);}
        {char[] a = {77}; op[2154] = getOpcodeTbs(a);}
        {char[] a = {81}; op[2155] = getOpcodeTbs(a);}
        {char[] a = {85}; op[2156] = getOpcodeTbs(a);}
        {char[] a = {89}; op[2157] = getOpcodeTbs(a);}
        {char[] a = {99}; op[2158] = getOpcodeTbs(a);}
        {char[] a = {103}; op[2159] = getOpcodeTbs(a);}
        {char[] a = {107}; op[2160] = getOpcodeTbs(a);}
        {char[] a = {111}; op[2161] = getOpcodeTbs(a);}
        {char[] a = {115}; op[2162] = getOpcodeTbs(a);}
        {char[] a = {119}; op[2163] = getOpcodeTbs(a);}
        {char[] a = {48}; op[2164] = getOpcodeTbs(a);}
        {char[] a = {52}; op[2165] = getOpcodeTbs(a);}
        {char[] a = {56}; op[2166] = getOpcodeTbs(a);}
        op[2167] = getOpcodeRep((char)0, (char)1, 2168);
        {char[] a = {61}; op[2168] = getOpcodeTls(a);}
        {int[] a = {2170,2171,2176}; op[2169] = getOpcodeCat(a);}
        op[2170] = getOpcodeRnm(286, 2178); // base64char
        {int[] a = {2172,2173,2174,2175}; op[2171] = getOpcodeAlt(a);}
        {char[] a = {65}; op[2172] = getOpcodeTbs(a);}
        {char[] a = {81}; op[2173] = getOpcodeTbs(a);}
        {char[] a = {103}; op[2174] = getOpcodeTbs(a);}
        {char[] a = {119}; op[2175] = getOpcodeTbs(a);}
        op[2176] = getOpcodeRep((char)0, (char)1, 2177);
        {char[] a = {61,61}; op[2177] = getOpcodeTls(a);}
        {int[] a = {2179,2180,2181,2182}; op[2178] = getOpcodeAlt(a);}
        op[2179] = getOpcodeRnm(435, 3276); // ALPHA
        op[2180] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {45}; op[2181] = getOpcodeTls(a);}
        {char[] a = {95}; op[2182] = getOpcodeTls(a);}
        {int[] a = {2184,2185}; op[2183] = getOpcodeAlt(a);}
        {char[] a = {116,114,117,101}; op[2184] = getOpcodeTls(a);}
        {char[] a = {102,97,108,115,101}; op[2185] = getOpcodeTls(a);}
        {int[] a = {2187,2204}; op[2186] = getOpcodeAlt(a);}
        {int[] a = {2188,2190,2192,2197}; op[2187] = getOpcodeCat(a);}
        op[2188] = getOpcodeRep((char)0, (char)1, 2189);
        op[2189] = getOpcodeRnm(390, 2827); // SIGN
        op[2190] = getOpcodeRep((char)1, Character.MAX_VALUE, 2191);
        op[2191] = getOpcodeRnm(436, 3279); // DIGIT
        op[2192] = getOpcodeRep((char)0, (char)1, 2193);
        {int[] a = {2194,2195}; op[2193] = getOpcodeCat(a);}
        {char[] a = {46}; op[2194] = getOpcodeTls(a);}
        op[2195] = getOpcodeRep((char)1, Character.MAX_VALUE, 2196);
        op[2196] = getOpcodeRnm(436, 3279); // DIGIT
        op[2197] = getOpcodeRep((char)0, (char)1, 2198);
        {int[] a = {2199,2200,2202}; op[2198] = getOpcodeCat(a);}
        {char[] a = {101}; op[2199] = getOpcodeTls(a);}
        op[2200] = getOpcodeRep((char)0, (char)1, 2201);
        op[2201] = getOpcodeRnm(390, 2827); // SIGN
        op[2202] = getOpcodeRep((char)1, Character.MAX_VALUE, 2203);
        op[2203] = getOpcodeRnm(436, 3279); // DIGIT
        op[2204] = getOpcodeRnm(291, 2207); // nanInfinity
        op[2205] = getOpcodeRnm(288, 2186); // decimalValue
        op[2206] = getOpcodeRnm(288, 2186); // decimalValue
        {int[] a = {2208,2209,2210}; op[2207] = getOpcodeAlt(a);}
        {char[] a = {78,97,78}; op[2208] = getOpcodeTbs(a);}
        {char[] a = {45,73,78,70}; op[2209] = getOpcodeTbs(a);}
        {char[] a = {73,78,70}; op[2210] = getOpcodeTbs(a);}
        {int[] a = {2212,2214,2215,2217,2218,2220,2221,2223,2224}; op[2211] = getOpcodeCat(a);}
        op[2212] = getOpcodeRep((char)8, (char)8, 2213);
        op[2213] = getOpcodeRnm(437, 3280); // HEXDIG
        {char[] a = {45}; op[2214] = getOpcodeTls(a);}
        op[2215] = getOpcodeRep((char)4, (char)4, 2216);
        op[2216] = getOpcodeRnm(437, 3280); // HEXDIG
        {char[] a = {45}; op[2217] = getOpcodeTls(a);}
        op[2218] = getOpcodeRep((char)4, (char)4, 2219);
        op[2219] = getOpcodeRnm(437, 3280); // HEXDIG
        {char[] a = {45}; op[2220] = getOpcodeTls(a);}
        op[2221] = getOpcodeRep((char)4, (char)4, 2222);
        op[2222] = getOpcodeRnm(437, 3280); // HEXDIG
        {char[] a = {45}; op[2223] = getOpcodeTls(a);}
        op[2224] = getOpcodeRep((char)12, (char)12, 2225);
        op[2225] = getOpcodeRnm(437, 3280); // HEXDIG
        op[2226] = getOpcodeRep((char)1, (char)3, 2227);
        op[2227] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2229,2231}; op[2228] = getOpcodeCat(a);}
        op[2229] = getOpcodeRep((char)0, (char)1, 2230);
        op[2230] = getOpcodeRnm(390, 2827); // SIGN
        op[2231] = getOpcodeRep((char)1, (char)3, 2232);
        op[2232] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2234,2236}; op[2233] = getOpcodeCat(a);}
        op[2234] = getOpcodeRep((char)0, (char)1, 2235);
        op[2235] = getOpcodeRnm(390, 2827); // SIGN
        op[2236] = getOpcodeRep((char)1, (char)5, 2237);
        op[2237] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2239,2241}; op[2238] = getOpcodeCat(a);}
        op[2239] = getOpcodeRep((char)0, (char)1, 2240);
        op[2240] = getOpcodeRnm(390, 2827); // SIGN
        op[2241] = getOpcodeRep((char)1, (char)10, 2242);
        op[2242] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2244,2246}; op[2243] = getOpcodeCat(a);}
        op[2244] = getOpcodeRep((char)0, (char)1, 2245);
        op[2245] = getOpcodeRnm(390, 2827); // SIGN
        op[2246] = getOpcodeRep((char)1, (char)19, 2247);
        op[2247] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2249,2250,2254}; op[2248] = getOpcodeCat(a);}
        op[2249] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2250] = getOpcodeRep((char)0, Character.MAX_VALUE, 2251);
        {int[] a = {2252,2253}; op[2251] = getOpcodeAlt(a);}
        op[2252] = getOpcodeRnm(299, 2255); // SQUOTE-in-string
        op[2253] = getOpcodeRnm(423, 3105); // pchar-no-SQUOTE
        op[2254] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2256,2257}; op[2255] = getOpcodeCat(a);}
        op[2256] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2257] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2259,2260,2261,2262,2263}; op[2258] = getOpcodeCat(a);}
        op[2259] = getOpcodeRnm(309, 2375); // year
        {char[] a = {45}; op[2260] = getOpcodeTls(a);}
        op[2261] = getOpcodeRnm(310, 2387); // month
        {char[] a = {45}; op[2262] = getOpcodeTls(a);}
        op[2263] = getOpcodeRnm(311, 2397); // day
        {int[] a = {2265,2266,2267,2268,2269,2270,2271,2272}; op[2264] = getOpcodeCat(a);}
        op[2265] = getOpcodeRnm(309, 2375); // year
        {char[] a = {45}; op[2266] = getOpcodeTls(a);}
        op[2267] = getOpcodeRnm(310, 2387); // month
        {char[] a = {45}; op[2268] = getOpcodeTls(a);}
        op[2269] = getOpcodeRnm(311, 2397); // day
        {char[] a = {84}; op[2270] = getOpcodeTls(a);}
        op[2271] = getOpcodeRnm(305, 2332); // timeOfDayValue
        {int[] a = {2273,2274}; op[2272] = getOpcodeAlt(a);}
        {char[] a = {90}; op[2273] = getOpcodeTls(a);}
        {int[] a = {2275,2276,2277,2278}; op[2274] = getOpcodeCat(a);}
        op[2275] = getOpcodeRnm(390, 2827); // SIGN
        op[2276] = getOpcodeRnm(312, 2411); // hour
        {char[] a = {58}; op[2277] = getOpcodeTls(a);}
        op[2278] = getOpcodeRnm(313, 2424); // minute
        {int[] a = {2280,2281,2282,2283,2284,2285,2286,2287}; op[2279] = getOpcodeCat(a);}
        op[2280] = getOpcodeRnm(309, 2375); // year
        {char[] a = {45}; op[2281] = getOpcodeTls(a);}
        op[2282] = getOpcodeRnm(310, 2387); // month
        {char[] a = {45}; op[2283] = getOpcodeTls(a);}
        op[2284] = getOpcodeRnm(311, 2397); // day
        {char[] a = {84}; op[2285] = getOpcodeTls(a);}
        op[2286] = getOpcodeRnm(306, 2344); // timeOfDayValueInUrl
        {int[] a = {2288,2289}; op[2287] = getOpcodeAlt(a);}
        {char[] a = {90}; op[2288] = getOpcodeTls(a);}
        {int[] a = {2290,2291,2292,2293}; op[2289] = getOpcodeCat(a);}
        op[2290] = getOpcodeRnm(390, 2827); // SIGN
        op[2291] = getOpcodeRnm(312, 2411); // hour
        op[2292] = getOpcodeRnm(386, 2819); // COLON
        op[2293] = getOpcodeRnm(313, 2424); // minute
        {int[] a = {2295,2297,2298,2299}; op[2294] = getOpcodeCat(a);}
        op[2295] = getOpcodeRep((char)0, (char)1, 2296);
        {char[] a = {100,117,114,97,116,105,111,110}; op[2296] = getOpcodeTls(a);}
        op[2297] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2298] = getOpcodeRnm(304, 2300); // durationValue
        op[2299] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2301,2303,2304,2309}; op[2300] = getOpcodeCat(a);}
        op[2301] = getOpcodeRep((char)0, (char)1, 2302);
        op[2302] = getOpcodeRnm(390, 2827); // SIGN
        {char[] a = {80}; op[2303] = getOpcodeTls(a);}
        op[2304] = getOpcodeRep((char)0, (char)1, 2305);
        {int[] a = {2306,2308}; op[2305] = getOpcodeCat(a);}
        op[2306] = getOpcodeRep((char)1, Character.MAX_VALUE, 2307);
        op[2307] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {68}; op[2308] = getOpcodeTls(a);}
        op[2309] = getOpcodeRep((char)0, (char)1, 2310);
        {int[] a = {2311,2312,2317,2322}; op[2310] = getOpcodeCat(a);}
        {char[] a = {84}; op[2311] = getOpcodeTls(a);}
        op[2312] = getOpcodeRep((char)0, (char)1, 2313);
        {int[] a = {2314,2316}; op[2313] = getOpcodeCat(a);}
        op[2314] = getOpcodeRep((char)1, Character.MAX_VALUE, 2315);
        op[2315] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {72}; op[2316] = getOpcodeTls(a);}
        op[2317] = getOpcodeRep((char)0, (char)1, 2318);
        {int[] a = {2319,2321}; op[2318] = getOpcodeCat(a);}
        op[2319] = getOpcodeRep((char)1, Character.MAX_VALUE, 2320);
        op[2320] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {77}; op[2321] = getOpcodeTls(a);}
        op[2322] = getOpcodeRep((char)0, (char)1, 2323);
        {int[] a = {2324,2326,2331}; op[2323] = getOpcodeCat(a);}
        op[2324] = getOpcodeRep((char)1, Character.MAX_VALUE, 2325);
        op[2325] = getOpcodeRnm(436, 3279); // DIGIT
        op[2326] = getOpcodeRep((char)0, (char)1, 2327);
        {int[] a = {2328,2329}; op[2327] = getOpcodeCat(a);}
        {char[] a = {46}; op[2328] = getOpcodeTls(a);}
        op[2329] = getOpcodeRep((char)1, Character.MAX_VALUE, 2330);
        op[2330] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {83}; op[2331] = getOpcodeTls(a);}
        {int[] a = {2333,2334,2335,2336}; op[2332] = getOpcodeCat(a);}
        op[2333] = getOpcodeRnm(312, 2411); // hour
        {char[] a = {58}; op[2334] = getOpcodeTls(a);}
        op[2335] = getOpcodeRnm(313, 2424); // minute
        op[2336] = getOpcodeRep((char)0, (char)1, 2337);
        {int[] a = {2338,2339,2340}; op[2337] = getOpcodeCat(a);}
        {char[] a = {58}; op[2338] = getOpcodeTls(a);}
        op[2339] = getOpcodeRnm(314, 2425); // second
        op[2340] = getOpcodeRep((char)0, (char)1, 2341);
        {int[] a = {2342,2343}; op[2341] = getOpcodeCat(a);}
        {char[] a = {46}; op[2342] = getOpcodeTls(a);}
        op[2343] = getOpcodeRnm(315, 2428); // fractionalSeconds
        {int[] a = {2345,2346,2347,2348}; op[2344] = getOpcodeCat(a);}
        op[2345] = getOpcodeRnm(312, 2411); // hour
        op[2346] = getOpcodeRnm(386, 2819); // COLON
        op[2347] = getOpcodeRnm(313, 2424); // minute
        op[2348] = getOpcodeRep((char)0, (char)1, 2349);
        {int[] a = {2350,2351,2352}; op[2349] = getOpcodeCat(a);}
        op[2350] = getOpcodeRnm(386, 2819); // COLON
        op[2351] = getOpcodeRnm(314, 2425); // second
        op[2352] = getOpcodeRep((char)0, (char)1, 2353);
        {int[] a = {2354,2355}; op[2353] = getOpcodeCat(a);}
        {char[] a = {46}; op[2354] = getOpcodeTls(a);}
        op[2355] = getOpcodeRnm(315, 2428); // fractionalSeconds
        {int[] a = {2357,2358,2359,2360,2361,2362,2363,2364,2365}; op[2356] = getOpcodeAlt(a);}
        {char[] a = {49}; op[2357] = getOpcodeTls(a);}
        {char[] a = {50}; op[2358] = getOpcodeTls(a);}
        {char[] a = {51}; op[2359] = getOpcodeTls(a);}
        {char[] a = {52}; op[2360] = getOpcodeTls(a);}
        {char[] a = {53}; op[2361] = getOpcodeTls(a);}
        {char[] a = {54}; op[2362] = getOpcodeTls(a);}
        {char[] a = {55}; op[2363] = getOpcodeTls(a);}
        {char[] a = {56}; op[2364] = getOpcodeTls(a);}
        {char[] a = {57}; op[2365] = getOpcodeTls(a);}
        {int[] a = {2367,2374}; op[2366] = getOpcodeCat(a);}
        {int[] a = {2368,2369,2370,2371,2372,2373}; op[2367] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2368] = getOpcodeTls(a);}
        {char[] a = {49}; op[2369] = getOpcodeTls(a);}
        {char[] a = {50}; op[2370] = getOpcodeTls(a);}
        {char[] a = {51}; op[2371] = getOpcodeTls(a);}
        {char[] a = {52}; op[2372] = getOpcodeTls(a);}
        {char[] a = {53}; op[2373] = getOpcodeTls(a);}
        op[2374] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2376,2378}; op[2375] = getOpcodeCat(a);}
        op[2376] = getOpcodeRep((char)0, (char)1, 2377);
        {char[] a = {45}; op[2377] = getOpcodeTls(a);}
        {int[] a = {2379,2383}; op[2378] = getOpcodeAlt(a);}
        {int[] a = {2380,2381}; op[2379] = getOpcodeCat(a);}
        {char[] a = {48}; op[2380] = getOpcodeTls(a);}
        op[2381] = getOpcodeRep((char)3, (char)3, 2382);
        op[2382] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2384,2385}; op[2383] = getOpcodeCat(a);}
        op[2384] = getOpcodeRnm(307, 2356); // oneToNine
        op[2385] = getOpcodeRep((char)3, Character.MAX_VALUE, 2386);
        op[2386] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2388,2391}; op[2387] = getOpcodeAlt(a);}
        {int[] a = {2389,2390}; op[2388] = getOpcodeCat(a);}
        {char[] a = {48}; op[2389] = getOpcodeTls(a);}
        op[2390] = getOpcodeRnm(307, 2356); // oneToNine
        {int[] a = {2392,2393}; op[2391] = getOpcodeCat(a);}
        {char[] a = {49}; op[2392] = getOpcodeTls(a);}
        {int[] a = {2394,2395,2396}; op[2393] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2394] = getOpcodeTls(a);}
        {char[] a = {49}; op[2395] = getOpcodeTls(a);}
        {char[] a = {50}; op[2396] = getOpcodeTls(a);}
        {int[] a = {2398,2401,2406}; op[2397] = getOpcodeAlt(a);}
        {int[] a = {2399,2400}; op[2398] = getOpcodeCat(a);}
        {char[] a = {48}; op[2399] = getOpcodeTls(a);}
        op[2400] = getOpcodeRnm(307, 2356); // oneToNine
        {int[] a = {2402,2405}; op[2401] = getOpcodeCat(a);}
        {int[] a = {2403,2404}; op[2402] = getOpcodeAlt(a);}
        {char[] a = {49}; op[2403] = getOpcodeTls(a);}
        {char[] a = {50}; op[2404] = getOpcodeTls(a);}
        op[2405] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2407,2408}; op[2406] = getOpcodeCat(a);}
        {char[] a = {51}; op[2407] = getOpcodeTls(a);}
        {int[] a = {2409,2410}; op[2408] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2409] = getOpcodeTls(a);}
        {char[] a = {49}; op[2410] = getOpcodeTls(a);}
        {int[] a = {2412,2417}; op[2411] = getOpcodeAlt(a);}
        {int[] a = {2413,2416}; op[2412] = getOpcodeCat(a);}
        {int[] a = {2414,2415}; op[2413] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2414] = getOpcodeTls(a);}
        {char[] a = {49}; op[2415] = getOpcodeTls(a);}
        op[2416] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2418,2419}; op[2417] = getOpcodeCat(a);}
        {char[] a = {50}; op[2418] = getOpcodeTls(a);}
        {int[] a = {2420,2421,2422,2423}; op[2419] = getOpcodeAlt(a);}
        {char[] a = {48}; op[2420] = getOpcodeTls(a);}
        {char[] a = {49}; op[2421] = getOpcodeTls(a);}
        {char[] a = {50}; op[2422] = getOpcodeTls(a);}
        {char[] a = {51}; op[2423] = getOpcodeTls(a);}
        op[2424] = getOpcodeRnm(308, 2366); // zeroToFiftyNine
        {int[] a = {2426,2427}; op[2425] = getOpcodeAlt(a);}
        op[2426] = getOpcodeRnm(308, 2366); // zeroToFiftyNine
        {char[] a = {54,48}; op[2427] = getOpcodeTls(a);}
        op[2428] = getOpcodeRep((char)1, (char)12, 2429);
        op[2429] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2431,2433,2434,2435}; op[2430] = getOpcodeCat(a);}
        op[2431] = getOpcodeRep((char)0, (char)1, 2432);
        op[2432] = getOpcodeRnm(235, 1962); // qualifiedEnumTypeName
        op[2433] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2434] = getOpcodeRnm(317, 2436); // enumValue
        op[2435] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2437,2438}; op[2436] = getOpcodeCat(a);}
        op[2437] = getOpcodeRnm(318, 2442); // singleEnumValue
        op[2438] = getOpcodeRep((char)0, Character.MAX_VALUE, 2439);
        {int[] a = {2440,2441}; op[2439] = getOpcodeCat(a);}
        op[2440] = getOpcodeRnm(387, 2822); // COMMA
        op[2441] = getOpcodeRnm(318, 2442); // singleEnumValue
        {int[] a = {2443,2444}; op[2442] = getOpcodeAlt(a);}
        op[2443] = getOpcodeRnm(246, 1991); // enumerationMember
        op[2444] = getOpcodeRnm(319, 2445); // enumMemberValue
        op[2445] = getOpcodeRnm(297, 2243); // int64Value
        {int[] a = {2447,2448,2449,2450}; op[2446] = getOpcodeCat(a);}
        op[2447] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2448] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2449] = getOpcodeRnm(321, 2451); // fullCollectionLiteral
        op[2450] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2452,2453}; op[2451] = getOpcodeCat(a);}
        op[2452] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2453] = getOpcodeRnm(322, 2454); // collectionLiteral
        {int[] a = {2455,2456,2457,2461}; op[2454] = getOpcodeCat(a);}
        {char[] a = {67,111,108,108,101,99,116,105,111,110,40}; op[2455] = getOpcodeTls(a);}
        op[2456] = getOpcodeRnm(323, 2462); // geoLiteral
        op[2457] = getOpcodeRep((char)0, Character.MAX_VALUE, 2458);
        {int[] a = {2459,2460}; op[2458] = getOpcodeCat(a);}
        op[2459] = getOpcodeRnm(387, 2822); // COMMA
        op[2460] = getOpcodeRnm(323, 2462); // geoLiteral
        op[2461] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2463,2464,2465,2466,2467,2468,2469}; op[2462] = getOpcodeAlt(a);}
        op[2463] = getOpcodeRnm(322, 2454); // collectionLiteral
        op[2464] = getOpcodeRnm(326, 2478); // lineStringLiteral
        op[2465] = getOpcodeRnm(333, 2515); // multiPointLiteral
        op[2466] = getOpcodeRnm(330, 2497); // multiLineStringLiteral
        op[2467] = getOpcodeRnm(336, 2533); // multiPolygonLiteral
        op[2468] = getOpcodeRnm(340, 2557); // pointLiteral
        op[2469] = getOpcodeRnm(345, 2584); // polygonLiteral
        {int[] a = {2471,2472,2473,2474}; op[2470] = getOpcodeCat(a);}
        op[2471] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2472] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2473] = getOpcodeRnm(325, 2475); // fullLineStringLiteral
        op[2474] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2476,2477}; op[2475] = getOpcodeCat(a);}
        op[2476] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2477] = getOpcodeRnm(326, 2478); // lineStringLiteral
        {int[] a = {2479,2480}; op[2478] = getOpcodeCat(a);}
        {char[] a = {76,105,110,101,83,116,114,105,110,103}; op[2479] = getOpcodeTls(a);}
        op[2480] = getOpcodeRnm(327, 2481); // lineStringData
        {int[] a = {2482,2483,2484,2488}; op[2481] = getOpcodeCat(a);}
        op[2482] = getOpcodeRnm(394, 2840); // OPEN
        op[2483] = getOpcodeRnm(342, 2564); // positionLiteral
        op[2484] = getOpcodeRep((char)1, Character.MAX_VALUE, 2485);
        {int[] a = {2486,2487}; op[2485] = getOpcodeCat(a);}
        op[2486] = getOpcodeRnm(387, 2822); // COMMA
        op[2487] = getOpcodeRnm(342, 2564); // positionLiteral
        op[2488] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2490,2491,2492,2493}; op[2489] = getOpcodeCat(a);}
        op[2490] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2491] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2492] = getOpcodeRnm(329, 2494); // fullMultiLineStringLiteral
        op[2493] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2495,2496}; op[2494] = getOpcodeCat(a);}
        op[2495] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2496] = getOpcodeRnm(330, 2497); // multiLineStringLiteral
        {int[] a = {2498,2499,2506}; op[2497] = getOpcodeCat(a);}
        {char[] a = {77,117,108,116,105,76,105,110,101,83,116,114,105,110,103,40}; op[2498] = getOpcodeTls(a);}
        op[2499] = getOpcodeRep((char)0, (char)1, 2500);
        {int[] a = {2501,2502}; op[2500] = getOpcodeCat(a);}
        op[2501] = getOpcodeRnm(327, 2481); // lineStringData
        op[2502] = getOpcodeRep((char)0, Character.MAX_VALUE, 2503);
        {int[] a = {2504,2505}; op[2503] = getOpcodeCat(a);}
        op[2504] = getOpcodeRnm(387, 2822); // COMMA
        op[2505] = getOpcodeRnm(327, 2481); // lineStringData
        op[2506] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2508,2509,2510,2511}; op[2507] = getOpcodeCat(a);}
        op[2508] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2509] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2510] = getOpcodeRnm(332, 2512); // fullMultiPointLiteral
        op[2511] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2513,2514}; op[2512] = getOpcodeCat(a);}
        op[2513] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2514] = getOpcodeRnm(333, 2515); // multiPointLiteral
        {int[] a = {2516,2517,2524}; op[2515] = getOpcodeCat(a);}
        {char[] a = {77,117,108,116,105,80,111,105,110,116,40}; op[2516] = getOpcodeTls(a);}
        op[2517] = getOpcodeRep((char)0, (char)1, 2518);
        {int[] a = {2519,2520}; op[2518] = getOpcodeCat(a);}
        op[2519] = getOpcodeRnm(341, 2560); // pointData
        op[2520] = getOpcodeRep((char)0, Character.MAX_VALUE, 2521);
        {int[] a = {2522,2523}; op[2521] = getOpcodeCat(a);}
        op[2522] = getOpcodeRnm(387, 2822); // COMMA
        op[2523] = getOpcodeRnm(341, 2560); // pointData
        op[2524] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2526,2527,2528,2529}; op[2525] = getOpcodeCat(a);}
        op[2526] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2527] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2528] = getOpcodeRnm(335, 2530); // fullMultiPolygonLiteral
        op[2529] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2531,2532}; op[2530] = getOpcodeCat(a);}
        op[2531] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2532] = getOpcodeRnm(336, 2533); // multiPolygonLiteral
        {int[] a = {2534,2535,2542}; op[2533] = getOpcodeCat(a);}
        {char[] a = {77,117,108,116,105,80,111,108,121,103,111,110,40}; op[2534] = getOpcodeTls(a);}
        op[2535] = getOpcodeRep((char)0, (char)1, 2536);
        {int[] a = {2537,2538}; op[2536] = getOpcodeCat(a);}
        op[2537] = getOpcodeRnm(346, 2587); // polygonData
        op[2538] = getOpcodeRep((char)0, Character.MAX_VALUE, 2539);
        {int[] a = {2540,2541}; op[2539] = getOpcodeCat(a);}
        op[2540] = getOpcodeRnm(387, 2822); // COMMA
        op[2541] = getOpcodeRnm(346, 2587); // polygonData
        op[2542] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2544,2545,2546,2547}; op[2543] = getOpcodeCat(a);}
        op[2544] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2545] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2546] = getOpcodeRnm(338, 2548); // fullPointLiteral
        op[2547] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2549,2550}; op[2548] = getOpcodeCat(a);}
        op[2549] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2550] = getOpcodeRnm(340, 2557); // pointLiteral
        {int[] a = {2552,2553,2554,2556}; op[2551] = getOpcodeCat(a);}
        {char[] a = {83,82,73,68}; op[2552] = getOpcodeTls(a);}
        op[2553] = getOpcodeRnm(388, 2825); // EQ
        op[2554] = getOpcodeRep((char)1, (char)5, 2555);
        op[2555] = getOpcodeRnm(436, 3279); // DIGIT
        op[2556] = getOpcodeRnm(391, 2831); // SEMI
        {int[] a = {2558,2559}; op[2557] = getOpcodeCat(a);}
        {char[] a = {80,111,105,110,116}; op[2558] = getOpcodeTls(a);}
        op[2559] = getOpcodeRnm(341, 2560); // pointData
        {int[] a = {2561,2562,2563}; op[2560] = getOpcodeCat(a);}
        op[2561] = getOpcodeRnm(394, 2840); // OPEN
        op[2562] = getOpcodeRnm(342, 2564); // positionLiteral
        op[2563] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2565,2566,2567,2568,2572}; op[2564] = getOpcodeCat(a);}
        op[2565] = getOpcodeRnm(289, 2205); // doubleValue
        op[2566] = getOpcodeRnm(440, 3291); // SP
        op[2567] = getOpcodeRnm(289, 2205); // doubleValue
        op[2568] = getOpcodeRep((char)0, (char)1, 2569);
        {int[] a = {2570,2571}; op[2569] = getOpcodeCat(a);}
        op[2570] = getOpcodeRnm(440, 3291); // SP
        op[2571] = getOpcodeRnm(289, 2205); // doubleValue
        op[2572] = getOpcodeRep((char)0, (char)1, 2573);
        {int[] a = {2574,2575}; op[2573] = getOpcodeCat(a);}
        op[2574] = getOpcodeRnm(440, 3291); // SP
        op[2575] = getOpcodeRnm(289, 2205); // doubleValue
        {int[] a = {2577,2578,2579,2580}; op[2576] = getOpcodeCat(a);}
        op[2577] = getOpcodeRnm(355, 2638); // geographyPrefix
        op[2578] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2579] = getOpcodeRnm(344, 2581); // fullPolygonLiteral
        op[2580] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2582,2583}; op[2581] = getOpcodeCat(a);}
        op[2582] = getOpcodeRnm(339, 2551); // sridLiteral
        op[2583] = getOpcodeRnm(345, 2584); // polygonLiteral
        {int[] a = {2585,2586}; op[2584] = getOpcodeCat(a);}
        {char[] a = {80,111,108,121,103,111,110}; op[2585] = getOpcodeTls(a);}
        op[2586] = getOpcodeRnm(346, 2587); // polygonData
        {int[] a = {2588,2589,2590,2594}; op[2587] = getOpcodeCat(a);}
        op[2588] = getOpcodeRnm(394, 2840); // OPEN
        op[2589] = getOpcodeRnm(347, 2595); // ringLiteral
        op[2590] = getOpcodeRep((char)0, Character.MAX_VALUE, 2591);
        {int[] a = {2592,2593}; op[2591] = getOpcodeCat(a);}
        op[2592] = getOpcodeRnm(387, 2822); // COMMA
        op[2593] = getOpcodeRnm(347, 2595); // ringLiteral
        op[2594] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2596,2597,2598,2602}; op[2595] = getOpcodeCat(a);}
        op[2596] = getOpcodeRnm(394, 2840); // OPEN
        op[2597] = getOpcodeRnm(342, 2564); // positionLiteral
        op[2598] = getOpcodeRep((char)0, Character.MAX_VALUE, 2599);
        {int[] a = {2600,2601}; op[2599] = getOpcodeCat(a);}
        op[2600] = getOpcodeRnm(387, 2822); // COMMA
        op[2601] = getOpcodeRnm(342, 2564); // positionLiteral
        op[2602] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {2604,2605,2606,2607}; op[2603] = getOpcodeCat(a);}
        op[2604] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2605] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2606] = getOpcodeRnm(321, 2451); // fullCollectionLiteral
        op[2607] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2609,2610,2611,2612}; op[2608] = getOpcodeCat(a);}
        op[2609] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2610] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2611] = getOpcodeRnm(325, 2475); // fullLineStringLiteral
        op[2612] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2614,2615,2616,2617}; op[2613] = getOpcodeCat(a);}
        op[2614] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2615] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2616] = getOpcodeRnm(329, 2494); // fullMultiLineStringLiteral
        op[2617] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2619,2620,2621,2622}; op[2618] = getOpcodeCat(a);}
        op[2619] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2620] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2621] = getOpcodeRnm(332, 2512); // fullMultiPointLiteral
        op[2622] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2624,2625,2626,2627}; op[2623] = getOpcodeCat(a);}
        op[2624] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2625] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2626] = getOpcodeRnm(335, 2530); // fullMultiPolygonLiteral
        op[2627] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2629,2630,2631,2632}; op[2628] = getOpcodeCat(a);}
        op[2629] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2630] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2631] = getOpcodeRnm(338, 2548); // fullPointLiteral
        op[2632] = getOpcodeRnm(393, 2837); // SQUOTE
        {int[] a = {2634,2635,2636,2637}; op[2633] = getOpcodeCat(a);}
        op[2634] = getOpcodeRnm(356, 2639); // geometryPrefix
        op[2635] = getOpcodeRnm(393, 2837); // SQUOTE
        op[2636] = getOpcodeRnm(344, 2581); // fullPolygonLiteral
        op[2637] = getOpcodeRnm(393, 2837); // SQUOTE
        {char[] a = {103,101,111,103,114,97,112,104,121}; op[2638] = getOpcodeTls(a);}
        {char[] a = {103,101,111,109,101,116,114,121}; op[2639] = getOpcodeTls(a);}
        {int[] a = {2641,2642,2643,2644,2645,2646,2647}; op[2640] = getOpcodeAlt(a);}
        op[2641] = getOpcodeRnm(358, 2648); // content-id
        op[2642] = getOpcodeRnm(359, 2653); // isolation
        op[2643] = getOpcodeRnm(361, 2662); // odata-entityid
        op[2644] = getOpcodeRnm(362, 2667); // odata-error
        op[2645] = getOpcodeRnm(363, 2676); // odata-maxversion
        op[2646] = getOpcodeRnm(364, 2685); // odata-version
        op[2647] = getOpcodeRnm(365, 2692); // prefer
        {int[] a = {2649,2650,2651,2652}; op[2648] = getOpcodeCat(a);}
        {char[] a = {67,111,110,116,101,110,116,45,73,68}; op[2649] = getOpcodeTls(a);}
        {char[] a = {58}; op[2650] = getOpcodeTls(a);}
        op[2651] = getOpcodeRnm(380, 2792); // OWS
        op[2652] = getOpcodeRnm(360, 2660); // request-id
        {int[] a = {2654,2656,2657,2658,2659}; op[2653] = getOpcodeCat(a);}
        op[2654] = getOpcodeRep((char)0, (char)1, 2655);
        {char[] a = {79,68,97,116,97,45}; op[2655] = getOpcodeTls(a);}
        {char[] a = {73,115,111,108,97,116,105,111,110}; op[2656] = getOpcodeTls(a);}
        {char[] a = {58}; op[2657] = getOpcodeTls(a);}
        op[2658] = getOpcodeRnm(380, 2792); // OWS
        {char[] a = {115,110,97,112,115,104,111,116}; op[2659] = getOpcodeTls(a);}
        op[2660] = getOpcodeRep((char)1, Character.MAX_VALUE, 2661);
        op[2661] = getOpcodeRnm(420, 3084); // unreserved
        {int[] a = {2663,2664,2665,2666}; op[2662] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,69,110,116,105,116,121,73,68}; op[2663] = getOpcodeTls(a);}
        {char[] a = {58}; op[2664] = getOpcodeTls(a);}
        op[2665] = getOpcodeRnm(380, 2792); // OWS
        op[2666] = getOpcodeRnm(433, 3270); // IRI-in-header
        {int[] a = {2668,2669,2670,2671,2672}; op[2667] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,69,114,114,111,114}; op[2668] = getOpcodeTls(a);}
        {char[] a = {58}; op[2669] = getOpcodeTls(a);}
        op[2670] = getOpcodeRnm(380, 2792); // OWS
        {char[] a = {123,34,99,111,100,101,34,58}; op[2671] = getOpcodeTbs(a);}
        op[2672] = getOpcodeRep((char)0, Character.MAX_VALUE, 2673);
        {int[] a = {2674,2675}; op[2673] = getOpcodeAlt(a);}
        op[2674] = getOpcodeRnm(442, 3293); // VCHAR
        op[2675] = getOpcodeRnm(440, 3291); // SP
        {int[] a = {2677,2678,2679,2680,2682,2683}; op[2676] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,77,97,120,86,101,114,115,105,111,110}; op[2677] = getOpcodeTls(a);}
        {char[] a = {58}; op[2678] = getOpcodeTls(a);}
        op[2679] = getOpcodeRnm(380, 2792); // OWS
        op[2680] = getOpcodeRep((char)1, Character.MAX_VALUE, 2681);
        op[2681] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {46}; op[2682] = getOpcodeTls(a);}
        op[2683] = getOpcodeRep((char)1, Character.MAX_VALUE, 2684);
        op[2684] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2686,2687,2688,2689,2690}; op[2685] = getOpcodeCat(a);}
        {char[] a = {79,68,97,116,97,45,86,101,114,115,105,111,110}; op[2686] = getOpcodeTls(a);}
        {char[] a = {58}; op[2687] = getOpcodeTls(a);}
        op[2688] = getOpcodeRnm(380, 2792); // OWS
        {char[] a = {52,46,48}; op[2689] = getOpcodeTls(a);}
        op[2690] = getOpcodeRep((char)0, (char)1, 2691);
        op[2691] = getOpcodeRnm(307, 2356); // oneToNine
        {int[] a = {2693,2694,2695,2696,2697}; op[2692] = getOpcodeCat(a);}
        {char[] a = {80,114,101,102,101,114}; op[2693] = getOpcodeTls(a);}
        {char[] a = {58}; op[2694] = getOpcodeTls(a);}
        op[2695] = getOpcodeRnm(380, 2792); // OWS
        op[2696] = getOpcodeRnm(366, 2703); // preference
        op[2697] = getOpcodeRep((char)0, Character.MAX_VALUE, 2698);
        {int[] a = {2699,2700,2701,2702}; op[2698] = getOpcodeCat(a);}
        op[2699] = getOpcodeRnm(380, 2792); // OWS
        {char[] a = {44}; op[2700] = getOpcodeTls(a);}
        op[2701] = getOpcodeRnm(380, 2792); // OWS
        op[2702] = getOpcodeRnm(366, 2703); // preference
        {int[] a = {2704,2705,2706,2707,2708,2709,2710,2711,2712}; op[2703] = getOpcodeAlt(a);}
        op[2704] = getOpcodeRnm(367, 2713); // allowEntityReferencesPreference
        op[2705] = getOpcodeRnm(368, 2717); // callbackPreference
        op[2706] = getOpcodeRnm(369, 2729); // continueOnErrorPreference
        op[2707] = getOpcodeRnm(370, 2737); // includeAnnotationsPreference
        op[2708] = getOpcodeRnm(374, 2767); // maxpagesizePreference
        op[2709] = getOpcodeRnm(375, 2775); // respondAsyncPreference
        op[2710] = getOpcodeRnm(376, 2776); // returnPreference
        op[2711] = getOpcodeRnm(377, 2782); // trackChangesPreference
        op[2712] = getOpcodeRnm(378, 2786); // waitPreference
        {int[] a = {2714,2716}; op[2713] = getOpcodeCat(a);}
        op[2714] = getOpcodeRep((char)0, (char)1, 2715);
        {char[] a = {111,100,97,116,97,46}; op[2715] = getOpcodeTls(a);}
        {char[] a = {97,108,108,111,119,45,101,110,116,105,116,121,114,101,102,101,114,101,110,99,101,115}; op[2716] = getOpcodeTls(a);}
        {int[] a = {2718,2720,2721,2722,2723,2724,2725,2726,2727,2728}; op[2717] = getOpcodeCat(a);}
        op[2718] = getOpcodeRep((char)0, (char)1, 2719);
        {char[] a = {111,100,97,116,97,46}; op[2719] = getOpcodeTls(a);}
        {char[] a = {99,97,108,108,98,97,99,107}; op[2720] = getOpcodeTls(a);}
        op[2721] = getOpcodeRnm(380, 2792); // OWS
        {char[] a = {59}; op[2722] = getOpcodeTls(a);}
        op[2723] = getOpcodeRnm(380, 2792); // OWS
        {char[] a = {117,114,108}; op[2724] = getOpcodeTls(a);}
        op[2725] = getOpcodeRnm(382, 2800); // EQ-h
        op[2726] = getOpcodeRnm(439, 3290); // DQUOTE
        op[2727] = getOpcodeRnm(396, 2846); // URI
        op[2728] = getOpcodeRnm(439, 3290); // DQUOTE
        {int[] a = {2730,2732,2733}; op[2729] = getOpcodeCat(a);}
        op[2730] = getOpcodeRep((char)0, (char)1, 2731);
        {char[] a = {111,100,97,116,97,46}; op[2731] = getOpcodeTls(a);}
        {char[] a = {99,111,110,116,105,110,117,101,45,111,110,45,101,114,114,111,114}; op[2732] = getOpcodeTls(a);}
        op[2733] = getOpcodeRep((char)0, (char)1, 2734);
        {int[] a = {2735,2736}; op[2734] = getOpcodeCat(a);}
        op[2735] = getOpcodeRnm(382, 2800); // EQ-h
        op[2736] = getOpcodeRnm(287, 2183); // booleanValue
        {int[] a = {2738,2740,2741,2742,2743,2744}; op[2737] = getOpcodeCat(a);}
        op[2738] = getOpcodeRep((char)0, (char)1, 2739);
        {char[] a = {111,100,97,116,97,46}; op[2739] = getOpcodeTls(a);}
        {char[] a = {105,110,99,108,117,100,101,45,97,110,110,111,116,97,116,105,111,110,115}; op[2740] = getOpcodeTls(a);}
        op[2741] = getOpcodeRnm(382, 2800); // EQ-h
        op[2742] = getOpcodeRnm(439, 3290); // DQUOTE
        op[2743] = getOpcodeRnm(371, 2745); // annotationsList
        op[2744] = getOpcodeRnm(439, 3290); // DQUOTE
        {int[] a = {2746,2747}; op[2745] = getOpcodeCat(a);}
        op[2746] = getOpcodeRnm(372, 2751); // annotationIdentifier
        op[2747] = getOpcodeRep((char)0, Character.MAX_VALUE, 2748);
        {int[] a = {2749,2750}; op[2748] = getOpcodeCat(a);}
        {char[] a = {44}; op[2749] = getOpcodeTls(a);}
        op[2750] = getOpcodeRnm(372, 2751); // annotationIdentifier
        {int[] a = {2752,2754,2762}; op[2751] = getOpcodeCat(a);}
        op[2752] = getOpcodeRep((char)0, (char)1, 2753);
        op[2753] = getOpcodeRnm(373, 2766); // excludeOperator
        {int[] a = {2755,2756}; op[2754] = getOpcodeAlt(a);}
        op[2755] = getOpcodeRnm(392, 2834); // STAR
        {int[] a = {2757,2758,2759}; op[2756] = getOpcodeCat(a);}
        op[2757] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[2758] = getOpcodeTls(a);}
        {int[] a = {2760,2761}; op[2759] = getOpcodeAlt(a);}
        op[2760] = getOpcodeRnm(247, 1992); // termName
        op[2761] = getOpcodeRnm(392, 2834); // STAR
        op[2762] = getOpcodeRep((char)0, (char)1, 2763);
        {int[] a = {2764,2765}; op[2763] = getOpcodeCat(a);}
        {char[] a = {35}; op[2764] = getOpcodeTls(a);}
        op[2765] = getOpcodeRnm(248, 1993); // odataIdentifier
        {char[] a = {45}; op[2766] = getOpcodeTls(a);}
        {int[] a = {2768,2770,2771,2772,2773}; op[2767] = getOpcodeCat(a);}
        op[2768] = getOpcodeRep((char)0, (char)1, 2769);
        {char[] a = {111,100,97,116,97,46}; op[2769] = getOpcodeTls(a);}
        {char[] a = {109,97,120,112,97,103,101,115,105,122,101}; op[2770] = getOpcodeTls(a);}
        op[2771] = getOpcodeRnm(382, 2800); // EQ-h
        op[2772] = getOpcodeRnm(307, 2356); // oneToNine
        op[2773] = getOpcodeRep((char)0, Character.MAX_VALUE, 2774);
        op[2774] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {114,101,115,112,111,110,100,45,97,115,121,110,99}; op[2775] = getOpcodeTls(a);}
        {int[] a = {2777,2778,2779}; op[2776] = getOpcodeCat(a);}
        {char[] a = {114,101,116,117,114,110}; op[2777] = getOpcodeTls(a);}
        op[2778] = getOpcodeRnm(382, 2800); // EQ-h
        {int[] a = {2780,2781}; op[2779] = getOpcodeAlt(a);}
        {char[] a = {114,101,112,114,101,115,101,110,116,97,116,105,111,110}; op[2780] = getOpcodeTbs(a);}
        {char[] a = {109,105,110,105,109,97,108}; op[2781] = getOpcodeTbs(a);}
        {int[] a = {2783,2785}; op[2782] = getOpcodeCat(a);}
        op[2783] = getOpcodeRep((char)0, (char)1, 2784);
        {char[] a = {111,100,97,116,97,46}; op[2784] = getOpcodeTls(a);}
        {char[] a = {116,114,97,99,107,45,99,104,97,110,103,101,115}; op[2785] = getOpcodeTls(a);}
        {int[] a = {2787,2788,2789}; op[2786] = getOpcodeCat(a);}
        {char[] a = {119,97,105,116}; op[2787] = getOpcodeTls(a);}
        op[2788] = getOpcodeRnm(382, 2800); // EQ-h
        op[2789] = getOpcodeRep((char)1, Character.MAX_VALUE, 2790);
        op[2790] = getOpcodeRnm(436, 3279); // DIGIT
        op[2791] = getOpcodeTrg((char)128, (char)255);
        op[2792] = getOpcodeRep((char)0, Character.MAX_VALUE, 2793);
        {int[] a = {2794,2795}; op[2793] = getOpcodeAlt(a);}
        op[2794] = getOpcodeRnm(440, 3291); // SP
        op[2795] = getOpcodeRnm(441, 3292); // HTAB
        op[2796] = getOpcodeRep((char)0, Character.MAX_VALUE, 2797);
        {int[] a = {2798,2799}; op[2797] = getOpcodeAlt(a);}
        op[2798] = getOpcodeRnm(440, 3291); // SP
        op[2799] = getOpcodeRnm(441, 3292); // HTAB
        {int[] a = {2801,2802,2803}; op[2800] = getOpcodeCat(a);}
        op[2801] = getOpcodeRnm(381, 2796); // BWS-h
        op[2802] = getOpcodeRnm(388, 2825); // EQ
        op[2803] = getOpcodeRnm(381, 2796); // BWS-h
        op[2804] = getOpcodeRep((char)1, Character.MAX_VALUE, 2805);
        {int[] a = {2806,2807,2808,2809}; op[2805] = getOpcodeAlt(a);}
        op[2806] = getOpcodeRnm(440, 3291); // SP
        op[2807] = getOpcodeRnm(441, 3292); // HTAB
        {char[] a = {37,50,48}; op[2808] = getOpcodeTls(a);}
        {char[] a = {37,48,57}; op[2809] = getOpcodeTls(a);}
        op[2810] = getOpcodeRep((char)0, Character.MAX_VALUE, 2811);
        {int[] a = {2812,2813,2814,2815}; op[2811] = getOpcodeAlt(a);}
        op[2812] = getOpcodeRnm(440, 3291); // SP
        op[2813] = getOpcodeRnm(441, 3292); // HTAB
        {char[] a = {37,50,48}; op[2814] = getOpcodeTls(a);}
        {char[] a = {37,48,57}; op[2815] = getOpcodeTls(a);}
        {int[] a = {2817,2818}; op[2816] = getOpcodeAlt(a);}
        {char[] a = {64}; op[2817] = getOpcodeTls(a);}
        {char[] a = {37,52,48}; op[2818] = getOpcodeTls(a);}
        {int[] a = {2820,2821}; op[2819] = getOpcodeAlt(a);}
        {char[] a = {58}; op[2820] = getOpcodeTls(a);}
        {char[] a = {37,51,65}; op[2821] = getOpcodeTls(a);}
        {int[] a = {2823,2824}; op[2822] = getOpcodeAlt(a);}
        {char[] a = {44}; op[2823] = getOpcodeTls(a);}
        {char[] a = {37,50,67}; op[2824] = getOpcodeTls(a);}
        {char[] a = {61}; op[2825] = getOpcodeTls(a);}
        {char[] a = {37,50,51}; op[2826] = getOpcodeTls(a);}
        {int[] a = {2828,2829,2830}; op[2827] = getOpcodeAlt(a);}
        {char[] a = {43}; op[2828] = getOpcodeTls(a);}
        {char[] a = {37,50,66}; op[2829] = getOpcodeTls(a);}
        {char[] a = {45}; op[2830] = getOpcodeTls(a);}
        {int[] a = {2832,2833}; op[2831] = getOpcodeAlt(a);}
        {char[] a = {59}; op[2832] = getOpcodeTls(a);}
        {char[] a = {37,51,66}; op[2833] = getOpcodeTls(a);}
        {int[] a = {2835,2836}; op[2834] = getOpcodeAlt(a);}
        {char[] a = {42}; op[2835] = getOpcodeTls(a);}
        {char[] a = {37,50,65}; op[2836] = getOpcodeTls(a);}
        {int[] a = {2838,2839}; op[2837] = getOpcodeAlt(a);}
        {char[] a = {39}; op[2838] = getOpcodeTls(a);}
        {char[] a = {37,50,55}; op[2839] = getOpcodeTls(a);}
        {int[] a = {2841,2842}; op[2840] = getOpcodeAlt(a);}
        {char[] a = {40}; op[2841] = getOpcodeTls(a);}
        {char[] a = {37,50,56}; op[2842] = getOpcodeTls(a);}
        {int[] a = {2844,2845}; op[2843] = getOpcodeAlt(a);}
        {char[] a = {41}; op[2844] = getOpcodeTls(a);}
        {char[] a = {37,50,57}; op[2845] = getOpcodeTls(a);}
        {int[] a = {2847,2848,2849,2850,2854}; op[2846] = getOpcodeCat(a);}
        op[2847] = getOpcodeRnm(398, 2865); // scheme
        {char[] a = {58}; op[2848] = getOpcodeTls(a);}
        op[2849] = getOpcodeRnm(397, 2858); // hier-part
        op[2850] = getOpcodeRep((char)0, (char)1, 2851);
        {int[] a = {2852,2853}; op[2851] = getOpcodeCat(a);}
        {char[] a = {63}; op[2852] = getOpcodeTls(a);}
        op[2853] = getOpcodeRnm(417, 3070); // query
        op[2854] = getOpcodeRep((char)0, (char)1, 2855);
        {int[] a = {2856,2857}; op[2855] = getOpcodeCat(a);}
        {char[] a = {35}; op[2856] = getOpcodeTls(a);}
        op[2857] = getOpcodeRnm(418, 3075); // fragment
        {int[] a = {2859,2863,2864}; op[2858] = getOpcodeAlt(a);}
        {int[] a = {2860,2861,2862}; op[2859] = getOpcodeCat(a);}
        {char[] a = {47,47}; op[2860] = getOpcodeTls(a);}
        op[2861] = getOpcodeRnm(399, 2874); // authority
        op[2862] = getOpcodeRnm(411, 3041); // path-abempty
        op[2863] = getOpcodeRnm(412, 3045); // path-absolute
        op[2864] = getOpcodeRnm(413, 3054); // path-rootless
        {int[] a = {2866,2867}; op[2865] = getOpcodeCat(a);}
        op[2866] = getOpcodeRnm(435, 3276); // ALPHA
        op[2867] = getOpcodeRep((char)0, Character.MAX_VALUE, 2868);
        {int[] a = {2869,2870,2871,2872,2873}; op[2868] = getOpcodeAlt(a);}
        op[2869] = getOpcodeRnm(435, 3276); // ALPHA
        op[2870] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {43}; op[2871] = getOpcodeTls(a);}
        {char[] a = {45}; op[2872] = getOpcodeTls(a);}
        {char[] a = {46}; op[2873] = getOpcodeTls(a);}
        {int[] a = {2875,2879,2880}; op[2874] = getOpcodeCat(a);}
        op[2875] = getOpcodeRep((char)0, (char)1, 2876);
        {int[] a = {2877,2878}; op[2876] = getOpcodeCat(a);}
        op[2877] = getOpcodeRnm(400, 2884); // userinfo
        {char[] a = {64}; op[2878] = getOpcodeTls(a);}
        op[2879] = getOpcodeRnm(401, 2890); // host
        op[2880] = getOpcodeRep((char)0, (char)1, 2881);
        {int[] a = {2882,2883}; op[2881] = getOpcodeCat(a);}
        {char[] a = {58}; op[2882] = getOpcodeTls(a);}
        op[2883] = getOpcodeRnm(402, 2894); // port
        op[2884] = getOpcodeRep((char)0, Character.MAX_VALUE, 2885);
        {int[] a = {2886,2887,2888,2889}; op[2885] = getOpcodeAlt(a);}
        op[2886] = getOpcodeRnm(420, 3084); // unreserved
        op[2887] = getOpcodeRnm(419, 3080); // pct-encoded
        op[2888] = getOpcodeRnm(421, 3091); // sub-delims
        {char[] a = {58}; op[2889] = getOpcodeTls(a);}
        {int[] a = {2891,2892,2893}; op[2890] = getOpcodeAlt(a);}
        op[2891] = getOpcodeRnm(403, 2896); // IP-literal
        op[2892] = getOpcodeRnm(408, 3012); // IPv4address
        op[2893] = getOpcodeRnm(410, 3036); // reg-name
        op[2894] = getOpcodeRep((char)0, Character.MAX_VALUE, 2895);
        op[2895] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {2897,2898,2901}; op[2896] = getOpcodeCat(a);}
        {char[] a = {91}; op[2897] = getOpcodeTls(a);}
        {int[] a = {2899,2900}; op[2898] = getOpcodeAlt(a);}
        op[2899] = getOpcodeRnm(405, 2912); // IPv6address
        op[2900] = getOpcodeRnm(404, 2902); // IPvFuture
        {char[] a = {93}; op[2901] = getOpcodeTls(a);}
        {int[] a = {2903,2904,2906,2907}; op[2902] = getOpcodeCat(a);}
        {char[] a = {118}; op[2903] = getOpcodeTls(a);}
        op[2904] = getOpcodeRep((char)1, Character.MAX_VALUE, 2905);
        op[2905] = getOpcodeRnm(437, 3280); // HEXDIG
        {char[] a = {46}; op[2906] = getOpcodeTls(a);}
        op[2907] = getOpcodeRep((char)1, Character.MAX_VALUE, 2908);
        {int[] a = {2909,2910,2911}; op[2908] = getOpcodeAlt(a);}
        op[2909] = getOpcodeRnm(420, 3084); // unreserved
        op[2910] = getOpcodeRnm(421, 3091); // sub-delims
        {char[] a = {58}; op[2911] = getOpcodeTls(a);}
        {int[] a = {2913,2919,2926,2935,2949,2963,2975,2985,2995}; op[2912] = getOpcodeAlt(a);}
        {int[] a = {2914,2918}; op[2913] = getOpcodeCat(a);}
        op[2914] = getOpcodeRep((char)6, (char)6, 2915);
        {int[] a = {2916,2917}; op[2915] = getOpcodeCat(a);}
        op[2916] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2917] = getOpcodeTls(a);}
        op[2918] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2920,2921,2925}; op[2919] = getOpcodeCat(a);}
        {char[] a = {58,58}; op[2920] = getOpcodeTls(a);}
        op[2921] = getOpcodeRep((char)5, (char)5, 2922);
        {int[] a = {2923,2924}; op[2922] = getOpcodeCat(a);}
        op[2923] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2924] = getOpcodeTls(a);}
        op[2925] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2927,2929,2930,2934}; op[2926] = getOpcodeCat(a);}
        op[2927] = getOpcodeRep((char)0, (char)1, 2928);
        op[2928] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[2929] = getOpcodeTls(a);}
        op[2930] = getOpcodeRep((char)4, (char)4, 2931);
        {int[] a = {2932,2933}; op[2931] = getOpcodeCat(a);}
        op[2932] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2933] = getOpcodeTls(a);}
        op[2934] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2936,2943,2944,2948}; op[2935] = getOpcodeCat(a);}
        op[2936] = getOpcodeRep((char)0, (char)1, 2937);
        {int[] a = {2938,2942}; op[2937] = getOpcodeCat(a);}
        op[2938] = getOpcodeRep((char)0, (char)1, 2939);
        {int[] a = {2940,2941}; op[2939] = getOpcodeCat(a);}
        op[2940] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2941] = getOpcodeTls(a);}
        op[2942] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[2943] = getOpcodeTls(a);}
        op[2944] = getOpcodeRep((char)3, (char)3, 2945);
        {int[] a = {2946,2947}; op[2945] = getOpcodeCat(a);}
        op[2946] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2947] = getOpcodeTls(a);}
        op[2948] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2950,2957,2958,2962}; op[2949] = getOpcodeCat(a);}
        op[2950] = getOpcodeRep((char)0, (char)1, 2951);
        {int[] a = {2952,2956}; op[2951] = getOpcodeCat(a);}
        op[2952] = getOpcodeRep((char)0, (char)2, 2953);
        {int[] a = {2954,2955}; op[2953] = getOpcodeCat(a);}
        op[2954] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2955] = getOpcodeTls(a);}
        op[2956] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[2957] = getOpcodeTls(a);}
        op[2958] = getOpcodeRep((char)2, (char)2, 2959);
        {int[] a = {2960,2961}; op[2959] = getOpcodeCat(a);}
        op[2960] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2961] = getOpcodeTls(a);}
        op[2962] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2964,2971,2972,2973,2974}; op[2963] = getOpcodeCat(a);}
        op[2964] = getOpcodeRep((char)0, (char)1, 2965);
        {int[] a = {2966,2970}; op[2965] = getOpcodeCat(a);}
        op[2966] = getOpcodeRep((char)0, (char)3, 2967);
        {int[] a = {2968,2969}; op[2967] = getOpcodeCat(a);}
        op[2968] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2969] = getOpcodeTls(a);}
        op[2970] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[2971] = getOpcodeTls(a);}
        op[2972] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2973] = getOpcodeTls(a);}
        op[2974] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2976,2983,2984}; op[2975] = getOpcodeCat(a);}
        op[2976] = getOpcodeRep((char)0, (char)1, 2977);
        {int[] a = {2978,2982}; op[2977] = getOpcodeCat(a);}
        op[2978] = getOpcodeRep((char)0, (char)4, 2979);
        {int[] a = {2980,2981}; op[2979] = getOpcodeCat(a);}
        op[2980] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2981] = getOpcodeTls(a);}
        op[2982] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[2983] = getOpcodeTls(a);}
        op[2984] = getOpcodeRnm(407, 3006); // ls32
        {int[] a = {2986,2993,2994}; op[2985] = getOpcodeCat(a);}
        op[2986] = getOpcodeRep((char)0, (char)1, 2987);
        {int[] a = {2988,2992}; op[2987] = getOpcodeCat(a);}
        op[2988] = getOpcodeRep((char)0, (char)5, 2989);
        {int[] a = {2990,2991}; op[2989] = getOpcodeCat(a);}
        op[2990] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[2991] = getOpcodeTls(a);}
        op[2992] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[2993] = getOpcodeTls(a);}
        op[2994] = getOpcodeRnm(406, 3004); // h16
        {int[] a = {2996,3003}; op[2995] = getOpcodeCat(a);}
        op[2996] = getOpcodeRep((char)0, (char)1, 2997);
        {int[] a = {2998,3002}; op[2997] = getOpcodeCat(a);}
        op[2998] = getOpcodeRep((char)0, (char)6, 2999);
        {int[] a = {3000,3001}; op[2999] = getOpcodeCat(a);}
        op[3000] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[3001] = getOpcodeTls(a);}
        op[3002] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58,58}; op[3003] = getOpcodeTls(a);}
        op[3004] = getOpcodeRep((char)1, (char)4, 3005);
        op[3005] = getOpcodeRnm(437, 3280); // HEXDIG
        {int[] a = {3007,3011}; op[3006] = getOpcodeAlt(a);}
        {int[] a = {3008,3009,3010}; op[3007] = getOpcodeCat(a);}
        op[3008] = getOpcodeRnm(406, 3004); // h16
        {char[] a = {58}; op[3009] = getOpcodeTls(a);}
        op[3010] = getOpcodeRnm(406, 3004); // h16
        op[3011] = getOpcodeRnm(408, 3012); // IPv4address
        {int[] a = {3013,3014,3015,3016,3017,3018,3019}; op[3012] = getOpcodeCat(a);}
        op[3013] = getOpcodeRnm(409, 3020); // dec-octet
        {char[] a = {46}; op[3014] = getOpcodeTls(a);}
        op[3015] = getOpcodeRnm(409, 3020); // dec-octet
        {char[] a = {46}; op[3016] = getOpcodeTls(a);}
        op[3017] = getOpcodeRnm(409, 3020); // dec-octet
        {char[] a = {46}; op[3018] = getOpcodeTls(a);}
        op[3019] = getOpcodeRnm(409, 3020); // dec-octet
        {int[] a = {3021,3025,3029,3032,3035}; op[3020] = getOpcodeAlt(a);}
        {int[] a = {3022,3023}; op[3021] = getOpcodeCat(a);}
        {char[] a = {49}; op[3022] = getOpcodeTls(a);}
        op[3023] = getOpcodeRep((char)2, (char)2, 3024);
        op[3024] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {3026,3027,3028}; op[3025] = getOpcodeCat(a);}
        {char[] a = {50}; op[3026] = getOpcodeTls(a);}
        op[3027] = getOpcodeTrg((char)48, (char)52);
        op[3028] = getOpcodeRnm(436, 3279); // DIGIT
        {int[] a = {3030,3031}; op[3029] = getOpcodeCat(a);}
        {char[] a = {50,53}; op[3030] = getOpcodeTls(a);}
        op[3031] = getOpcodeTrg((char)48, (char)53);
        {int[] a = {3033,3034}; op[3032] = getOpcodeCat(a);}
        op[3033] = getOpcodeTrg((char)49, (char)57);
        op[3034] = getOpcodeRnm(436, 3279); // DIGIT
        op[3035] = getOpcodeRnm(436, 3279); // DIGIT
        op[3036] = getOpcodeRep((char)0, Character.MAX_VALUE, 3037);
        {int[] a = {3038,3039,3040}; op[3037] = getOpcodeAlt(a);}
        op[3038] = getOpcodeRnm(420, 3084); // unreserved
        op[3039] = getOpcodeRnm(419, 3080); // pct-encoded
        op[3040] = getOpcodeRnm(421, 3091); // sub-delims
        op[3041] = getOpcodeRep((char)0, Character.MAX_VALUE, 3042);
        {int[] a = {3043,3044}; op[3042] = getOpcodeCat(a);}
        {char[] a = {47}; op[3043] = getOpcodeTls(a);}
        op[3044] = getOpcodeRnm(414, 3060); // segment
        {int[] a = {3046,3047}; op[3045] = getOpcodeCat(a);}
        {char[] a = {47}; op[3046] = getOpcodeTls(a);}
        op[3047] = getOpcodeRep((char)0, (char)1, 3048);
        {int[] a = {3049,3050}; op[3048] = getOpcodeCat(a);}
        op[3049] = getOpcodeRnm(415, 3062); // segment-nz
        op[3050] = getOpcodeRep((char)0, Character.MAX_VALUE, 3051);
        {int[] a = {3052,3053}; op[3051] = getOpcodeCat(a);}
        {char[] a = {47}; op[3052] = getOpcodeTls(a);}
        op[3053] = getOpcodeRnm(414, 3060); // segment
        {int[] a = {3055,3056}; op[3054] = getOpcodeCat(a);}
        op[3055] = getOpcodeRnm(415, 3062); // segment-nz
        op[3056] = getOpcodeRep((char)0, Character.MAX_VALUE, 3057);
        {int[] a = {3058,3059}; op[3057] = getOpcodeCat(a);}
        {char[] a = {47}; op[3058] = getOpcodeTls(a);}
        op[3059] = getOpcodeRnm(414, 3060); // segment
        op[3060] = getOpcodeRep((char)0, Character.MAX_VALUE, 3061);
        op[3061] = getOpcodeRnm(416, 3064); // pchar
        op[3062] = getOpcodeRep((char)1, Character.MAX_VALUE, 3063);
        op[3063] = getOpcodeRnm(416, 3064); // pchar
        {int[] a = {3065,3066,3067,3068,3069}; op[3064] = getOpcodeAlt(a);}
        op[3065] = getOpcodeRnm(420, 3084); // unreserved
        op[3066] = getOpcodeRnm(419, 3080); // pct-encoded
        op[3067] = getOpcodeRnm(421, 3091); // sub-delims
        {char[] a = {58}; op[3068] = getOpcodeTls(a);}
        {char[] a = {64}; op[3069] = getOpcodeTls(a);}
        op[3070] = getOpcodeRep((char)0, Character.MAX_VALUE, 3071);
        {int[] a = {3072,3073,3074}; op[3071] = getOpcodeAlt(a);}
        op[3072] = getOpcodeRnm(416, 3064); // pchar
        {char[] a = {47}; op[3073] = getOpcodeTls(a);}
        {char[] a = {63}; op[3074] = getOpcodeTls(a);}
        op[3075] = getOpcodeRep((char)0, Character.MAX_VALUE, 3076);
        {int[] a = {3077,3078,3079}; op[3076] = getOpcodeAlt(a);}
        op[3077] = getOpcodeRnm(416, 3064); // pchar
        {char[] a = {47}; op[3078] = getOpcodeTls(a);}
        {char[] a = {63}; op[3079] = getOpcodeTls(a);}
        {int[] a = {3081,3082,3083}; op[3080] = getOpcodeCat(a);}
        {char[] a = {37}; op[3081] = getOpcodeTls(a);}
        op[3082] = getOpcodeRnm(437, 3280); // HEXDIG
        op[3083] = getOpcodeRnm(437, 3280); // HEXDIG
        {int[] a = {3085,3086,3087,3088,3089,3090}; op[3084] = getOpcodeAlt(a);}
        op[3085] = getOpcodeRnm(435, 3276); // ALPHA
        op[3086] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {45}; op[3087] = getOpcodeTls(a);}
        {char[] a = {46}; op[3088] = getOpcodeTls(a);}
        {char[] a = {95}; op[3089] = getOpcodeTls(a);}
        {char[] a = {126}; op[3090] = getOpcodeTls(a);}
        {int[] a = {3092,3093,3094,3095,3096}; op[3091] = getOpcodeAlt(a);}
        {char[] a = {36}; op[3092] = getOpcodeTls(a);}
        {char[] a = {38}; op[3093] = getOpcodeTls(a);}
        {char[] a = {39}; op[3094] = getOpcodeTls(a);}
        {char[] a = {61}; op[3095] = getOpcodeTls(a);}
        op[3096] = getOpcodeRnm(422, 3097); // other-delims
        {int[] a = {3098,3099,3100,3101,3102,3103,3104}; op[3097] = getOpcodeAlt(a);}
        {char[] a = {33}; op[3098] = getOpcodeTls(a);}
        {char[] a = {40}; op[3099] = getOpcodeTls(a);}
        {char[] a = {41}; op[3100] = getOpcodeTls(a);}
        {char[] a = {42}; op[3101] = getOpcodeTls(a);}
        {char[] a = {43}; op[3102] = getOpcodeTls(a);}
        {char[] a = {44}; op[3103] = getOpcodeTls(a);}
        {char[] a = {59}; op[3104] = getOpcodeTls(a);}
        {int[] a = {3106,3107,3108,3109,3110,3111,3112,3113}; op[3105] = getOpcodeAlt(a);}
        op[3106] = getOpcodeRnm(420, 3084); // unreserved
        op[3107] = getOpcodeRnm(424, 3114); // pct-encoded-no-SQUOTE
        op[3108] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {36}; op[3109] = getOpcodeTls(a);}
        {char[] a = {38}; op[3110] = getOpcodeTls(a);}
        {char[] a = {61}; op[3111] = getOpcodeTls(a);}
        {char[] a = {58}; op[3112] = getOpcodeTls(a);}
        {char[] a = {64}; op[3113] = getOpcodeTls(a);}
        {int[] a = {3115,3128}; op[3114] = getOpcodeAlt(a);}
        {int[] a = {3116,3117,3127}; op[3115] = getOpcodeCat(a);}
        {char[] a = {37}; op[3116] = getOpcodeTls(a);}
        {int[] a = {3118,3119,3120,3121,3122,3123,3124,3125,3126}; op[3117] = getOpcodeAlt(a);}
        {char[] a = {48}; op[3118] = getOpcodeTls(a);}
        {char[] a = {49}; op[3119] = getOpcodeTls(a);}
        {char[] a = {51}; op[3120] = getOpcodeTls(a);}
        {char[] a = {52}; op[3121] = getOpcodeTls(a);}
        {char[] a = {53}; op[3122] = getOpcodeTls(a);}
        {char[] a = {54}; op[3123] = getOpcodeTls(a);}
        {char[] a = {56}; op[3124] = getOpcodeTls(a);}
        {char[] a = {57}; op[3125] = getOpcodeTls(a);}
        op[3126] = getOpcodeRnm(438, 3283); // A-to-F
        op[3127] = getOpcodeRnm(437, 3280); // HEXDIG
        {int[] a = {3129,3130,3131}; op[3128] = getOpcodeCat(a);}
        {char[] a = {37}; op[3129] = getOpcodeTls(a);}
        {char[] a = {50}; op[3130] = getOpcodeTls(a);}
        {int[] a = {3132,3133,3134,3135,3136,3137,3138,3139,3140,3141}; op[3131] = getOpcodeAlt(a);}
        {char[] a = {48}; op[3132] = getOpcodeTls(a);}
        {char[] a = {49}; op[3133] = getOpcodeTls(a);}
        {char[] a = {50}; op[3134] = getOpcodeTls(a);}
        {char[] a = {51}; op[3135] = getOpcodeTls(a);}
        {char[] a = {52}; op[3136] = getOpcodeTls(a);}
        {char[] a = {53}; op[3137] = getOpcodeTls(a);}
        {char[] a = {54}; op[3138] = getOpcodeTls(a);}
        {char[] a = {56}; op[3139] = getOpcodeTls(a);}
        {char[] a = {57}; op[3140] = getOpcodeTls(a);}
        op[3141] = getOpcodeRnm(438, 3283); // A-to-F
        {int[] a = {3143,3144,3145,3146,3147,3148,3149,3150,3151,3152}; op[3142] = getOpcodeAlt(a);}
        op[3143] = getOpcodeRnm(420, 3084); // unreserved
        op[3144] = getOpcodeRnm(419, 3080); // pct-encoded
        op[3145] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {58}; op[3146] = getOpcodeTls(a);}
        {char[] a = {64}; op[3147] = getOpcodeTls(a);}
        {char[] a = {47}; op[3148] = getOpcodeTls(a);}
        {char[] a = {63}; op[3149] = getOpcodeTls(a);}
        {char[] a = {36}; op[3150] = getOpcodeTls(a);}
        {char[] a = {39}; op[3151] = getOpcodeTls(a);}
        {char[] a = {61}; op[3152] = getOpcodeTls(a);}
        {int[] a = {3154,3155,3156,3157,3158,3159,3160,3161,3162}; op[3153] = getOpcodeAlt(a);}
        op[3154] = getOpcodeRnm(420, 3084); // unreserved
        op[3155] = getOpcodeRnm(419, 3080); // pct-encoded
        op[3156] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {58}; op[3157] = getOpcodeTls(a);}
        {char[] a = {64}; op[3158] = getOpcodeTls(a);}
        {char[] a = {47}; op[3159] = getOpcodeTls(a);}
        {char[] a = {63}; op[3160] = getOpcodeTls(a);}
        {char[] a = {36}; op[3161] = getOpcodeTls(a);}
        {char[] a = {39}; op[3162] = getOpcodeTls(a);}
        {int[] a = {3164,3165,3166,3167,3168,3169,3170}; op[3163] = getOpcodeAlt(a);}
        op[3164] = getOpcodeRnm(420, 3084); // unreserved
        op[3165] = getOpcodeRnm(419, 3080); // pct-encoded
        op[3166] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {58}; op[3167] = getOpcodeTls(a);}
        {char[] a = {47}; op[3168] = getOpcodeTls(a);}
        {char[] a = {63}; op[3169] = getOpcodeTls(a);}
        {char[] a = {39}; op[3170] = getOpcodeTls(a);}
        {int[] a = {3172,3173,3174,3175,3176,3177,3178,3179,3180}; op[3171] = getOpcodeAlt(a);}
        op[3172] = getOpcodeRnm(420, 3084); // unreserved
        op[3173] = getOpcodeRnm(419, 3080); // pct-encoded
        op[3174] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {58}; op[3175] = getOpcodeTls(a);}
        {char[] a = {64}; op[3176] = getOpcodeTls(a);}
        {char[] a = {47}; op[3177] = getOpcodeTls(a);}
        {char[] a = {63}; op[3178] = getOpcodeTls(a);}
        {char[] a = {36}; op[3179] = getOpcodeTls(a);}
        {char[] a = {61}; op[3180] = getOpcodeTls(a);}
        {int[] a = {3182,3183,3184,3185,3186,3187,3188,3189,3190,3191}; op[3181] = getOpcodeAlt(a);}
        op[3182] = getOpcodeRnm(420, 3084); // unreserved
        op[3183] = getOpcodeRnm(432, 3241); // pct-encoded-no-DQUOTE
        op[3184] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {58}; op[3185] = getOpcodeTls(a);}
        {char[] a = {64}; op[3186] = getOpcodeTls(a);}
        {char[] a = {47}; op[3187] = getOpcodeTls(a);}
        {char[] a = {63}; op[3188] = getOpcodeTls(a);}
        {char[] a = {36}; op[3189] = getOpcodeTls(a);}
        {char[] a = {39}; op[3190] = getOpcodeTls(a);}
        {char[] a = {61}; op[3191] = getOpcodeTls(a);}
        {int[] a = {3193,3194,3195,3196,3197,3198,3199,3200,3201,3202}; op[3192] = getOpcodeAlt(a);}
        op[3193] = getOpcodeRnm(420, 3084); // unreserved
        op[3194] = getOpcodeRnm(431, 3203); // pct-encoded-unescaped
        op[3195] = getOpcodeRnm(422, 3097); // other-delims
        {char[] a = {58}; op[3196] = getOpcodeTls(a);}
        {char[] a = {64}; op[3197] = getOpcodeTls(a);}
        {char[] a = {47}; op[3198] = getOpcodeTls(a);}
        {char[] a = {63}; op[3199] = getOpcodeTls(a);}
        {char[] a = {36}; op[3200] = getOpcodeTls(a);}
        {char[] a = {39}; op[3201] = getOpcodeTls(a);}
        {char[] a = {61}; op[3202] = getOpcodeTls(a);}
        {int[] a = {3204,3217,3231}; op[3203] = getOpcodeAlt(a);}
        {int[] a = {3205,3206,3216}; op[3204] = getOpcodeCat(a);}
        {char[] a = {37}; op[3205] = getOpcodeTls(a);}
        {int[] a = {3207,3208,3209,3210,3211,3212,3213,3214,3215}; op[3206] = getOpcodeAlt(a);}
        {char[] a = {48}; op[3207] = getOpcodeTls(a);}
        {char[] a = {49}; op[3208] = getOpcodeTls(a);}
        {char[] a = {51}; op[3209] = getOpcodeTls(a);}
        {char[] a = {52}; op[3210] = getOpcodeTls(a);}
        {char[] a = {54}; op[3211] = getOpcodeTls(a);}
        {char[] a = {55}; op[3212] = getOpcodeTls(a);}
        {char[] a = {56}; op[3213] = getOpcodeTls(a);}
        {char[] a = {57}; op[3214] = getOpcodeTls(a);}
        op[3215] = getOpcodeRnm(438, 3283); // A-to-F
        op[3216] = getOpcodeRnm(437, 3280); // HEXDIG
        {int[] a = {3218,3219,3220}; op[3217] = getOpcodeCat(a);}
        {char[] a = {37}; op[3218] = getOpcodeTls(a);}
        {char[] a = {50}; op[3219] = getOpcodeTls(a);}
        {int[] a = {3221,3222,3223,3224,3225,3226,3227,3228,3229,3230}; op[3220] = getOpcodeAlt(a);}
        {char[] a = {48}; op[3221] = getOpcodeTls(a);}
        {char[] a = {49}; op[3222] = getOpcodeTls(a);}
        {char[] a = {51}; op[3223] = getOpcodeTls(a);}
        {char[] a = {52}; op[3224] = getOpcodeTls(a);}
        {char[] a = {53}; op[3225] = getOpcodeTls(a);}
        {char[] a = {54}; op[3226] = getOpcodeTls(a);}
        {char[] a = {55}; op[3227] = getOpcodeTls(a);}
        {char[] a = {56}; op[3228] = getOpcodeTls(a);}
        {char[] a = {57}; op[3229] = getOpcodeTls(a);}
        op[3230] = getOpcodeRnm(438, 3283); // A-to-F
        {int[] a = {3232,3233,3234}; op[3231] = getOpcodeCat(a);}
        {char[] a = {37}; op[3232] = getOpcodeTls(a);}
        {char[] a = {53}; op[3233] = getOpcodeTls(a);}
        {int[] a = {3235,3236,3237,3238,3239,3240}; op[3234] = getOpcodeAlt(a);}
        op[3235] = getOpcodeRnm(436, 3279); // DIGIT
        {char[] a = {65}; op[3236] = getOpcodeTls(a);}
        {char[] a = {66}; op[3237] = getOpcodeTls(a);}
        {char[] a = {68}; op[3238] = getOpcodeTls(a);}
        {char[] a = {69}; op[3239] = getOpcodeTls(a);}
        {char[] a = {70}; op[3240] = getOpcodeTls(a);}
        {int[] a = {3242,3256}; op[3241] = getOpcodeAlt(a);}
        {int[] a = {3243,3244,3255}; op[3242] = getOpcodeCat(a);}
        {char[] a = {37}; op[3243] = getOpcodeTls(a);}
        {int[] a = {3245,3246,3247,3248,3249,3250,3251,3252,3253,3254}; op[3244] = getOpcodeAlt(a);}
        {char[] a = {48}; op[3245] = getOpcodeTls(a);}
        {char[] a = {49}; op[3246] = getOpcodeTls(a);}
        {char[] a = {51}; op[3247] = getOpcodeTls(a);}
        {char[] a = {52}; op[3248] = getOpcodeTls(a);}
        {char[] a = {53}; op[3249] = getOpcodeTls(a);}
        {char[] a = {54}; op[3250] = getOpcodeTls(a);}
        {char[] a = {55}; op[3251] = getOpcodeTls(a);}
        {char[] a = {56}; op[3252] = getOpcodeTls(a);}
        {char[] a = {57}; op[3253] = getOpcodeTls(a);}
        op[3254] = getOpcodeRnm(438, 3283); // A-to-F
        op[3255] = getOpcodeRnm(437, 3280); // HEXDIG
        {int[] a = {3257,3258,3259}; op[3256] = getOpcodeCat(a);}
        {char[] a = {37}; op[3257] = getOpcodeTls(a);}
        {char[] a = {50}; op[3258] = getOpcodeTls(a);}
        {int[] a = {3260,3261,3262,3263,3264,3265,3266,3267,3268,3269}; op[3259] = getOpcodeAlt(a);}
        {char[] a = {48}; op[3260] = getOpcodeTls(a);}
        {char[] a = {49}; op[3261] = getOpcodeTls(a);}
        {char[] a = {51}; op[3262] = getOpcodeTls(a);}
        {char[] a = {52}; op[3263] = getOpcodeTls(a);}
        {char[] a = {53}; op[3264] = getOpcodeTls(a);}
        {char[] a = {54}; op[3265] = getOpcodeTls(a);}
        {char[] a = {55}; op[3266] = getOpcodeTls(a);}
        {char[] a = {56}; op[3267] = getOpcodeTls(a);}
        {char[] a = {57}; op[3268] = getOpcodeTls(a);}
        op[3269] = getOpcodeRnm(438, 3283); // A-to-F
        op[3270] = getOpcodeRep((char)1, Character.MAX_VALUE, 3271);
        {int[] a = {3272,3273}; op[3271] = getOpcodeAlt(a);}
        op[3272] = getOpcodeRnm(442, 3293); // VCHAR
        op[3273] = getOpcodeRnm(379, 2791); // obs-text
        op[3274] = getOpcodeRep((char)1, Character.MAX_VALUE, 3275);
        op[3275] = getOpcodeRnm(425, 3142); // qchar-no-AMP
        {int[] a = {3277,3278}; op[3276] = getOpcodeAlt(a);}
        op[3277] = getOpcodeTrg((char)65, (char)90);
        op[3278] = getOpcodeTrg((char)97, (char)122);
        op[3279] = getOpcodeTrg((char)48, (char)57);
        {int[] a = {3281,3282}; op[3280] = getOpcodeAlt(a);}
        op[3281] = getOpcodeRnm(436, 3279); // DIGIT
        op[3282] = getOpcodeRnm(438, 3283); // A-to-F
        {int[] a = {3284,3285,3286,3287,3288,3289}; op[3283] = getOpcodeAlt(a);}
        {char[] a = {65}; op[3284] = getOpcodeTls(a);}
        {char[] a = {66}; op[3285] = getOpcodeTls(a);}
        {char[] a = {67}; op[3286] = getOpcodeTls(a);}
        {char[] a = {68}; op[3287] = getOpcodeTls(a);}
        {char[] a = {69}; op[3288] = getOpcodeTls(a);}
        {char[] a = {70}; op[3289] = getOpcodeTls(a);}
        {char[] a = {34}; op[3290] = getOpcodeTbs(a);}
        {char[] a = {32}; op[3291] = getOpcodeTbs(a);}
        {char[] a = {9}; op[3292] = getOpcodeTbs(a);}
        op[3293] = getOpcodeTrg((char)33, (char)126);
        {int[] a = {3295,3296,3297}; op[3294] = getOpcodeCat(a);}
        {char[] a = {36,97,112,112,108,121}; op[3295] = getOpcodeTbs(a);}
        op[3296] = getOpcodeRnm(388, 2825); // EQ
        op[3297] = getOpcodeRnm(444, 3298); // applyExpr
        {int[] a = {3299,3300}; op[3298] = getOpcodeCat(a);}
        op[3299] = getOpcodeRnm(445, 3304); // applyTrafo
        op[3300] = getOpcodeRep((char)0, Character.MAX_VALUE, 3301);
        {int[] a = {3302,3303}; op[3301] = getOpcodeCat(a);}
        {char[] a = {47}; op[3302] = getOpcodeTls(a);}
        op[3303] = getOpcodeRnm(445, 3304); // applyTrafo
        {int[] a = {3305,3306,3307,3308,3309,3310,3311,3312,3313,3314,3315,3316,3317,3318,3319}; op[3304] = getOpcodeAlt(a);}
        op[3305] = getOpcodeRnm(446, 3320); // aggregateTrafo
        op[3306] = getOpcodeRnm(461, 3457); // bottomcountTrafo
        op[3307] = getOpcodeRnm(462, 3468); // bottompercentTrafo
        op[3308] = getOpcodeRnm(463, 3479); // bottomsumTrafo
        op[3309] = getOpcodeRnm(459, 3441); // computeTrafo
        op[3310] = getOpcodeRnm(464, 3490); // concatTrafo
        op[3311] = getOpcodeRnm(465, 3503); // expandTrafo
        op[3312] = getOpcodeRnm(467, 3552); // filterTrafo
        op[3313] = getOpcodeRnm(469, 3566); // groupbyTrafo
        op[3314] = getOpcodeRnm(473, 3609); // identityTrafo
        op[3315] = getOpcodeRnm(468, 3559); // searchTrafo
        op[3316] = getOpcodeRnm(474, 3610); // topcountTrafo
        op[3317] = getOpcodeRnm(475, 3621); // toppercentTrafo
        op[3318] = getOpcodeRnm(476, 3632); // topsumTrafo
        op[3319] = getOpcodeRnm(477, 3643); // customFunction
        {int[] a = {3321,3322,3323,3324,3325,3331,3332}; op[3320] = getOpcodeCat(a);}
        {char[] a = {97,103,103,114,101,103,97,116,101}; op[3321] = getOpcodeTbs(a);}
        op[3322] = getOpcodeRnm(394, 2840); // OPEN
        op[3323] = getOpcodeRnm(384, 2810); // BWS
        op[3324] = getOpcodeRnm(447, 3333); // aggregateItem
        op[3325] = getOpcodeRep((char)0, Character.MAX_VALUE, 3326);
        {int[] a = {3327,3328,3329,3330}; op[3326] = getOpcodeCat(a);}
        op[3327] = getOpcodeRnm(384, 2810); // BWS
        op[3328] = getOpcodeRnm(387, 2822); // COMMA
        op[3329] = getOpcodeRnm(384, 2810); // BWS
        op[3330] = getOpcodeRnm(447, 3333); // aggregateItem
        op[3331] = getOpcodeRnm(384, 2810); // BWS
        op[3332] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3334,3337}; op[3333] = getOpcodeAlt(a);}
        {int[] a = {3335,3336}; op[3334] = getOpcodeCat(a);}
        {char[] a = {36,99,111,117,110,116}; op[3335] = getOpcodeTbs(a);}
        op[3336] = getOpcodeRnm(453, 3397); // asAlias
        op[3337] = getOpcodeRnm(448, 3338); // aggregateExpr
        {int[] a = {3339,3345,3352,3359}; op[3338] = getOpcodeAlt(a);}
        {int[] a = {3340,3341,3342,3344}; op[3339] = getOpcodeCat(a);}
        op[3340] = getOpcodeRnm(126, 1067); // commonExpr
        op[3341] = getOpcodeRnm(449, 3365); // aggregateWith
        op[3342] = getOpcodeRep((char)0, (char)1, 3343);
        op[3343] = getOpcodeRnm(450, 3370); // aggregateFrom
        op[3344] = getOpcodeRnm(453, 3397); // asAlias
        {int[] a = {3346,3347,3348,3349,3351}; op[3345] = getOpcodeCat(a);}
        op[3346] = getOpcodeRnm(457, 3415); // pathPrefix
        op[3347] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[3348] = getOpcodeRnm(449, 3365); // aggregateWith
        op[3349] = getOpcodeRep((char)0, (char)1, 3350);
        op[3350] = getOpcodeRnm(450, 3370); // aggregateFrom
        op[3351] = getOpcodeRnm(453, 3397); // asAlias
        {int[] a = {3353,3354,3355}; op[3352] = getOpcodeCat(a);}
        op[3353] = getOpcodeRnm(457, 3415); // pathPrefix
        op[3354] = getOpcodeRnm(455, 3403); // customAggregate
        op[3355] = getOpcodeRep((char)0, (char)1, 3356);
        {int[] a = {3357,3358}; op[3356] = getOpcodeCat(a);}
        op[3357] = getOpcodeRnm(451, 3378); // customFrom
        op[3358] = getOpcodeRnm(453, 3397); // asAlias
        {int[] a = {3360,3361,3362,3363,3364}; op[3359] = getOpcodeCat(a);}
        op[3360] = getOpcodeRnm(457, 3415); // pathPrefix
        op[3361] = getOpcodeRnm(458, 3426); // pathSegment
        op[3362] = getOpcodeRnm(394, 2840); // OPEN
        op[3363] = getOpcodeRnm(448, 3338); // aggregateExpr
        op[3364] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3366,3367,3368,3369}; op[3365] = getOpcodeCat(a);}
        op[3366] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {119,105,116,104}; op[3367] = getOpcodeTbs(a);}
        op[3368] = getOpcodeRnm(383, 2804); // RWS
        op[3369] = getOpcodeRnm(452, 3387); // aggregateMethod
        {int[] a = {3371,3372,3373,3374,3375,3376}; op[3370] = getOpcodeCat(a);}
        op[3371] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {102,114,111,109}; op[3372] = getOpcodeTbs(a);}
        op[3373] = getOpcodeRnm(383, 2804); // RWS
        op[3374] = getOpcodeRnm(456, 3404); // groupingProperty
        op[3375] = getOpcodeRnm(449, 3365); // aggregateWith
        op[3376] = getOpcodeRep((char)0, (char)1, 3377);
        op[3377] = getOpcodeRnm(450, 3370); // aggregateFrom
        {int[] a = {3379,3380,3381,3382,3383,3385}; op[3378] = getOpcodeCat(a);}
        op[3379] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {102,114,111,109}; op[3380] = getOpcodeTbs(a);}
        op[3381] = getOpcodeRnm(383, 2804); // RWS
        op[3382] = getOpcodeRnm(456, 3404); // groupingProperty
        op[3383] = getOpcodeRep((char)0, (char)1, 3384);
        op[3384] = getOpcodeRnm(449, 3365); // aggregateWith
        op[3385] = getOpcodeRep((char)0, (char)1, 3386);
        op[3386] = getOpcodeRnm(451, 3378); // customFrom
        {int[] a = {3388,3389,3390,3391,3392,3393}; op[3387] = getOpcodeAlt(a);}
        {char[] a = {115,117,109}; op[3388] = getOpcodeTbs(a);}
        {char[] a = {109,105,110}; op[3389] = getOpcodeTbs(a);}
        {char[] a = {109,97,120}; op[3390] = getOpcodeTbs(a);}
        {char[] a = {97,118,101,114,97,103,101}; op[3391] = getOpcodeTbs(a);}
        {char[] a = {99,111,117,110,116,100,105,115,116,105,110,99,116}; op[3392] = getOpcodeTbs(a);}
        {int[] a = {3394,3395,3396}; op[3393] = getOpcodeCat(a);}
        op[3394] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[3395] = getOpcodeTls(a);}
        op[3396] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {3398,3399,3400,3401}; op[3397] = getOpcodeCat(a);}
        op[3398] = getOpcodeRnm(383, 2804); // RWS
        {char[] a = {97,115}; op[3399] = getOpcodeTbs(a);}
        op[3400] = getOpcodeRnm(383, 2804); // RWS
        op[3401] = getOpcodeRnm(454, 3402); // expressionAlias
        op[3402] = getOpcodeRnm(248, 1993); // odataIdentifier
        op[3403] = getOpcodeRnm(248, 1993); // odataIdentifier
        {int[] a = {3405,3406}; op[3404] = getOpcodeCat(a);}
        op[3405] = getOpcodeRnm(457, 3415); // pathPrefix
        {int[] a = {3407,3413,3414}; op[3406] = getOpcodeAlt(a);}
        {int[] a = {3408,3409}; op[3407] = getOpcodeCat(a);}
        op[3408] = getOpcodeRnm(262, 2053); // entityNavigationProperty
        op[3409] = getOpcodeRep((char)0, (char)1, 3410);
        {int[] a = {3411,3412}; op[3410] = getOpcodeCat(a);}
        {char[] a = {47}; op[3411] = getOpcodeTls(a);}
        op[3412] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[3413] = getOpcodeRnm(254, 2039); // primitiveProperty
        op[3414] = getOpcodeRnm(258, 2047); // complexProperty
        {int[] a = {3416,3422}; op[3415] = getOpcodeCat(a);}
        op[3416] = getOpcodeRep((char)0, (char)1, 3417);
        {int[] a = {3418,3421}; op[3417] = getOpcodeCat(a);}
        {int[] a = {3419,3420}; op[3418] = getOpcodeAlt(a);}
        op[3419] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[3420] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {char[] a = {47}; op[3421] = getOpcodeTls(a);}
        op[3422] = getOpcodeRep((char)0, Character.MAX_VALUE, 3423);
        {int[] a = {3424,3425}; op[3423] = getOpcodeCat(a);}
        op[3424] = getOpcodeRnm(458, 3426); // pathSegment
        {char[] a = {47}; op[3425] = getOpcodeTls(a);}
        {int[] a = {3427,3435}; op[3426] = getOpcodeAlt(a);}
        {int[] a = {3428,3431}; op[3427] = getOpcodeCat(a);}
        {int[] a = {3429,3430}; op[3428] = getOpcodeAlt(a);}
        op[3429] = getOpcodeRnm(258, 2047); // complexProperty
        op[3430] = getOpcodeRnm(259, 2048); // complexColProperty
        op[3431] = getOpcodeRep((char)0, (char)1, 3432);
        {int[] a = {3433,3434}; op[3432] = getOpcodeCat(a);}
        {char[] a = {47}; op[3433] = getOpcodeTls(a);}
        op[3434] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {int[] a = {3436,3437}; op[3435] = getOpcodeCat(a);}
        op[3436] = getOpcodeRnm(261, 2050); // navigationProperty
        op[3437] = getOpcodeRep((char)0, (char)1, 3438);
        {int[] a = {3439,3440}; op[3438] = getOpcodeCat(a);}
        {char[] a = {47}; op[3439] = getOpcodeTls(a);}
        op[3440] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        {int[] a = {3442,3443,3444,3445,3446,3452,3453}; op[3441] = getOpcodeCat(a);}
        {char[] a = {99,111,109,112,117,116,101}; op[3442] = getOpcodeTbs(a);}
        op[3443] = getOpcodeRnm(394, 2840); // OPEN
        op[3444] = getOpcodeRnm(384, 2810); // BWS
        op[3445] = getOpcodeRnm(460, 3454); // computeExpr
        op[3446] = getOpcodeRep((char)0, Character.MAX_VALUE, 3447);
        {int[] a = {3448,3449,3450,3451}; op[3447] = getOpcodeCat(a);}
        op[3448] = getOpcodeRnm(384, 2810); // BWS
        op[3449] = getOpcodeRnm(387, 2822); // COMMA
        op[3450] = getOpcodeRnm(384, 2810); // BWS
        op[3451] = getOpcodeRnm(460, 3454); // computeExpr
        op[3452] = getOpcodeRnm(384, 2810); // BWS
        op[3453] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3455,3456}; op[3454] = getOpcodeCat(a);}
        op[3455] = getOpcodeRnm(126, 1067); // commonExpr
        op[3456] = getOpcodeRnm(453, 3397); // asAlias
        {int[] a = {3458,3459,3460,3461,3462,3463,3464,3465,3466,3467}; op[3457] = getOpcodeCat(a);}
        {char[] a = {98,111,116,116,111,109,99,111,117,110,116}; op[3458] = getOpcodeTbs(a);}
        op[3459] = getOpcodeRnm(394, 2840); // OPEN
        op[3460] = getOpcodeRnm(384, 2810); // BWS
        op[3461] = getOpcodeRnm(126, 1067); // commonExpr
        op[3462] = getOpcodeRnm(384, 2810); // BWS
        op[3463] = getOpcodeRnm(387, 2822); // COMMA
        op[3464] = getOpcodeRnm(384, 2810); // BWS
        op[3465] = getOpcodeRnm(126, 1067); // commonExpr
        op[3466] = getOpcodeRnm(384, 2810); // BWS
        op[3467] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3469,3470,3471,3472,3473,3474,3475,3476,3477,3478}; op[3468] = getOpcodeCat(a);}
        {char[] a = {98,111,116,116,111,109,112,101,114,99,101,110,116}; op[3469] = getOpcodeTbs(a);}
        op[3470] = getOpcodeRnm(394, 2840); // OPEN
        op[3471] = getOpcodeRnm(384, 2810); // BWS
        op[3472] = getOpcodeRnm(126, 1067); // commonExpr
        op[3473] = getOpcodeRnm(384, 2810); // BWS
        op[3474] = getOpcodeRnm(387, 2822); // COMMA
        op[3475] = getOpcodeRnm(384, 2810); // BWS
        op[3476] = getOpcodeRnm(126, 1067); // commonExpr
        op[3477] = getOpcodeRnm(384, 2810); // BWS
        op[3478] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3480,3481,3482,3483,3484,3485,3486,3487,3488,3489}; op[3479] = getOpcodeCat(a);}
        {char[] a = {98,111,116,116,111,109,115,117,109}; op[3480] = getOpcodeTbs(a);}
        op[3481] = getOpcodeRnm(394, 2840); // OPEN
        op[3482] = getOpcodeRnm(384, 2810); // BWS
        op[3483] = getOpcodeRnm(126, 1067); // commonExpr
        op[3484] = getOpcodeRnm(384, 2810); // BWS
        op[3485] = getOpcodeRnm(387, 2822); // COMMA
        op[3486] = getOpcodeRnm(384, 2810); // BWS
        op[3487] = getOpcodeRnm(126, 1067); // commonExpr
        op[3488] = getOpcodeRnm(384, 2810); // BWS
        op[3489] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3491,3492,3493,3494,3495,3501,3502}; op[3490] = getOpcodeCat(a);}
        {char[] a = {99,111,110,99,97,116}; op[3491] = getOpcodeTbs(a);}
        op[3492] = getOpcodeRnm(394, 2840); // OPEN
        op[3493] = getOpcodeRnm(384, 2810); // BWS
        op[3494] = getOpcodeRnm(444, 3298); // applyExpr
        op[3495] = getOpcodeRep((char)1, Character.MAX_VALUE, 3496);
        {int[] a = {3497,3498,3499,3500}; op[3496] = getOpcodeCat(a);}
        op[3497] = getOpcodeRnm(384, 2810); // BWS
        op[3498] = getOpcodeRnm(387, 2822); // COMMA
        op[3499] = getOpcodeRnm(384, 2810); // BWS
        op[3500] = getOpcodeRnm(444, 3298); // applyExpr
        op[3501] = getOpcodeRnm(384, 2810); // BWS
        op[3502] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3504,3505,3506,3507,3508,3509,3510,3511,3528,3529}; op[3503] = getOpcodeCat(a);}
        {char[] a = {101,120,112,97,110,100}; op[3504] = getOpcodeTbs(a);}
        op[3505] = getOpcodeRnm(394, 2840); // OPEN
        op[3506] = getOpcodeRnm(384, 2810); // BWS
        op[3507] = getOpcodeRnm(466, 3530); // expandNavPath
        op[3508] = getOpcodeRnm(384, 2810); // BWS
        op[3509] = getOpcodeRnm(387, 2822); // COMMA
        op[3510] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {3512,3520}; op[3511] = getOpcodeAlt(a);}
        {int[] a = {3513,3514}; op[3512] = getOpcodeCat(a);}
        op[3513] = getOpcodeRnm(465, 3503); // expandTrafo
        op[3514] = getOpcodeRep((char)0, Character.MAX_VALUE, 3515);
        {int[] a = {3516,3517,3518,3519}; op[3515] = getOpcodeCat(a);}
        op[3516] = getOpcodeRnm(384, 2810); // BWS
        op[3517] = getOpcodeRnm(387, 2822); // COMMA
        op[3518] = getOpcodeRnm(384, 2810); // BWS
        op[3519] = getOpcodeRnm(465, 3503); // expandTrafo
        {int[] a = {3521,3522}; op[3520] = getOpcodeCat(a);}
        op[3521] = getOpcodeRnm(467, 3552); // filterTrafo
        op[3522] = getOpcodeRep((char)0, Character.MAX_VALUE, 3523);
        {int[] a = {3524,3525,3526,3527}; op[3523] = getOpcodeCat(a);}
        op[3524] = getOpcodeRnm(384, 2810); // BWS
        op[3525] = getOpcodeRnm(387, 2822); // COMMA
        op[3526] = getOpcodeRnm(384, 2810); // BWS
        op[3527] = getOpcodeRnm(465, 3503); // expandTrafo
        op[3528] = getOpcodeRnm(384, 2810); // BWS
        op[3529] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3531,3537,3547,3548}; op[3530] = getOpcodeCat(a);}
        op[3531] = getOpcodeRep((char)0, (char)1, 3532);
        {int[] a = {3533,3536}; op[3532] = getOpcodeCat(a);}
        {int[] a = {3534,3535}; op[3533] = getOpcodeAlt(a);}
        op[3534] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        op[3535] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {char[] a = {47}; op[3536] = getOpcodeTls(a);}
        op[3537] = getOpcodeRep((char)0, Character.MAX_VALUE, 3538);
        {int[] a = {3539,3542,3543}; op[3538] = getOpcodeCat(a);}
        {int[] a = {3540,3541}; op[3539] = getOpcodeAlt(a);}
        op[3540] = getOpcodeRnm(258, 2047); // complexProperty
        op[3541] = getOpcodeRnm(259, 2048); // complexColProperty
        {char[] a = {47}; op[3542] = getOpcodeTls(a);}
        op[3543] = getOpcodeRep((char)0, (char)1, 3544);
        {int[] a = {3545,3546}; op[3544] = getOpcodeCat(a);}
        op[3545] = getOpcodeRnm(233, 1954); // qualifiedComplexTypeName
        {char[] a = {47}; op[3546] = getOpcodeTls(a);}
        op[3547] = getOpcodeRnm(261, 2050); // navigationProperty
        op[3548] = getOpcodeRep((char)0, (char)1, 3549);
        {int[] a = {3550,3551}; op[3549] = getOpcodeCat(a);}
        {char[] a = {47}; op[3550] = getOpcodeTls(a);}
        op[3551] = getOpcodeRnm(232, 1950); // qualifiedEntityTypeName
        {int[] a = {3553,3554,3555,3556,3557,3558}; op[3552] = getOpcodeCat(a);}
        {char[] a = {102,105,108,116,101,114}; op[3553] = getOpcodeTbs(a);}
        op[3554] = getOpcodeRnm(394, 2840); // OPEN
        op[3555] = getOpcodeRnm(384, 2810); // BWS
        op[3556] = getOpcodeRnm(127, 1102); // boolCommonExpr
        op[3557] = getOpcodeRnm(384, 2810); // BWS
        op[3558] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3560,3561,3562,3563,3564,3565}; op[3559] = getOpcodeCat(a);}
        {char[] a = {115,101,97,114,99,104}; op[3560] = getOpcodeTbs(a);}
        op[3561] = getOpcodeRnm(394, 2840); // OPEN
        op[3562] = getOpcodeRnm(384, 2810); // BWS
        op[3563] = getOpcodeRnm(82, 709); // searchExpr
        op[3564] = getOpcodeRnm(384, 2810); // BWS
        op[3565] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3567,3568,3569,3570,3571,3577,3578}; op[3566] = getOpcodeCat(a);}
        {char[] a = {103,114,111,117,112,98,121}; op[3567] = getOpcodeTbs(a);}
        op[3568] = getOpcodeRnm(394, 2840); // OPEN
        op[3569] = getOpcodeRnm(384, 2810); // BWS
        op[3570] = getOpcodeRnm(470, 3579); // groupbyList
        op[3571] = getOpcodeRep((char)0, (char)1, 3572);
        {int[] a = {3573,3574,3575,3576}; op[3572] = getOpcodeCat(a);}
        op[3573] = getOpcodeRnm(384, 2810); // BWS
        op[3574] = getOpcodeRnm(387, 2822); // COMMA
        op[3575] = getOpcodeRnm(384, 2810); // BWS
        op[3576] = getOpcodeRnm(444, 3298); // applyExpr
        op[3577] = getOpcodeRnm(384, 2810); // BWS
        op[3578] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3580,3581,3582,3583,3589,3590}; op[3579] = getOpcodeCat(a);}
        op[3580] = getOpcodeRnm(394, 2840); // OPEN
        op[3581] = getOpcodeRnm(384, 2810); // BWS
        op[3582] = getOpcodeRnm(471, 3591); // groupbyElement
        op[3583] = getOpcodeRep((char)0, Character.MAX_VALUE, 3584);
        {int[] a = {3585,3586,3587,3588}; op[3584] = getOpcodeCat(a);}
        op[3585] = getOpcodeRnm(384, 2810); // BWS
        op[3586] = getOpcodeRnm(387, 2822); // COMMA
        op[3587] = getOpcodeRnm(384, 2810); // BWS
        op[3588] = getOpcodeRnm(471, 3591); // groupbyElement
        op[3589] = getOpcodeRnm(384, 2810); // BWS
        op[3590] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3592,3593}; op[3591] = getOpcodeAlt(a);}
        op[3592] = getOpcodeRnm(456, 3404); // groupingProperty
        op[3593] = getOpcodeRnm(472, 3594); // rollupSpec
        {int[] a = {3595,3596,3597,3598,3601,3607,3608}; op[3594] = getOpcodeCat(a);}
        {char[] a = {114,111,108,108,117,112}; op[3595] = getOpcodeTbs(a);}
        op[3596] = getOpcodeRnm(394, 2840); // OPEN
        op[3597] = getOpcodeRnm(384, 2810); // BWS
        {int[] a = {3599,3600}; op[3598] = getOpcodeAlt(a);}
        {char[] a = {36,97,108,108}; op[3599] = getOpcodeTbs(a);}
        op[3600] = getOpcodeRnm(456, 3404); // groupingProperty
        op[3601] = getOpcodeRep((char)1, Character.MAX_VALUE, 3602);
        {int[] a = {3603,3604,3605,3606}; op[3602] = getOpcodeCat(a);}
        op[3603] = getOpcodeRnm(384, 2810); // BWS
        op[3604] = getOpcodeRnm(387, 2822); // COMMA
        op[3605] = getOpcodeRnm(384, 2810); // BWS
        op[3606] = getOpcodeRnm(456, 3404); // groupingProperty
        op[3607] = getOpcodeRnm(384, 2810); // BWS
        op[3608] = getOpcodeRnm(395, 2843); // CLOSE
        {char[] a = {105,100,101,110,116,105,116,121}; op[3609] = getOpcodeTbs(a);}
        {int[] a = {3611,3612,3613,3614,3615,3616,3617,3618,3619,3620}; op[3610] = getOpcodeCat(a);}
        {char[] a = {116,111,112,99,111,117,110,116}; op[3611] = getOpcodeTbs(a);}
        op[3612] = getOpcodeRnm(394, 2840); // OPEN
        op[3613] = getOpcodeRnm(384, 2810); // BWS
        op[3614] = getOpcodeRnm(126, 1067); // commonExpr
        op[3615] = getOpcodeRnm(384, 2810); // BWS
        op[3616] = getOpcodeRnm(387, 2822); // COMMA
        op[3617] = getOpcodeRnm(384, 2810); // BWS
        op[3618] = getOpcodeRnm(126, 1067); // commonExpr
        op[3619] = getOpcodeRnm(384, 2810); // BWS
        op[3620] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3622,3623,3624,3625,3626,3627,3628,3629,3630,3631}; op[3621] = getOpcodeCat(a);}
        {char[] a = {116,111,112,112,101,114,99,101,110,116}; op[3622] = getOpcodeTbs(a);}
        op[3623] = getOpcodeRnm(394, 2840); // OPEN
        op[3624] = getOpcodeRnm(384, 2810); // BWS
        op[3625] = getOpcodeRnm(126, 1067); // commonExpr
        op[3626] = getOpcodeRnm(384, 2810); // BWS
        op[3627] = getOpcodeRnm(387, 2822); // COMMA
        op[3628] = getOpcodeRnm(384, 2810); // BWS
        op[3629] = getOpcodeRnm(126, 1067); // commonExpr
        op[3630] = getOpcodeRnm(384, 2810); // BWS
        op[3631] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3633,3634,3635,3636,3637,3638,3639,3640,3641,3642}; op[3632] = getOpcodeCat(a);}
        {char[] a = {116,111,112,115,117,109}; op[3633] = getOpcodeTbs(a);}
        op[3634] = getOpcodeRnm(394, 2840); // OPEN
        op[3635] = getOpcodeRnm(384, 2810); // BWS
        op[3636] = getOpcodeRnm(126, 1067); // commonExpr
        op[3637] = getOpcodeRnm(384, 2810); // BWS
        op[3638] = getOpcodeRnm(387, 2822); // COMMA
        op[3639] = getOpcodeRnm(384, 2810); // BWS
        op[3640] = getOpcodeRnm(126, 1067); // commonExpr
        op[3641] = getOpcodeRnm(384, 2810); // BWS
        op[3642] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3644,3645,3646,3650}; op[3643] = getOpcodeCat(a);}
        op[3644] = getOpcodeRnm(238, 1978); // namespace
        {char[] a = {46}; op[3645] = getOpcodeTls(a);}
        {int[] a = {3647,3648,3649}; op[3646] = getOpcodeAlt(a);}
        op[3647] = getOpcodeRnm(268, 2065); // entityColFunction
        op[3648] = getOpcodeRnm(270, 2067); // complexColFunction
        op[3649] = getOpcodeRnm(272, 2069); // primitiveColFunction
        op[3650] = getOpcodeRnm(149, 1312); // functionExprParameters
        {int[] a = {3652,3653,3654,3655,3656,3657}; op[3651] = getOpcodeCat(a);}
        {char[] a = {105,115,100,101,102,105,110,101,100}; op[3652] = getOpcodeTbs(a);}
        op[3653] = getOpcodeRnm(394, 2840); // OPEN
        op[3654] = getOpcodeRnm(384, 2810); // BWS
        op[3655] = getOpcodeRnm(129, 1112); // firstMemberExpr
        op[3656] = getOpcodeRnm(384, 2810); // BWS
        op[3657] = getOpcodeRnm(395, 2843); // CLOSE
        {int[] a = {3659,3660,3661,3662,3663,3664}; op[3658] = getOpcodeAlt(a);}
        op[3659] = getOpcodeRnm(480, 3665); // at-option
        op[3660] = getOpcodeRnm(481, 3669); // from
        op[3661] = getOpcodeRnm(482, 3673); // to
        op[3662] = getOpcodeRnm(483, 3677); // systemat
        op[3663] = getOpcodeRnm(484, 3681); // systemfrom
        op[3664] = getOpcodeRnm(485, 3685); // systemto
        {int[] a = {3666,3667,3668}; op[3665] = getOpcodeCat(a);}
        {char[] a = {36,97,116}; op[3666] = getOpcodeTbs(a);}
        op[3667] = getOpcodeRnm(388, 2825); // EQ
        op[3668] = getOpcodeRnm(486, 3689); // temporalExpr
        {int[] a = {3670,3671,3672}; op[3669] = getOpcodeCat(a);}
        {char[] a = {36,102,114,111,109}; op[3670] = getOpcodeTbs(a);}
        op[3671] = getOpcodeRnm(388, 2825); // EQ
        op[3672] = getOpcodeRnm(486, 3689); // temporalExpr
        {int[] a = {3674,3675,3676}; op[3673] = getOpcodeCat(a);}
        {char[] a = {36,116,111}; op[3674] = getOpcodeTbs(a);}
        op[3675] = getOpcodeRnm(388, 2825); // EQ
        op[3676] = getOpcodeRnm(486, 3689); // temporalExpr
        {int[] a = {3678,3679,3680}; op[3677] = getOpcodeCat(a);}
        {char[] a = {36,115,121,115,116,101,109,97,116}; op[3678] = getOpcodeTbs(a);}
        op[3679] = getOpcodeRnm(388, 2825); // EQ
        op[3680] = getOpcodeRnm(486, 3689); // temporalExpr
        {int[] a = {3682,3683,3684}; op[3681] = getOpcodeCat(a);}
        {char[] a = {36,115,121,115,116,101,109,102,114,111,109}; op[3682] = getOpcodeTbs(a);}
        op[3683] = getOpcodeRnm(388, 2825); // EQ
        op[3684] = getOpcodeRnm(486, 3689); // temporalExpr
        {int[] a = {3686,3687,3688}; op[3685] = getOpcodeCat(a);}
        {char[] a = {36,115,121,115,116,101,109,116,111}; op[3686] = getOpcodeTbs(a);}
        op[3687] = getOpcodeRnm(388, 2825); // EQ
        op[3688] = getOpcodeRnm(486, 3689); // temporalExpr
        {int[] a = {3690,3691,3692,3693}; op[3689] = getOpcodeAlt(a);}
        {char[] a = {109,105,110}; op[3690] = getOpcodeTbs(a);}
        {char[] a = {109,97,120}; op[3691] = getOpcodeTbs(a);}
        op[3692] = getOpcodeRnm(301, 2264); // dateTimeOffsetValue
        op[3693] = getOpcodeRnm(300, 2258); // dateValue
    }

    public static void display(PrintStream out){
        out.println(";");
        out.println("; grammar.GrammarUnderTest");
        out.println(";");
        out.println(";------------------------------------------------------------------------------");
        out.println("; OData ABNF Construction Rules Version 4.01 and 4.0");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 05 November 2019");
        out.println(";------------------------------------------------------------------------------");
        out.println(";");
        out.println("; Technical Committee:");
        out.println(";   OASIS Open Data Protocol (OData) TC");
        out.println(";   https://www.oasis-open.org/committees/odata");
        out.println(";");
        out.println("; Chairs:");
        out.println(";   - Ralf Handl (ralf.handl@sap.com), SAP SE");
        out.println(";   - Michael Pizzo (mikep@microsoft.com), Microsoft");
        out.println(";");
        out.println("; Editors:");
        out.println(";   - Ralf Handl (ralf.handl@sap.com), SAP SE");
        out.println(";   - Michael Pizzo (mikep@microsoft.com), Microsoft");
        out.println(";   - Martin Zurmuehl (martin.zurmuehl@sap.com), SAP SE");
        out.println(";");
        out.println("; Additional artifacts: ");
        out.println(";   This grammar is one component of a Work Product which consists of:");
        out.println(";   - OData Version 4.01 Part 1: Protocol");
        out.println(";   - OData Version 4.01 Part 2: URL Conventions");
        out.println(";   - OData ABNF Construction Rules Version 4.01 (this document)");
        out.println(";   - OData ABNF Test Cases Version 4.01");
        out.println(";");
        out.println("; Related work:");
        out.println(";   This specification replaces or supersedes:");
        out.println(";   - OData ABNF Construction Rules Version 4.0");
        out.println(";   This work product is related to");
        out.println(";   - OData Common Schema Definition Language (CSDL) JSON Representation Version 4.01");
        out.println(";   - OData Common Schema Definition Language (CSDL) XML Representation Version 4.01");
        out.println(";   - OData JSON Format Version 4.01");
        out.println(";");
        out.println("; Abstract:");
        out.println(";   The Open Data Protocol (OData) enables the creation of REST-based data");
        out.println(";   services, which allow resources, identified using Uniform Resource");
        out.println(";   Identifiers (URLs) and defined in a data model, to be published and ");
        out.println(";   edited by Web clients using simple HTTP messages. This document defines");
        out.println(";   the URL syntax for requests and the serialization format for primitive ");
        out.println(";   literals in request and response payloads.");
        out.println(";");
        out.println("; Overview:");
        out.println(";   This grammar uses the ABNF defined in RFC5234 with one extension: literals ");
        out.println(";   enclosed in single quotes (e.g. '$metadata') are treated case-sensitive. ");
        out.println(";");
        out.println(";   The following rules assume that URIs have been percent-encoding normalized");
        out.println(";   as described in section 6.2.2.2 of RFC3986 ");
        out.println(";   (http://tools.ietf.org/html/rfc3986#section-6.2.2.2)");
        out.println(";   before applying the grammar to them, i.e. all characters in the unreserved ");
        out.println(";   set (see rule \"unreserved\" below) are plain literals and NOT");
        out.println(";   percent-encoded. ");
        out.println(";");
        out.println(";   For characters outside the unreserved set the rules explicitly state ");
        out.println(";   whether the percent-encoded representation is treated identical to the");
        out.println(";   plain literal representation.");
        out.println("; ");
        out.println(";   One prominent example is the single quote that delimits OData primitive  ");
        out.println(";   type literals: %27 and ' are treated identically, so a single quote within ");
        out.println(";   a string literal is \"encoded\" as two consecutive single quotes in either");
        out.println(";   literal or percent-encoded representation.");
        out.println(";");
        out.println("; Contents:");
        out.println(";   1. Resource Path");
        out.println(";   2. Query Options");
        out.println(";   3. Context URL Fragments");
        out.println(";   4. Expressions");
        out.println(";   5. JSON format for function parameters");
        out.println(";   6. Names and identifiers");
        out.println(";   7. Literal Data Values");
        out.println(";   8. Header values");
        out.println(";   9. Punctuation");
        out.println(";");
        out.println(";   A. URI syntax [RFC3986]");
        out.println(";   B. IRI syntax [RFC3986]");
        out.println(";   C. ABNF core definitions [RFC5234]");
        out.println(";");
        out.println(";------------------------------------------------------------------------------");
        out.println("dummyStartRule = odataUri / header / primitiveValue ; just to please the test parser");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("");
        out.println("odataUri = serviceRoot [ odataRelativeUri ]  ");
        out.println("");
        out.println("serviceRoot = ( \"https\" / \"http\" )                    ; Note: case-insensitive ");
        out.println("              \"://\" host [ \":\" port ]");
        out.println("              \"/\" *( segment-nz \"/\" )");
        out.println("");
        out.println("; Note: dollar-prefixed path segments are case-sensitive!");
        out.println("odataRelativeUri = '$batch'  [ \"?\" batchOptions ]");
        out.println("                 / '$entity' \"?\" entityOptions  ");
        out.println("                 / '$entity' \"/\" optionallyQualifiedEntityTypeName \"?\" entityCastOptions  ");
        out.println("                 / '$metadata' [ \"?\" metadataOptions ] [ context ]");
        out.println("                 / resourcePath [ \"?\" queryOptions ]");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 1. Resource Path");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("resourcePath = entitySetName                  [ collectionNavigation ] ");
        out.println("             / singletonEntity                [ singleNavigation ]");
        out.println("             / actionImportCall ");
        out.println("             / entityColFunctionImportCall    [ collectionNavigation ] ");
        out.println("             / entityFunctionImportCall       [ singleNavigation ] ");
        out.println("             / complexColFunctionImportCall   [ complexColPath ] ");
        out.println("             / complexFunctionImportCall      [ complexPath ] ");
        out.println("             / primitiveColFunctionImportCall [ primitiveColPath ] ");
        out.println("             / primitiveFunctionImportCall    [ primitivePath ] ");
        out.println("             / functionImportCallNoParens     [ querySegment ]");
        out.println("             / crossjoin                      [ querySegment ]");
        out.println("             / '$all'                         [ \"/\" optionallyQualifiedEntityTypeName ]");
        out.println("");
        out.println("collectionNavigation = [ \"/\" optionallyQualifiedEntityTypeName ] [ collectionNavPath ]");
        out.println("collectionNavPath    = keyPredicate [ singleNavigation ]");
        out.println("                     / filterInPath [ collectionNavigation ]");
        out.println("                     / each [ boundOperation ]");
        out.println("                     / boundOperation");
        out.println("                     / count");
        out.println("                     / ref");
        out.println("                     / querySegment");
        out.println("");
        out.println("keyPredicate     = simpleKey / compoundKey / keyPathSegments");
        out.println("simpleKey        = OPEN ( parameterAlias / keyPropertyValue ) CLOSE");
        out.println("compoundKey      = OPEN keyValuePair *( COMMA keyValuePair ) CLOSE");
        out.println("keyValuePair     = ( primitiveKeyProperty / keyPropertyAlias  ) EQ ( parameterAlias / keyPropertyValue )");
        out.println("keyPropertyValue = primitiveLiteral");
        out.println("keyPropertyAlias = odataIdentifier");
        out.println("keyPathSegments  = 1*( \"/\" keyPathLiteral )");
        out.println("keyPathLiteral   = *pchar");
        out.println("");
        out.println("singleNavigation = [ \"/\" optionallyQualifiedEntityTypeName ] ");
        out.println("                   [ \"/\" propertyPath");
        out.println("                   / boundOperation");
        out.println("                   / ref ");
        out.println("                   / value  ; request the media resource of a media entity ");
        out.println("                   / querySegment");
        out.println("                   ]");
        out.println("");
        out.println("propertyPath = entityColNavigationProperty [ collectionNavigation ]");
        out.println("             / entityNavigationProperty    [ singleNavigation ]");
        out.println("             / complexColProperty          [ complexColPath ]");
        out.println("             / complexProperty             [ complexPath ]");
        out.println("             / primitiveColProperty        [ primitiveColPath ]");
        out.println("             / primitiveProperty           [ primitivePath ]");
        out.println("             / streamProperty              [ boundOperation ]");
        out.println("");
        out.println("primitiveColPath = count / boundOperation / ordinalIndex / querySegment");
        out.println("");
        out.println("primitivePath  = value / boundOperation / querySegment");
        out.println("");
        out.println("complexColPath = ordinalIndex");
        out.println("               / [ \"/\" optionallyQualifiedComplexTypeName ] [ count / boundOperation / querySegment ]");
        out.println("");
        out.println("complexPath    = [ \"/\" optionallyQualifiedComplexTypeName ] ");
        out.println("                 [ \"/\" propertyPath ");
        out.println("                 / boundOperation");
        out.println("                 / querySegment");
        out.println("                 ]");
        out.println("                 ");
        out.println("filterInPath = '/$filter' OPEN boolCommonExpr CLOSE");
        out.println("");
        out.println("each  = '/$each'");
        out.println("count = '/$count'");
        out.println("ref   = '/$ref'");
        out.println("value = '/$value'");
        out.println("");
        out.println("querySegment = '/$query'");
        out.println("");
        out.println("ordinalIndex = \"/\" 1*DIGIT");
        out.println("");
        out.println("; boundOperation segments can only be composed if the type of the previous segment ");
        out.println("; matches the type of the first parameter of the action or function being called.");
        out.println("; Note that the rule name reflects the return type of the function.");
        out.println("boundOperation = \"/\" ( boundActionCall");
        out.println("                     / boundEntityColFunctionCall    [ collectionNavigation ] ");
        out.println("                     / boundEntityFunctionCall       [ singleNavigation ] ");
        out.println("                     / boundComplexColFunctionCall   [ complexColPath ] ");
        out.println("                     / boundComplexFunctionCall      [ complexPath ]");
        out.println("                     / boundPrimitiveColFunctionCall [ primitiveColPath ] ");
        out.println("                     / boundPrimitiveFunctionCall    [ primitivePath ] ");
        out.println("                     / boundFunctionCallNoParens     [ querySegment ]");
        out.println("                     )");
        out.println("");
        out.println("actionImportCall = actionImport");
        out.println("boundActionCall  = [ namespace \".\" ] action");
        out.println("                   ; with the added restriction that the binding parameter MUST be either an entity or collection of entities");
        out.println("                   ; and is specified by reference using the URI immediately preceding (to the left) of the boundActionCall");
        out.println("");
        out.println("; The following boundXxxFunctionCall rules have the added restrictions that");
        out.println(";  - the function MUST support binding, and ");
        out.println(";  - the binding parameter type MUST match the type of resource identified by the ");
        out.println(";    URI immediately preceding (to the left) of the boundXxxFunctionCall, and");
        out.println(";  - the functionParameters MUST NOT include the bindingParameter.");
        out.println("boundEntityFunctionCall       = [ namespace \".\" ] entityFunction       functionParameters");
        out.println("boundEntityColFunctionCall    = [ namespace \".\" ] entityColFunction    functionParameters");
        out.println("boundComplexFunctionCall      = [ namespace \".\" ] complexFunction      functionParameters");
        out.println("boundComplexColFunctionCall   = [ namespace \".\" ] complexColFunction   functionParameters");
        out.println("boundPrimitiveFunctionCall    = [ namespace \".\" ] primitiveFunction    functionParameters");
        out.println("boundPrimitiveColFunctionCall = [ namespace \".\" ] primitiveColFunction functionParameters");
        out.println("");
        out.println("boundFunctionCallNoParens     = [ namespace \".\" ] entityFunction");
        out.println("                              / [ namespace \".\" ] entityColFunction");
        out.println("                              / [ namespace \".\" ] complexFunction");
        out.println("                              / [ namespace \".\" ] complexColFunction");
        out.println("                              / [ namespace \".\" ] primitiveFunction");
        out.println("                              / [ namespace \".\" ] primitiveColFunction");
        out.println("");
        out.println("entityFunctionImportCall       = entityFunctionImport       functionParameters");
        out.println("entityColFunctionImportCall    = entityColFunctionImport    functionParameters");
        out.println("complexFunctionImportCall      = complexFunctionImport      functionParameters");
        out.println("complexColFunctionImportCall   = complexColFunctionImport   functionParameters");
        out.println("primitiveFunctionImportCall    = primitiveFunctionImport    functionParameters");
        out.println("primitiveColFunctionImportCall = primitiveColFunctionImport functionParameters");
        out.println("");
        out.println("functionImportCallNoParens     = entityFunctionImport");
        out.println("                               / entityColFunctionImport");
        out.println("                               / complexFunctionImport");
        out.println("                               / complexColFunctionImport");
        out.println("                               / primitiveFunctionImport");
        out.println("                               / primitiveColFunctionImport");
        out.println("");
        out.println("functionParameters = OPEN [ functionParameter *( COMMA functionParameter ) ] CLOSE");
        out.println("functionParameter  = parameterName EQ ( parameterAlias / primitiveLiteral )");
        out.println("parameterName      = odataIdentifier");
        out.println("parameterAlias     = AT odataIdentifier ");
        out.println("");
        out.println("crossjoin = '$crossjoin' OPEN");
        out.println("            entitySetName *( COMMA entitySetName )");
        out.println("            CLOSE");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 2. Query Options");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("queryOptions = queryOption *( \"&\" queryOption )        ");
        out.println("queryOption  = systemQueryOption  ");
        out.println("             / aliasAndValue ");
        out.println("             / nameAndValue");
        out.println("             / customQueryOption  ");
        out.println("");
        out.println("batchOptions = batchOption *( \"&\" batchOption )   ");
        out.println("batchOption  = format");
        out.println("             /customQueryOption   ");
        out.println("             ");
        out.println("metadataOptions = metadataOption *( \"&\" metadataOption )   ");
        out.println("metadataOption  = format");
        out.println("                /customQueryOption   ");
        out.println("");
        out.println("entityOptions  = *( entityIdOption \"&\" ) id *( \"&\" entityIdOption )");
        out.println("entityIdOption = format");
        out.println("               / customQueryOption");
        out.println("entityCastOptions = *( entityCastOption \"&\" ) id *( \"&\" entityCastOption )");
        out.println("entityCastOption  = entityIdOption");
        out.println("                  / expand ");
        out.println("                  / select");
        out.println("");
        out.println("id = ( \"$id\" / \"id\" ) EQ IRI-in-query       ");
        out.println("");
        out.println("systemQueryOption = compute");
        out.println("                  / deltatoken");
        out.println("                  / expand ");
        out.println("                  / filter ");
        out.println("                  / format ");
        out.println("                  / id");
        out.println("                  / inlinecount ");
        out.println("                  / orderby ");
        out.println("                  / schemaversion");
        out.println("                  / search");
        out.println("                  / select ");
        out.println("                  / skip ");
        out.println("                  / skiptoken");
        out.println("                  / top ");
        out.println("                  / index");
        out.println("");
        out.println("compute          = ( \"$compute\" / \"compute\" ) EQ computeItem *( COMMA computeItem )");
        out.println("computeItem      = commonExpr RWS \"as\" RWS computedProperty");
        out.println("computedProperty = odataIdentifier         ");
        out.println("");
        out.println("expand            = ( \"$expand\" / \"expand\" ) EQ expandItem *( COMMA expandItem )");
        out.println("expandItem        = \"$value\"");
        out.println("                  / expandPath");
        out.println("                  / optionallyQualifiedEntityTypeName \"/\" expandPath");
        out.println("expandPath        = *( ( complexProperty / complexColProperty / optionallyQualifiedComplexTypeName / complexAnnotationInQuery ) \"/\" )");
        out.println("                    ( STAR [ ref / OPEN levels CLOSE ]");
        out.println("                    / streamProperty ");
        out.println("                    / ( navigationProperty / entityAnnotationInQuery ) [ \"/\" optionallyQualifiedEntityTypeName ] ");
        out.println("                      [ ref   [ OPEN expandRefOption   *( SEMI expandRefOption   ) CLOSE ]");
        out.println("                      / count [ OPEN expandCountOption *( SEMI expandCountOption ) CLOSE ]");
        out.println("                      /         OPEN expandOption      *( SEMI expandOption      ) CLOSE ");
        out.println("                      ]                    ");
        out.println("                    )");
        out.println("expandCountOption = filter");
        out.println("                  / search");
        out.println("expandRefOption   = expandCountOption");
        out.println("                  / orderby");
        out.println("                  / skip ");
        out.println("                  / top ");
        out.println("                  / inlinecount");
        out.println("expandOption      = expandRefOption");
        out.println("                  / select ");
        out.println("                  / expand");
        out.println("                  / compute");
        out.println("                  / levels");
        out.println("                  / aliasAndValue");
        out.println("                ");
        out.println("levels = ( \"$levels\" / \"levels\" ) EQ ( oneToNine *DIGIT / \"max\" )");
        out.println("");
        out.println("filter = ( \"$filter\" / \"filter\" ) EQ boolCommonExpr");
        out.println("");
        out.println("orderby     = ( \"$orderby\" / \"orderby\" ) EQ orderbyItem *( COMMA orderbyItem )");
        out.println("orderbyItem = commonExpr [ RWS ( \"asc\" / \"desc\" ) ]");
        out.println("");
        out.println("skip = ( \"$skip\" / \"skip\" ) EQ 1*DIGIT");
        out.println("top  = ( \"$top\"  / \"top\"  ) EQ 1*DIGIT");
        out.println("");
        out.println("index  = ( \"$index\" / \"index\" ) EQ 1*DIGIT");
        out.println("");
        out.println("format = ( \"$format\" / \"format\" ) EQ");
        out.println("         ( \"atom\"");
        out.println("         / \"json\" ");
        out.println("         / \"xml\"");
        out.println("         / 1*pchar \"/\" 1*pchar ; <a data service specific value indicating a");
        out.println("         )                     ; format specific to the specific data service> or");
        out.println("                               ; <An IANA-defined [IANA-MMT] content type>");
        out.println("                          ");
        out.println("inlinecount = ( \"$count\" / \"count\" ) EQ booleanValue");
        out.println("");
        out.println("schemaversion   = ( \"$schemaversion\" / \"schemaversion\" ) EQ ( STAR / 1*unreserved )");
        out.println("");
        out.println("search     = ( \"$search\" / \"search\" ) EQ BWS ( searchExpr / searchExpr-incomplete )");
        out.println("");
        out.println("searchExpr = ( searchParenExpr");
        out.println("             / searchNegateExpr");
        out.println("             / searchPhrase");
        out.println("             / searchWord ");
        out.println("             ) [ searchOrExpr");
        out.println("               / searchAndExpr");
        out.println("               ]");
        out.println("searchParenExpr = OPEN BWS searchExpr BWS CLOSE");
        out.println("");
        out.println("; NOT is a unary operator if followed by a search expression");
        out.println("searchNegateExpr = 'NOT' RWS searchExpr");
        out.println("");
        out.println("; AND and OR are binary operators if they appear between search expressions");
        out.println("searchOrExpr  = RWS 'OR'  RWS searchExpr");
        out.println("searchAndExpr = RWS [ 'AND' RWS ] searchExpr");
        out.println("");
        out.println("searchPhrase = quotation-mark 1*( qchar-no-AMP-DQUOTE / SP ) quotation-mark");
        out.println("");
        out.println("; A searchWord is a sequence of one or more non-whitespace characters, excluding ");
        out.println("; - literal or percent-encoded parentheses \"(\", \"%28\", \"%29\", \")\"");
        out.println("; - literal or percent-encoded double-quotes '\"' and \"%22\"");
        out.println("; - the semicolon \";\"");
        out.println("; Percent-encoding is allowed, and required for characters with special meaning in the query part of a URL, especially \"&\" and \"#\".");
        out.println("; Expressing this in ABNF is somewhat clumsy, so the following rule is overly generous.");
        out.println("; Note: the words AND, OR, and NOT are sometimes operators, depending on their position within a search expression.");
        out.println("searchWord = searchChar *( searchChar / SQUOTE )");
        out.println("searchChar = unreserved / pct-encoded-no-DQUOTE / \"!\" / \"*\" / \"+\" / \",\" / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"=\"");
        out.println("");
        out.println("searchExpr-incomplete = SQUOTE *( SQUOTE-in-string / qchar-no-AMP-SQUOTE / quotation-mark / SP ) SQUOTE");
        out.println("");
        out.println("");
        out.println("select         = ( \"$select\" / \"select\" ) EQ selectItem *( COMMA selectItem )");
        out.println("selectItem     = STAR");
        out.println("               / allOperationsInSchema ");
        out.println("               / selectProperty");
        out.println("               / optionallyQualifiedActionName  ");
        out.println("               / optionallyQualifiedFunctionName  ");
        out.println("               / ( optionallyQualifiedEntityTypeName / optionallyQualifiedComplexTypeName ) ");
        out.println("                 \"/\" ( selectProperty");
        out.println("                     / optionallyQualifiedActionName   ");
        out.println("                     / optionallyQualifiedFunctionName  ");
        out.println("                     )");
        out.println("selectProperty = primitiveProperty / primitiveAnnotationInQuery");
        out.println("               / ( primitiveColProperty / primitiveColAnnotationInQuery ) [ OPEN selectOptionPC *( SEMI selectOptionPC ) CLOSE ]");
        out.println("               / navigationProperty");
        out.println("               / selectPath [ OPEN selectOption *( SEMI selectOption ) CLOSE");
        out.println("                            / \"/\" selectProperty ");
        out.println("                            ]");
        out.println("selectPath     = ( complexProperty / complexColProperty / complexAnnotationInQuery ) [ \"/\" optionallyQualifiedComplexTypeName ] ");
        out.println("selectOptionPC = filter / search / inlinecount / orderby / skip / top ");
        out.println("selectOption   = selectOptionPC");
        out.println("               / compute / select / aliasAndValue");
        out.println("");
        out.println("allOperationsInSchema = namespace \".\" STAR                 ");
        out.println("");
        out.println("; The parameterNames uniquely identify the bound function overload");
        out.println("; Necessary only if it has overloads");
        out.println("optionallyQualifiedActionName   = [ namespace \".\" ] action");
        out.println("optionallyQualifiedFunctionName = [ namespace \".\" ] function [ OPEN parameterNames CLOSE ]");
        out.println("");
        out.println("; The names of all non-binding parameters, separated by commas ");
        out.println("parameterNames = parameterName *( COMMA parameterName )");
        out.println("");
        out.println("deltatoken = \"$deltatoken\" EQ 1*( qchar-no-AMP )");
        out.println("");
        out.println("skiptoken = \"$skiptoken\" EQ 1*( qchar-no-AMP )");
        out.println("");
        out.println("aliasAndValue = parameterAlias EQ parameterValue");
        out.println("");
        out.println("nameAndValue = parameterName EQ parameterValue");
        out.println("");
        out.println("parameterValue = arrayOrObject");
        out.println("               / commonExpr");
        out.println("");
        out.println("customQueryOption = customName [ EQ customValue ]");
        out.println("customName        = qchar-no-AMP-EQ-AT-DOLLAR *( qchar-no-AMP-EQ ) ");
        out.println("customValue       = *( qchar-no-AMP )");
        out.println("");
        out.println("complexAnnotationInQuery = annotationInQuery ; complex-valued annotation");
        out.println("entityAnnotationInQuery  = annotationInQuery ; entity-valued annotation");
        out.println("");
        out.println("primitiveAnnotationInQuery    = annotationInQuery ; primitive-valued annotation");
        out.println("primitiveColAnnotationInQuery = annotationInQuery ; primitive collection-valued annotation");
        out.println("     ");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 3. Context URL Fragments");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("context         = \"#\" contextFragment");
        out.println("contextFragment = 'Collection($ref)'");
        out.println("                / '$ref'");
        out.println("                / 'Collection(Edm.EntityType)'");
        out.println("                / 'Collection(Edm.ComplexType)'");
        out.println("                / singletonEntity [ navigation *( containmentNavigation ) [ \"/\" qualifiedEntityTypeName ] ] [ selectList ]");
        out.println("                / qualifiedTypeName [ selectList ]");
        out.println("                / entitySet ( '/$deletedEntity' / '/$link' / '/$deletedLink' )");
        out.println("                / entitySet keyPredicate \"/\" contextPropertyPath [ selectList ]");
        out.println("                / entitySet [ selectList ] [ '/$entity' / '/$delta' ]");
        out.println("");
        out.println("entitySet = entitySetName *( containmentNavigation ) [ \"/\" qualifiedEntityTypeName ]");
        out.println("            ");
        out.println("containmentNavigation = keyPredicate [ \"/\" qualifiedEntityTypeName ] navigation");
        out.println("navigation            = *( \"/\" complexProperty [ \"/\" qualifiedComplexTypeName ] ) \"/\" navigationProperty   ");
        out.println("");
        out.println("selectList         = OPEN [ selectListItem *( COMMA selectListItem ) ] CLOSE");
        out.println("selectListItem     = STAR ; all structural properties");
        out.println("                   / allOperationsInSchema ");
        out.println("                   / [ ( qualifiedEntityTypeName / qualifiedComplexTypeName ) \"/\" ] ");
        out.println("                     ( qualifiedActionName");
        out.println("                     / qualifiedFunctionName ");
        out.println("                     / selectListProperty");
        out.println("                     )");
        out.println("selectListProperty = primitiveProperty  ");
        out.println("                   / primitiveColProperty ");
        out.println("                   / ( navigationProperty / entityAnnotationInFragment ) [ \"+\" ] [ selectList ]");
        out.println("                   / ( complexProperty / complexColProperty / complexAnnotationInFragment ) [ \"/\" qualifiedComplexTypeName ] [ \"/\" selectListProperty ]");
        out.println("");
        out.println("contextPropertyPath = primitiveProperty");
        out.println("                    / primitiveColProperty");
        out.println("                    / complexColProperty");
        out.println("                    / complexProperty [ [ \"/\" qualifiedComplexTypeName ] \"/\" contextPropertyPath ]");
        out.println("");
        out.println("qualifiedActionName   = namespace \".\" action");
        out.println("qualifiedFunctionName = namespace \".\" function [ OPEN parameterNames CLOSE ]");
        out.println("                ");
        out.println("complexAnnotationInFragment = annotationInFragment ; complex-valued annotation");
        out.println("entityAnnotationInFragment  = annotationInFragment ; entity-valued annotation");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 4. Expressions");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("; Note: a boolCommonExpr is also a commonExpr, e.g. sort by Boolean ");
        out.println("commonExpr = ( primitiveLiteral");
        out.println("             / arrayOrObject");
        out.println("             / rootExpr");
        out.println("             / firstMemberExpr");
        out.println("             / functionExpr");
        out.println("             / negateExpr ");
        out.println("             / methodCallExpr ");
        out.println("             / parenExpr ");
        out.println("             / castExpr ");
        out.println("             / isofExpr");
        out.println("             / notExpr");
        out.println("             ) ");
        out.println("             [ addExpr ");
        out.println("             / subExpr ");
        out.println("             / mulExpr ");
        out.println("             / divExpr");
        out.println("             / divbyExpr ");
        out.println("             / modExpr");
        out.println("             ]  ");
        out.println("             [ eqExpr ");
        out.println("             / neExpr ");
        out.println("             / ltExpr  ");
        out.println("             / leExpr  ");
        out.println("             / gtExpr ");
        out.println("             / geExpr ");
        out.println("             / hasExpr ");
        out.println("             / inExpr ");
        out.println("             ]");
        out.println("             [ andExpr ");
        out.println("             / orExpr ");
        out.println("             ] ");
        out.println("");
        out.println("boolCommonExpr = commonExpr ; resulting in a Boolean");
        out.println("");
        out.println("rootExpr = '$root/' ( entitySetName keyPredicate / singletonEntity ) [ singleNavigationExpr ]");
        out.println("");
        out.println("firstMemberExpr = memberExpr");
        out.println("                / inscopeVariableExpr [ \"/\" memberExpr ]");
        out.println("");
        out.println("memberExpr = directMemberExpr");
        out.println("           / ( optionallyQualifiedEntityTypeName / optionallyQualifiedComplexTypeName ) \"/\" directMemberExpr");
        out.println("             ");
        out.println("directMemberExpr = propertyPathExpr");
        out.println("                 / boundFunctionExpr ");
        out.println("                 / annotationExpr");
        out.println("             ");
        out.println("propertyPathExpr = ( entityColNavigationProperty [ collectionNavigationExpr ] ");
        out.println("                   / entityNavigationProperty    [ singleNavigationExpr ] ");
        out.println("                   / complexColProperty          [ complexColPathExpr ]");
        out.println("                   / complexProperty             [ complexPathExpr ] ");
        out.println("                   / primitiveColProperty        [ collectionPathExpr ]");
        out.println("                   / primitiveProperty           [ primitivePathExpr ]");
        out.println("                   / streamProperty              [ primitivePathExpr ]");
        out.println("                   )");
        out.println("                   ");
        out.println("annotationExpr = annotationInQuery");
        out.println("                 [ collectionPathExpr");
        out.println("                 / singleNavigationExpr");
        out.println("                 / complexPathExpr");
        out.println("                 / primitivePathExpr");
        out.println("                 ]");
        out.println("                 ");
        out.println("annotationInQuery    = AT [ namespace \".\" ] termName [ HASH annotationQualifier ]");
        out.println("annotationInFragment = AT [ namespace \".\" ] termName [ \"#\"  annotationQualifier ]");
        out.println("annotationQualifier  = odataIdentifier                ");
        out.println("                   ");
        out.println("inscopeVariableExpr  = implicitVariableExpr ");
        out.println("                     / parameterAlias");
        out.println("                     / lambdaVariableExpr ; only allowed inside a lambdaPredicateExpr");
        out.println("implicitVariableExpr = '$it'              ; the current instance of the resource identified by the resource path");
        out.println("                     / '$this'            ; the instance on which the query option is evaluated");
        out.println("lambdaVariableExpr   = odataIdentifier");
        out.println("");
        out.println("collectionNavigationExpr = [ \"/\" optionallyQualifiedEntityTypeName ]");
        out.println("                           ( collectionPathExpr");
        out.println("                           / keyPredicate [ singleNavigationExpr ] ");
        out.println("                           / filterExpr [ collectionNavigationExpr ]");
        out.println("                           )");
        out.println("");
        out.println("singleNavigationExpr = \"/\" memberExpr");
        out.println("");
        out.println("filterExpr = '/$filter' OPEN boolCommonExpr CLOSE");
        out.println("");
        out.println("complexColPathExpr = collectionPathExpr");
        out.println("                   / \"/\" optionallyQualifiedComplexTypeName [ collectionPathExpr ]");
        out.println(" ");
        out.println("collectionPathExpr = count [ OPEN expandCountOption *( SEMI expandCountOption ) CLOSE ]");
        out.println("                   / filterExpr [ collectionPathExpr ]");
        out.println("                   / \"/\" anyExpr");
        out.println("                   / \"/\" allExpr");
        out.println("                   / \"/\" boundFunctionExpr");
        out.println("                   / \"/\" annotationExpr");
        out.println(" ");
        out.println("complexPathExpr = \"/\" directMemberExpr");
        out.println("                / \"/\" optionallyQualifiedComplexTypeName [ \"/\" directMemberExpr ]");
        out.println("");
        out.println("primitivePathExpr = \"/\" [ annotationExpr / boundFunctionExpr ]");
        out.println("");
        out.println("boundFunctionExpr = functionExpr ; boundFunction segments can only be composed if the type of the    ");
        out.println("                                 ; previous segment matches the type of the first function parameter");
        out.println("                                     ");
        out.println("functionExpr = [ namespace \".\" ]");
        out.println("               ( entityColFunction    functionExprParameters [ collectionNavigationExpr ] ");
        out.println("               / entityFunction       functionExprParameters [ singleNavigationExpr ] ");
        out.println("               / complexColFunction   functionExprParameters [ complexColPathExpr ]");
        out.println("               / complexFunction      functionExprParameters [ complexPathExpr ] ");
        out.println("               / primitiveColFunction functionExprParameters [ collectionPathExpr ] ");
        out.println("               / primitiveFunction    functionExprParameters [ primitivePathExpr ] ");
        out.println("               )");
        out.println("");
        out.println("functionExprParameters = OPEN [ functionExprParameter *( COMMA functionExprParameter ) ] CLOSE");
        out.println("functionExprParameter  = parameterName EQ ( parameterAlias / parameterValue )");
        out.println("");
        out.println("anyExpr = \"any\" OPEN BWS [ lambdaVariableExpr BWS COLON BWS lambdaPredicateExpr ] BWS CLOSE");
        out.println("allExpr = \"all\" OPEN BWS   lambdaVariableExpr BWS COLON BWS lambdaPredicateExpr   BWS CLOSE");
        out.println("lambdaPredicateExpr = boolCommonExpr ; containing at least one lambdaVariableExpr");
        out.println("");
        out.println("methodCallExpr = indexOfMethodCallExpr ");
        out.println("               / toLowerMethodCallExpr ");
        out.println("               / toUpperMethodCallExpr  ");
        out.println("               / trimMethodCallExpr ");
        out.println("               / substringMethodCallExpr ");
        out.println("               / concatMethodCallExpr ");
        out.println("               / lengthMethodCallExpr ");
        out.println("               / matchesPatternMethodCallExpr");
        out.println("               / yearMethodCallExpr ");
        out.println("               / monthMethodCallExpr ");
        out.println("               / dayMethodCallExpr ");
        out.println("               / hourMethodCallExpr ");
        out.println("               / minuteMethodCallExpr ");
        out.println("               / secondMethodCallExpr ");
        out.println("               / fractionalsecondsMethodCallExpr");
        out.println("               / totalsecondsMethodCallExpr");
        out.println("               / dateMethodCallExpr ");
        out.println("               / timeMethodCallExpr ");
        out.println("               / roundMethodCallExpr ");
        out.println("               / floorMethodCallExpr ");
        out.println("               / ceilingMethodCallExpr ");
        out.println("               / distanceMethodCallExpr ");
        out.println("               / geoLengthMethodCallExpr ");
        out.println("               / totalOffsetMinutesMethodCallExpr");
        out.println("               / minDateTimeMethodCallExpr");
        out.println("               / maxDateTimeMethodCallExpr");
        out.println("               / nowMethodCallExpr");
        out.println("               / caseMethodCallExpr");
        out.println("               / boolMethodCallExpr");
        out.println("");
        out.println("boolMethodCallExpr = endsWithMethodCallExpr ");
        out.println("                   / startsWithMethodCallExpr ");
        out.println("                   / containsMethodCallExpr                                          ");
        out.println("                   / intersectsMethodCallExpr ");
        out.println("                   / hasSubsetMethodCallExpr");
        out.println("                   / hasSubsequenceMethodCallExpr");
        out.println("");
        out.println("concatMethodCallExpr         = \"concat\"         OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("containsMethodCallExpr       = \"contains\"       OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("endsWithMethodCallExpr       = \"endswith\"       OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("indexOfMethodCallExpr        = \"indexof\"        OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("lengthMethodCallExpr         = \"length\"         OPEN BWS commonExpr BWS CLOSE");
        out.println("matchesPatternMethodCallExpr = \"matchesPattern\" OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("startsWithMethodCallExpr     = \"startswith\"     OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("substringMethodCallExpr      = \"substring\"      OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS [ COMMA BWS commonExpr BWS ] CLOSE");
        out.println("toLowerMethodCallExpr        = \"tolower\"        OPEN BWS commonExpr BWS CLOSE");
        out.println("toUpperMethodCallExpr        = \"toupper\"        OPEN BWS commonExpr BWS CLOSE");
        out.println("trimMethodCallExpr           = \"trim\"           OPEN BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("yearMethodCallExpr               = \"year\"               OPEN BWS commonExpr BWS CLOSE");
        out.println("monthMethodCallExpr              = \"month\"              OPEN BWS commonExpr BWS CLOSE");
        out.println("dayMethodCallExpr                = \"day\"                OPEN BWS commonExpr BWS CLOSE");
        out.println("hourMethodCallExpr               = \"hour\"               OPEN BWS commonExpr BWS CLOSE");
        out.println("minuteMethodCallExpr             = \"minute\"             OPEN BWS commonExpr BWS CLOSE");
        out.println("secondMethodCallExpr             = \"second\"             OPEN BWS commonExpr BWS CLOSE");
        out.println("fractionalsecondsMethodCallExpr  = \"fractionalseconds\"  OPEN BWS commonExpr BWS CLOSE");
        out.println("totalsecondsMethodCallExpr       = \"totalseconds\"       OPEN BWS commonExpr BWS CLOSE");
        out.println("dateMethodCallExpr               = \"date\"               OPEN BWS commonExpr BWS CLOSE");
        out.println("timeMethodCallExpr               = \"time\"               OPEN BWS commonExpr BWS CLOSE");
        out.println("totalOffsetMinutesMethodCallExpr = \"totaloffsetminutes\" OPEN BWS commonExpr BWS CLOSE ");
        out.println("");
        out.println("minDateTimeMethodCallExpr = \"mindatetime\" OPEN BWS CLOSE");
        out.println("maxDateTimeMethodCallExpr = \"maxdatetime\" OPEN BWS CLOSE");
        out.println("nowMethodCallExpr         = \"now\"         OPEN BWS CLOSE");
        out.println("");
        out.println("roundMethodCallExpr   = \"round\"   OPEN BWS commonExpr BWS CLOSE");
        out.println("floorMethodCallExpr   = \"floor\"   OPEN BWS commonExpr BWS CLOSE");
        out.println("ceilingMethodCallExpr = \"ceiling\" OPEN BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("distanceMethodCallExpr   = \"geo.distance\"   OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("geoLengthMethodCallExpr  = \"geo.length\"     OPEN BWS commonExpr BWS CLOSE");
        out.println("intersectsMethodCallExpr = \"geo.intersects\" OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("hasSubsetMethodCallExpr      = \"hassubset\"      OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("hasSubsequenceMethodCallExpr = \"hassubsequence\" OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("caseMethodCallExpr = \"case\" OPEN BWS boolCommonExpr BWS COLON BWS commonExpr BWS ");
        out.println("                        *( COMMA BWS boolCommonExpr BWS COLON BWS commonExpr BWS ) CLOSE");
        out.println("");
        out.println("parenExpr = OPEN BWS commonExpr BWS CLOSE");
        out.println("listExpr  = OPEN BWS primitiveLiteral BWS *( COMMA BWS primitiveLiteral BWS ) CLOSE");
        out.println("");
        out.println("andExpr = RWS \"and\" RWS boolCommonExpr");
        out.println("orExpr  = RWS \"or\"  RWS boolCommonExpr");
        out.println("");
        out.println("eqExpr = RWS \"eq\" RWS commonExpr     ");
        out.println("neExpr = RWS \"ne\" RWS commonExpr");
        out.println("ltExpr = RWS \"lt\" RWS commonExpr");
        out.println("leExpr = RWS \"le\" RWS commonExpr");
        out.println("gtExpr = RWS \"gt\" RWS commonExpr");
        out.println("geExpr = RWS \"ge\" RWS commonExpr");
        out.println("inExpr = RWS \"in\" RWS ( listExpr / commonExpr )");
        out.println("");
        out.println("hasExpr = RWS \"has\" RWS enum");
        out.println("");
        out.println("addExpr   = RWS \"add\"   RWS commonExpr");
        out.println("subExpr   = RWS \"sub\"   RWS commonExpr");
        out.println("mulExpr   = RWS \"mul\"   RWS commonExpr");
        out.println("divExpr   = RWS \"div\"   RWS commonExpr");
        out.println("divbyExpr = RWS \"divby\" RWS commonExpr");
        out.println("modExpr   = RWS \"mod\"   RWS commonExpr");
        out.println("");
        out.println("negateExpr = \"-\" BWS commonExpr");
        out.println("");
        out.println("notExpr = \"not\" RWS boolCommonExpr");
        out.println("");
        out.println("isofExpr = \"isof\" OPEN BWS [ commonExpr BWS COMMA BWS ] optionallyQualifiedTypeName BWS CLOSE");
        out.println("castExpr = \"cast\" OPEN BWS [ commonExpr BWS COMMA BWS ] optionallyQualifiedTypeName BWS CLOSE");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 5. JSON format for queries");
        out.println(";------------------------------------------------------------------------------");
        out.println("; Note: the query part of a URI needs to be percent-encoding normalized before");
        out.println("; applying these rules, see comment at the top of this file");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("arrayOrObject = array");
        out.println("              / object");
        out.println("");
        out.println("array = begin-array ");
        out.println("        [ valueInUrl *( value-separator valueInUrl ) ] ");
        out.println("        end-array");
        out.println("");
        out.println("object = begin-object");
        out.println("         [ member *( value-separator member ) ]");
        out.println("         end-object");
        out.println("");
        out.println("member = stringInUrl name-separator valueInUrl");
        out.println("");
        out.println("valueInUrl = stringInUrl");
        out.println("           / commonExpr            ");
        out.println("");
        out.println("; JSON syntax: adapted to URI restrictions from [RFC8259]                 ");
        out.println("begin-object = BWS ( \"{\" / \"%7B\" ) BWS");
        out.println("end-object   = BWS ( \"}\" / \"%7D\" )");
        out.println("");
        out.println("begin-array = BWS ( \"[\" / \"%5B\" ) BWS ");
        out.println("end-array   = BWS ( \"]\" / \"%5D\" )");
        out.println("");
        out.println("quotation-mark  = DQUOTE / \"%22\"");
        out.println("name-separator  = BWS COLON BWS");
        out.println("value-separator = BWS COMMA BWS");
        out.println("");
        out.println("stringInUrl = quotation-mark *charInJSON quotation-mark");
        out.println("");
        out.println("charInJSON   = qchar-unescaped  ");
        out.println("             / qchar-JSON-special    ");
        out.println("             / escape ( quotation-mark ");
        out.println("                      / escape");
        out.println("                      / ( \"/\" / \"%2F\" ) ; solidus         U+002F - literal form is allowed in the query part of a URL");
        out.println("                      / 'b'             ; backspace       U+0008                ");
        out.println("                      / 'f'             ; form feed       U+000C");
        out.println("                      / 'n'             ; line feed       U+000A");
        out.println("                      / 'r'             ; carriage return U+000D");
        out.println("                      / 't'             ; tab             U+0009");
        out.println("                      / 'u' 4HEXDIG     ;                 U+XXXX");
        out.println("                      )");
        out.println("");
        out.println("qchar-JSON-special = SP / \":\" / \"{\" / \"}\" / \"[\" / \"]\" ; some agents put these unencoded into the query part of a URL");
        out.println("");
        out.println("escape = \"\\\" / \"%5C\"     ; reverse solidus U+005C");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 6. Names and identifiers");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("qualifiedTypeName = singleQualifiedTypeName                  ");
        out.println("                  / 'Collection' OPEN singleQualifiedTypeName CLOSE");
        out.println("");
        out.println("optionallyQualifiedTypeName = singleQualifiedTypeName                  ");
        out.println("                            / 'Collection' OPEN singleQualifiedTypeName CLOSE");
        out.println("                            / singleTypeName");
        out.println("                            / 'Collection' OPEN singleTypeName CLOSE");
        out.println("");
        out.println("singleQualifiedTypeName = qualifiedEntityTypeName ");
        out.println("                        / qualifiedComplexTypeName");
        out.println("                        / qualifiedTypeDefinitionName");
        out.println("                        / qualifiedEnumTypeName");
        out.println("                        / primitiveTypeName ");
        out.println("                        ");
        out.println("singleTypeName = entityTypeName ");
        out.println("               / complexTypeName ");
        out.println("               / typeDefinitionName ");
        out.println("               / enumerationTypeName                         ");
        out.println("                  ");
        out.println("qualifiedEntityTypeName     = namespace \".\" entityTypeName");
        out.println("qualifiedComplexTypeName    = namespace \".\" complexTypeName");
        out.println("qualifiedTypeDefinitionName = namespace \".\" typeDefinitionName ");
        out.println("qualifiedEnumTypeName       = namespace \".\" enumerationTypeName");
        out.println("");
        out.println("optionallyQualifiedEntityTypeName     = [ namespace \".\" ] entityTypeName");
        out.println("optionallyQualifiedComplexTypeName    = [ namespace \".\" ] complexTypeName");
        out.println("");
        out.println("; an alias is just a single-part namespace");
        out.println("namespace     = namespacePart *( \".\" namespacePart )");
        out.println("namespacePart = odataIdentifier");
        out.println("");
        out.println("entitySetName       = odataIdentifier");
        out.println("singletonEntity     = odataIdentifier          ");
        out.println("entityTypeName      = odataIdentifier");
        out.println("complexTypeName     = odataIdentifier");
        out.println("typeDefinitionName  = odataIdentifier ");
        out.println("enumerationTypeName = odataIdentifier");
        out.println("enumerationMember   = odataIdentifier");
        out.println("termName            = odataIdentifier");
        out.println("");
        out.println("; Note: this pattern is overly restrictive, the normative definition is type TSimpleIdentifier in OData EDM XML Schema");
        out.println("odataIdentifier             = identifierLeadingCharacter *127identifierCharacter");
        out.println("identifierLeadingCharacter  = ALPHA / \"_\"         ; plus Unicode characters from the categories L or Nl");
        out.println("identifierCharacter         = ALPHA / \"_\" / DIGIT ; plus Unicode characters from the categories L, Nl, Nd, Mn, Mc, Pc, or Cf");
        out.println("");
        out.println("primitiveTypeName = 'Edm.' ( 'Binary'");
        out.println("                           / 'Boolean'");
        out.println("                           / 'Byte'");
        out.println("                           / 'Date' ");
        out.println("                           / 'DateTimeOffset'");
        out.println("                           / 'Decimal'");
        out.println("                           / 'Double'");
        out.println("                           / 'Duration' ");
        out.println("                           / 'Guid' ");
        out.println("                           / 'Int16'");
        out.println("                           / 'Int32'");
        out.println("                           / 'Int64'");
        out.println("                           / 'SByte'");
        out.println("                           / 'Single'");
        out.println("                           / 'Stream'");
        out.println("                           / 'String'");
        out.println("                           / 'TimeOfDay'");
        out.println("                           / abstractSpatialTypeName [ concreteSpatialTypeName ] ");
        out.println("                           )");
        out.println("abstractSpatialTypeName = 'Geography'");
        out.println("                        / 'Geometry'");
        out.println("concreteSpatialTypeName = 'Collection'");
        out.println("                        / 'LineString'");
        out.println("                        / 'MultiLineString'");
        out.println("                        / 'MultiPoint'");
        out.println("                        / 'MultiPolygon'");
        out.println("                        / 'Point'");
        out.println("                        / 'Polygon'");
        out.println("");
        out.println("primitiveProperty       = primitiveKeyProperty / primitiveNonKeyProperty");
        out.println("primitiveKeyProperty    = odataIdentifier");
        out.println("primitiveNonKeyProperty = odataIdentifier");
        out.println("primitiveColProperty    = odataIdentifier");
        out.println("complexProperty         = odataIdentifier");
        out.println("complexColProperty      = odataIdentifier");
        out.println("streamProperty          = odataIdentifier");
        out.println("");
        out.println("navigationProperty          = entityNavigationProperty / entityColNavigationProperty  ");
        out.println("entityNavigationProperty    = odataIdentifier");
        out.println("entityColNavigationProperty = odataIdentifier");
        out.println("");
        out.println("action       = odataIdentifier");
        out.println("actionImport = odataIdentifier");
        out.println("");
        out.println("function = entityFunction ");
        out.println("         / entityColFunction ");
        out.println("         / complexFunction ");
        out.println("         / complexColFunction ");
        out.println("         / primitiveFunction ");
        out.println("         / primitiveColFunction");
        out.println("         ");
        out.println("entityFunction       = odataIdentifier");
        out.println("entityColFunction    = odataIdentifier");
        out.println("complexFunction      = odataIdentifier");
        out.println("complexColFunction   = odataIdentifier");
        out.println("primitiveFunction    = odataIdentifier");
        out.println("primitiveColFunction = odataIdentifier");
        out.println("");
        out.println("entityFunctionImport       = odataIdentifier");
        out.println("entityColFunctionImport    = odataIdentifier");
        out.println("complexFunctionImport      = odataIdentifier");
        out.println("complexColFunctionImport   = odataIdentifier");
        out.println("primitiveFunctionImport    = odataIdentifier");
        out.println("primitiveColFunctionImport = odataIdentifier");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 7. Literal Data Values");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("; in URLs");
        out.println("primitiveLiteral = nullValue                  ; plain values up to int64Value");
        out.println("                 / booleanValue ");
        out.println("                 / guidValue ");
        out.println("                 / dateTimeOffsetValueInUrl ");
        out.println("                 / dateValue");
        out.println("                 / timeOfDayValueInUrl");
        out.println("                 / decimalValue ");
        out.println("                 / doubleValue ");
        out.println("                 / singleValue ");
        out.println("                 / sbyteValue ");
        out.println("                 / byteValue");
        out.println("                 / int16Value ");
        out.println("                 / int32Value ");
        out.println("                 / int64Value ");
        out.println("                 / string                     ; single-quoted");
        out.println("                 / duration");
        out.println("                 / enum");
        out.println("                 / binary                     ; all others are quoted and prefixed ");
        out.println("                 / geographyCollection ");
        out.println("                 / geographyLineString ");
        out.println("                 / geographyMultiLineString ");
        out.println("                 / geographyMultiPoint ");
        out.println("                 / geographyMultiPolygon ");
        out.println("                 / geographyPoint ");
        out.println("                 / geographyPolygon ");
        out.println("                 / geometryCollection ");
        out.println("                 / geometryLineString ");
        out.println("                 / geometryMultiLineString ");
        out.println("                 / geometryMultiPoint ");
        out.println("                 / geometryMultiPolygon ");
        out.println("                 / geometryPoint ");
        out.println("                 / geometryPolygon");
        out.println("         ");
        out.println("; in Atom and JSON message bodies and CSDL DefaultValue attributes                 ");
        out.println("primitiveValue = booleanValue");
        out.println("               / guidValue");
        out.println("               / durationValue");
        out.println("               / dateTimeOffsetValue ");
        out.println("               / dateValue");
        out.println("               / timeOfDayValue");
        out.println("               / enumValue");
        out.println("               / fullCollectionLiteral");
        out.println("               / fullLineStringLiteral");
        out.println("               / fullMultiPointLiteral");
        out.println("               / fullMultiLineStringLiteral");
        out.println("               / fullMultiPolygonLiteral");
        out.println("               / fullPointLiteral");
        out.println("               / fullPolygonLiteral");
        out.println("               / decimalValue ");
        out.println("               / doubleValue ");
        out.println("               / singleValue ");
        out.println("               / sbyteValue ");
        out.println("               / byteValue");
        out.println("               / int16Value ");
        out.println("               / int32Value ");
        out.println("               / int64Value ");
        out.println("               / binaryValue ");
        out.println("               ; also valid are:");
        out.println("               ; - any XML string for strings in Atom and CSDL documents");
        out.println("               ; - any JSON string for JSON documents ");
        out.println("");
        out.println("nullValue = 'null' ");
        out.println("");
        out.println("; base64url encoding according to http://tools.ietf.org/html/rfc4648#section-5                                             ");
        out.println("binary      = \"binary\" SQUOTE binaryValue SQUOTE");
        out.println("binaryValue = *(4base64char) [ base64b16  / base64b8 ]");
        out.println("base64b16   = 2base64char ( 'A' / 'E' / 'I' / 'M' / 'Q' / 'U' / 'Y' / 'c' / 'g' / 'k' / 'o' / 's' / 'w' / '0' / '4' / '8' )   [ \"=\" ]");
        out.println("base64b8    = base64char ( 'A' / 'Q' / 'g' / 'w' ) [ \"==\" ]");
        out.println("base64char  = ALPHA / DIGIT / \"-\" / \"_\"");
        out.println("");
        out.println("booleanValue = \"true\" / \"false\"");
        out.println("");
        out.println("decimalValue = [ SIGN ] 1*DIGIT [ \".\" 1*DIGIT ] [ \"e\" [ SIGN ] 1*DIGIT ] / nanInfinity");
        out.println("doubleValue  = decimalValue ; IEEE 754 binary64 floating-point number (15-17 decimal digits)");
        out.println("singleValue  = decimalValue ; IEEE 754 binary32 floating-point number (6-9 decimal digits)");
        out.println("nanInfinity  = 'NaN' / '-INF' / 'INF'");
        out.println("");
        out.println("guidValue = 8HEXDIG \"-\" 4HEXDIG \"-\" 4HEXDIG \"-\" 4HEXDIG \"-\" 12HEXDIG ");
        out.println("");
        out.println("byteValue  = 1*3DIGIT           ; numbers in the range from 0 to 255");
        out.println("sbyteValue = [ SIGN ] 1*3DIGIT  ; numbers in the range from -128 to 127");
        out.println("int16Value = [ SIGN ] 1*5DIGIT  ; numbers in the range from -32768 to 32767        ");
        out.println("int32Value = [ SIGN ] 1*10DIGIT ; numbers in the range from -2147483648 to 2147483647");
        out.println("int64Value = [ SIGN ] 1*19DIGIT ; numbers in the range from -9223372036854775808 to 9223372036854775807");
        out.println("");
        out.println("string           = SQUOTE *( SQUOTE-in-string / pchar-no-SQUOTE ) SQUOTE");
        out.println("SQUOTE-in-string = SQUOTE SQUOTE ; two consecutive single quotes represent one within a string literal");
        out.println("");
        out.println("dateValue = year \"-\" month \"-\" day");
        out.println("");
        out.println("dateTimeOffsetValue      = year \"-\" month \"-\" day \"T\" timeOfDayValue      ( \"Z\" / SIGN hour \":\"   minute )");
        out.println("dateTimeOffsetValueInUrl = year \"-\" month \"-\" day \"T\" timeOfDayValueInUrl ( \"Z\" / SIGN hour COLON minute )");
        out.println("");
        out.println("duration      = [ \"duration\" ] SQUOTE durationValue SQUOTE");
        out.println("durationValue = [ SIGN ] \"P\" [ 1*DIGIT \"D\" ] [ \"T\" [ 1*DIGIT \"H\" ] [ 1*DIGIT \"M\" ] [ 1*DIGIT [ \".\" 1*DIGIT ] \"S\" ] ]");
        out.println("     ; the above is an approximation of the rules for an xml dayTimeDuration.");
        out.println("     ; see the lexical representation for dayTimeDuration in http://www.w3.org/TR/xmlschema11-2#dayTimeDuration for more information");
        out.println("");
        out.println("timeOfDayValue      = hour \":\"   minute [ \":\"   second [ \".\" fractionalSeconds ] ]");
        out.println("timeOfDayValueInUrl = hour COLON minute [ COLON second [ \".\" fractionalSeconds ] ]");
        out.println(" ");
        out.println("oneToNine       = \"1\" / \"2\" / \"3\" / \"4\" / \"5\" / \"6\" / \"7\" / \"8\" / \"9\" ");
        out.println("zeroToFiftyNine = ( \"0\" / \"1\" / \"2\" / \"3\" / \"4\" / \"5\" ) DIGIT");
        out.println("year  = [ \"-\" ] ( \"0\" 3DIGIT / oneToNine 3*DIGIT )");
        out.println("month = \"0\" oneToNine");
        out.println("      / \"1\" ( \"0\" / \"1\" / \"2\" )");
        out.println("day   = \"0\" oneToNine");
        out.println("      / ( \"1\" / \"2\" ) DIGIT");
        out.println("      / \"3\" ( \"0\" / \"1\" )");
        out.println("hour   = ( \"0\" / \"1\" ) DIGIT");
        out.println("       / \"2\" ( \"0\" / \"1\" / \"2\" / \"3\" ) ");
        out.println("minute = zeroToFiftyNine");
        out.println("second = zeroToFiftyNine / \"60\" ; for leap seconds");
        out.println("fractionalSeconds = 1*12DIGIT");
        out.println("");
        out.println("enum            = [ qualifiedEnumTypeName ] SQUOTE enumValue SQUOTE");
        out.println("enumValue       = singleEnumValue *( COMMA singleEnumValue )");
        out.println("singleEnumValue = enumerationMember / enumMemberValue");
        out.println("enumMemberValue = int64Value");
        out.println("");
        out.println("geographyCollection   = geographyPrefix SQUOTE fullCollectionLiteral SQUOTE");
        out.println("fullCollectionLiteral = sridLiteral collectionLiteral");
        out.println("collectionLiteral     = \"Collection(\" geoLiteral *( COMMA geoLiteral ) CLOSE");
        out.println("geoLiteral            = collectionLiteral");
        out.println("                      / lineStringLiteral");
        out.println("                      / multiPointLiteral");
        out.println("                      / multiLineStringLiteral");
        out.println("                      / multiPolygonLiteral");
        out.println("                      / pointLiteral");
        out.println("                      / polygonLiteral");
        out.println("");
        out.println("geographyLineString   = geographyPrefix SQUOTE fullLineStringLiteral SQUOTE");
        out.println("fullLineStringLiteral = sridLiteral lineStringLiteral");
        out.println("lineStringLiteral     = \"LineString\" lineStringData");
        out.println("lineStringData        = OPEN positionLiteral 1*( COMMA positionLiteral ) CLOSE");
        out.println("");
        out.println("geographyMultiLineString   = geographyPrefix SQUOTE fullMultiLineStringLiteral SQUOTE");
        out.println("fullMultiLineStringLiteral = sridLiteral multiLineStringLiteral");
        out.println("multiLineStringLiteral     = \"MultiLineString(\" [ lineStringData *( COMMA lineStringData ) ] CLOSE");
        out.println("");
        out.println("geographyMultiPoint   = geographyPrefix SQUOTE fullMultiPointLiteral SQUOTE");
        out.println("fullMultiPointLiteral = sridLiteral multiPointLiteral");
        out.println("multiPointLiteral     = \"MultiPoint(\" [ pointData *( COMMA pointData ) ] CLOSE");
        out.println("");
        out.println("geographyMultiPolygon   = geographyPrefix SQUOTE fullMultiPolygonLiteral SQUOTE");
        out.println("fullMultiPolygonLiteral = sridLiteral multiPolygonLiteral");
        out.println("multiPolygonLiteral     = \"MultiPolygon(\" [ polygonData *( COMMA polygonData ) ] CLOSE");
        out.println("");
        out.println("geographyPoint   = geographyPrefix SQUOTE fullPointLiteral SQUOTE");
        out.println("fullPointLiteral = sridLiteral pointLiteral");
        out.println("sridLiteral      = \"SRID\" EQ 1*5DIGIT SEMI");
        out.println("pointLiteral     =\"Point\" pointData");
        out.println("pointData        = OPEN positionLiteral CLOSE");
        out.println("positionLiteral  = doubleValue SP doubleValue [ SP doubleValue ] [ SP doubleValue ] ; longitude, latitude, altitude/elevation (optional), linear referencing measure (optional)");
        out.println("");
        out.println("geographyPolygon   = geographyPrefix SQUOTE fullPolygonLiteral SQUOTE");
        out.println("fullPolygonLiteral = sridLiteral polygonLiteral");
        out.println("polygonLiteral     = \"Polygon\" polygonData");
        out.println("polygonData        = OPEN ringLiteral *( COMMA ringLiteral ) CLOSE");
        out.println("ringLiteral        = OPEN positionLiteral *( COMMA positionLiteral ) CLOSE");
        out.println("                   ; Within each ringLiteral, the first and last positionLiteral elements MUST be an exact syntactic match to each other.");
        out.println("                   ; Within the polygonData, the ringLiterals MUST specify their points in appropriate winding order. ");
        out.println("                   ; In order of traversal, points to the left side of the ring are interpreted as being in the polygon.");
        out.println("");
        out.println("geometryCollection      = geometryPrefix SQUOTE fullCollectionLiteral      SQUOTE");
        out.println("geometryLineString      = geometryPrefix SQUOTE fullLineStringLiteral      SQUOTE");
        out.println("geometryMultiLineString = geometryPrefix SQUOTE fullMultiLineStringLiteral SQUOTE");
        out.println("geometryMultiPoint      = geometryPrefix SQUOTE fullMultiPointLiteral      SQUOTE");
        out.println("geometryMultiPolygon    = geometryPrefix SQUOTE fullMultiPolygonLiteral    SQUOTE");
        out.println("geometryPoint           = geometryPrefix SQUOTE fullPointLiteral           SQUOTE");
        out.println("geometryPolygon         = geometryPrefix SQUOTE fullPolygonLiteral         SQUOTE");
        out.println("");
        out.println("geographyPrefix = \"geography\"");
        out.println("geometryPrefix  = \"geometry\" ");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 8. Header values");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("header = content-id");
        out.println("       / isolation");
        out.println("       / odata-entityid ");
        out.println("       / odata-error");
        out.println("       / odata-maxversion");
        out.println("       / odata-version");
        out.println("       / prefer");
        out.println("");
        out.println("content-id = \"Content-ID\" \":\" OWS request-id");
        out.println("isolation  = [ \"OData-\" ] \"Isolation\" \":\" OWS \"snapshot\"");
        out.println("request-id = 1*unreserved");
        out.println("       ");
        out.println("odata-entityid   = \"OData-EntityID\"   \":\" OWS IRI-in-header");
        out.println("");
        out.println("; Note: the header value is a JSON object restricted to characters allowed in a header");
        out.println("odata-error      = \"OData-Error\"      \":\" OWS '{\"code\":' *( VCHAR / SP )");
        out.println("");
        out.println("odata-maxversion = \"OData-MaxVersion\" \":\" OWS 1*DIGIT \".\" 1*DIGIT     ");
        out.println("odata-version    = \"OData-Version\"    \":\" OWS \"4.0\" [ oneToNine ]");
        out.println("      ");
        out.println("prefer     = \"Prefer\" \":\" OWS preference *( OWS \",\" OWS preference )       ");
        out.println("preference = allowEntityReferencesPreference");
        out.println("           / callbackPreference");
        out.println("           / continueOnErrorPreference");
        out.println("           / includeAnnotationsPreference");
        out.println("           / maxpagesizePreference");
        out.println("           / respondAsyncPreference");
        out.println("           / returnPreference");
        out.println("           / trackChangesPreference");
        out.println("           / waitPreference");
        out.println("           ; and everything allowed by https://tools.ietf.org/html/rfc7240");
        out.println("           ; / ( parameter / token ) *( OWS \";\" [ OWS ( parameter / token ) ] )");
        out.println("           ");
        out.println("allowEntityReferencesPreference = [ \"odata.\" ] \"allow-entityreferences\"");
        out.println("");
        out.println("callbackPreference = [ \"odata.\" ] \"callback\" OWS \";\" OWS \"url\" EQ-h DQUOTE URI DQUOTE");
        out.println("");
        out.println("continueOnErrorPreference = [ \"odata.\" ] \"continue-on-error\" [ EQ-h booleanValue ]   ");
        out.println("           ");
        out.println("includeAnnotationsPreference = [ \"odata.\" ] \"include-annotations\" EQ-h DQUOTE annotationsList DQUOTE");
        out.println("annotationsList      = annotationIdentifier *(\",\" annotationIdentifier)");
        out.println("annotationIdentifier = [ excludeOperator ]");
        out.println("                       ( STAR ");
        out.println("                       / namespace \".\" ( termName / STAR ) ");
        out.println("                       ) ");
        out.println("                       [ \"#\" odataIdentifier ]");
        out.println("excludeOperator      = \"-\"");
        out.println("           ");
        out.println("maxpagesizePreference = [ \"odata.\" ] \"maxpagesize\" EQ-h oneToNine *DIGIT         ");
        out.println("");
        out.println("respondAsyncPreference = \"respond-async\"");
        out.println("");
        out.println("returnPreference = \"return\" EQ-h ( 'representation' / 'minimal' )");
        out.println("");
        out.println("trackChangesPreference = [ \"odata.\" ] \"track-changes\"");
        out.println("");
        out.println("waitPreference = \"wait\" EQ-h 1*DIGIT");
        out.println("");
        out.println(";parameter      = token \"=\" ( token / quoted-string )");
        out.println(";token          = 1*tchar");
        out.println(";tchar          = \"!\" / \"#\" / \"$\" / \"%\" / \"&\" / \"'\" / \"*\"");
        out.println(";               / \"+\" / \"-\" / \".\" / \"^\" / \"_\" / \"`\" / \"|\" / \"~\"");
        out.println(";               / DIGIT / ALPHA");
        out.println(";quoted-string  = DQUOTE *( qdtext / quoted-pair ) DQUOTE");
        out.println(";qdtext         = %x21 / %x23-5B / %x5D-7E / obs-text / OWS");
        out.println("obs-text       = %x80-FF");
        out.println(";quoted-pair    = \"\\\" ( HTAB / SP / VCHAR / obs-text )");
        out.println("");
        out.println("OWS   = *( SP / HTAB )  ; \"optional\" whitespace ");
        out.println("BWS-h = *( SP / HTAB )  ; \"bad\" whitespace in header values ");
        out.println("EQ-h  = BWS-h EQ BWS-h ");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 9. Punctuation");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("RWS = 1*( SP / HTAB / \"%20\" / \"%09\" )  ; \"required\" whitespace ");
        out.println("BWS =  *( SP / HTAB / \"%20\" / \"%09\" )  ; \"bad\" whitespace ");
        out.println("");
        out.println("AT     = \"@\" / \"%40\"");
        out.println("COLON  = \":\" / \"%3A\"");
        out.println("COMMA  = \",\" / \"%2C\"");
        out.println("EQ     = \"=\"");
        out.println("HASH   = \"%23\" ; the # character is not allowed in the query part");
        out.println("SIGN   = \"+\" / \"%2B\" / \"-\"");
        out.println("SEMI   = \";\" / \"%3B\"");
        out.println("STAR   = \"*\" / \"%2A\"");
        out.println("SQUOTE = \"'\" / \"%27\"");
        out.println("");
        out.println("OPEN  = \"(\" / \"%28\"");
        out.println("CLOSE = \")\" / \"%29\"");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; A. URI syntax [RFC3986]");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("URI           = scheme \":\" hier-part [ \"?\" query ] [ \"#\" fragment ]");
        out.println("hier-part     = \"//\" authority path-abempty");
        out.println("              / path-absolute");
        out.println("              / path-rootless");
        out.println(";              / path-empty");
        out.println(";URI-reference = URI / relative-ref");
        out.println(";absolute-URI  = scheme \":\" hier-part [ \"?\" query ]");
        out.println(";relative-ref  = relative-part [ \"?\" query ] [ \"#\" fragment ]");
        out.println(";relative-part = \"//\" authority path-abempty");
        out.println(";              / path-absolute");
        out.println(";              / path-noscheme");
        out.println(";              / path-empty");
        out.println("scheme        = ALPHA *( ALPHA / DIGIT / \"+\" / \"-\" / \".\" )");
        out.println("authority     = [ userinfo \"@\" ] host [ \":\" port ]");
        out.println("userinfo      = *( unreserved / pct-encoded / sub-delims / \":\" )");
        out.println("host          = IP-literal / IPv4address / reg-name");
        out.println("port          = *DIGIT");
        out.println("IP-literal    = \"[\" ( IPv6address / IPvFuture  ) \"]\"");
        out.println("IPvFuture     = \"v\" 1*HEXDIG \".\" 1*( unreserved / sub-delims / \":\" )");
        out.println("IPv6address   =                            6( h16 \":\" ) ls32");
        out.println("                 /                       \"::\" 5( h16 \":\" ) ls32");
        out.println("                 / [               h16 ] \"::\" 4( h16 \":\" ) ls32");
        out.println("                 / [ *1( h16 \":\" ) h16 ] \"::\" 3( h16 \":\" ) ls32");
        out.println("                 / [ *2( h16 \":\" ) h16 ] \"::\" 2( h16 \":\" ) ls32");
        out.println("                 / [ *3( h16 \":\" ) h16 ] \"::\"    h16 \":\"   ls32");
        out.println("                 / [ *4( h16 \":\" ) h16 ] \"::\"              ls32");
        out.println("                 / [ *5( h16 \":\" ) h16 ] \"::\"              h16");
        out.println("                 / [ *6( h16 \":\" ) h16 ] \"::\"");
        out.println("h16           = 1*4HEXDIG");
        out.println("ls32          = ( h16 \":\" h16 ) / IPv4address");
        out.println("IPv4address   = dec-octet \".\" dec-octet \".\" dec-octet \".\" dec-octet");
        out.println("dec-octet     = \"1\" 2DIGIT            ; 100-199");
        out.println("              / \"2\" %x30-34 DIGIT     ; 200-249");
        out.println("              / \"25\" %x30-35          ; 250-255");
        out.println("              / %x31-39 DIGIT         ; 10-99");
        out.println("              / DIGIT                 ; 0-9");
        out.println("reg-name      = *( unreserved / pct-encoded / sub-delims )");
        out.println(";path          = path-abempty    ; begins with \"/\" or is empty");
        out.println(";              / path-absolute   ; begins with \"/\" but not \"//\"");
        out.println(";              / path-noscheme   ; begins with a non-colon segment");
        out.println(";              / path-rootless   ; begins with a segment");
        out.println(";              / path-empty      ; zero characters");
        out.println("path-abempty  = *( \"/\" segment )");
        out.println("path-absolute = \"/\" [ segment-nz *( \"/\" segment ) ]");
        out.println(";path-noscheme = segment-nz-nc *( \"/\" segment )");
        out.println("path-rootless = segment-nz *( \"/\" segment )");
        out.println(";path-empty    = \"\"");
        out.println("segment       = *pchar");
        out.println("segment-nz    = 1*pchar");
        out.println(";segment-nz-nc = 1*( unreserved / pct-encoded / sub-delims / \"@\" ) ; non-zero-length segment without any colon \":\"");
        out.println("pchar         = unreserved / pct-encoded / sub-delims / \":\" / \"@\"");
        out.println("query         = *( pchar / \"/\" / \"?\" )");
        out.println("fragment      = *( pchar / \"/\" / \"?\" )");
        out.println("pct-encoded   = \"%\" HEXDIG HEXDIG");
        out.println("unreserved    = ALPHA / DIGIT / \"-\" / \".\" / \"_\" / \"~\"");
        out.println(";reserved      = gen-delims / sub-delims");
        out.println(";gen-delims    = \":\" / \"/\" / \"?\" / \"#\" / \"[\" / \"]\" / \"@\"");
        out.println(";sub-delims    = \"!\" / \"$\" / \"&\" / \"'\" / \"(\" / \")\" / \"*\" / \"+\" / \",\" / \";\" / \"=\"");
        out.println("sub-delims     =       \"$\" / \"&\" / \"'\" /                                     \"=\" / other-delims");
        out.println("other-delims   = \"!\" /                   \"(\" / \")\" / \"*\" / \"+\" / \",\" / \";\"");
        out.println("");
        out.println("pchar-no-SQUOTE       = unreserved / pct-encoded-no-SQUOTE / other-delims / \"$\" / \"&\" / \"=\" / \":\" / \"@\"");
        out.println("pct-encoded-no-SQUOTE = \"%\" ( \"0\" / \"1\" /   \"3\" / \"4\" / \"5\" / \"6\" / \"8\" / \"9\" / A-to-F ) HEXDIG ");
        out.println("                      / \"%\" \"2\" ( \"0\" / \"1\" / \"2\" / \"3\" / \"4\" / \"5\" / \"6\" /   \"8\" / \"9\" / A-to-F )");
        out.println("");
        out.println("qchar-no-AMP              = unreserved / pct-encoded           / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\" / \"=\"");
        out.println("qchar-no-AMP-EQ           = unreserved / pct-encoded           / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\"");
        out.println("qchar-no-AMP-EQ-AT-DOLLAR = unreserved / pct-encoded           / other-delims / \":\" /       \"/\" / \"?\" /       \"'\"");
        out.println("qchar-no-AMP-SQUOTE       = unreserved / pct-encoded           / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" /       \"=\"");
        out.println("qchar-no-AMP-DQUOTE       = unreserved / pct-encoded-no-DQUOTE / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\" / \"=\"");
        out.println("");
        out.println("qchar-unescaped       = unreserved / pct-encoded-unescaped / other-delims / \":\" / \"@\" / \"/\" / \"?\" / \"$\" / \"'\" / \"=\"");
        out.println("pct-encoded-unescaped = \"%\" ( \"0\" / \"1\" /   \"3\" / \"4\" /   \"6\" / \"7\" / \"8\" / \"9\" / A-to-F ) HEXDIG ");
        out.println("                      / \"%\" \"2\" ( \"0\" / \"1\" /   \"3\" / \"4\" / \"5\" / \"6\" / \"7\" / \"8\" / \"9\" / A-to-F ) ");
        out.println("                      / \"%\" \"5\" ( DIGIT / \"A\" / \"B\" /   \"D\" / \"E\" / \"F\" )");
        out.println("");
        out.println("pct-encoded-no-DQUOTE = \"%\" ( \"0\" / \"1\" /   \"3\" / \"4\" / \"5\" / \"6\" / \"7\" / \"8\" / \"9\" / A-to-F ) HEXDIG ");
        out.println("                      / \"%\" \"2\" ( \"0\" / \"1\" /   \"3\" / \"4\" / \"5\" / \"6\" / \"7\" / \"8\" / \"9\" / A-to-F ) ");
        out.println("              ");
        out.println("                 ");
        out.println(";------------------------------------------------------------------------------");
        out.println("; B. IRI syntax [RFC3987]");
        out.println(";------------------------------------------------------------------------------");
        out.println("; Note: these are over-generous stubs, for the actual patterns refer to RFC3987");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("IRI-in-header = 1*( VCHAR / obs-text )");
        out.println("IRI-in-query  = 1*qchar-no-AMP");
        out.println("");
        out.println("                      ");
        out.println(";------------------------------------------------------------------------------");
        out.println("; C. ABNF core definitions [RFC5234]");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("ALPHA  = %x41-5A / %x61-7A ");
        out.println("DIGIT  = %x30-39 ");
        out.println("HEXDIG = DIGIT / A-to-F");
        out.println("A-to-F = \"A\" / \"B\" / \"C\" / \"D\" / \"E\" / \"F\" ");
        out.println("DQUOTE = %x22");
        out.println("SP     = %x20 ");
        out.println("HTAB   = %x09 ");
        out.println(";WSP    = SP / HTAB ");
        out.println(";LWSP = *(WSP / CRLF WSP) ");
        out.println("VCHAR = %x21-7E ");
        out.println(";CHAR = %x01-7F");
        out.println(";LOCTET = %x00-FF ");
        out.println(";CR     = %x0D ");
        out.println(";LF     = %x0A ");
        out.println(";CRLF   = CR LF");
        out.println(";BIT = \"0\" / \"1\" ");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; End of odata-abnf-construction-rules");
        out.println(";------------------------------------------------------------------------------");
        out.println(";------------------------------------------------------------------------------");
        out.println("; OData Aggregation ABNF Construction Rules Version 4.0");
        out.println(";------------------------------------------------------------------------------");
        out.println(";  Working Draft 04");
        out.println(";  04 November 2015");
        out.println(";------------------------------------------------------------------------------");
        out.println(";");
        out.println("; Technical Committee:");
        out.println(";   OASIS Open Data Protocol (OData) TC");
        out.println(";   https://www.oasis-open.org/committees/odata");
        out.println(";");
        out.println("; Chairs:");
        out.println(";   - Barbara Hartel (barbara.hartel@sap.com), SAP AG");
        out.println(";   - Ram Jeyaraman (Ram.Jeyaraman@microsoft.com), Microsoft");
        out.println(";");
        out.println("; Editors:");
        out.println(";   - Ralf Handl (ralf.handl@sap.com), SAP AG");
        out.println(";   - Hubert Heijkers (hubert.heijkers@nl.ibm.com), IBM");
        out.println(";   - Gerald Krause (gerald.krause@sap.com), SAP AG");
        out.println(";   - Michael Pizzo (mikep@microsoft.com), Microsoft");
        out.println(";   - Martin Zurmuehl (martin.zurmuehl@sap.com), SAP AG");
        out.println(";");
        out.println("; Additional artifacts: ");
        out.println(";   This grammar is one component of a Work Product which consists of:");
        out.println(";   - OData Extension for Data Aggregation Version 4.0");
        out.println(";   - OData Aggregation ABNF Construction Rules Version 4.0");
        out.println(";   - OData Aggregation ABNF Test Cases");
        out.println(";   - OData Aggregation Vocabulary");
        out.println(";");
        out.println("; Related work:");
        out.println(";   This specification is related to:");
        out.println(";   - OData Version 4.0 Part 1: Protocol");
        out.println(";   - OData Version 4.0 Part 2: URL Conventions");
        out.println(";   - OData Version 4.0 Part 3: CSDL");
        out.println(";   - OData ABNF Construction Rules Version 4.0");
        out.println(";   - OData Core Vocabulary");
        out.println(";   - OData Measures Vocabulary");
        out.println(";   - OData JSON Format Version 4.0");
        out.println(";   This specification replaces or supersedes:");
        out.println(";   - None");
        out.println(";");
        out.println("; Declared XML namespaces:");
        out.println(";   - None");
        out.println(";");
        out.println("; Abstract:");
        out.println(";   This specification adds basic grouping and aggregation functionality (e.g.");
        out.println(";   sum, min, and max) to the Open Data Protocol (OData) without changing any");
        out.println(";   of the base principles of OData.");
        out.println(";");
        out.println("; Overview:");
        out.println(";   This grammar uses the ABNF defined in RFC5234 with one extension: literals ");
        out.println(";   enclosed in single quotes (e.g. '$metadata') are treated case-sensitive. ");
        out.println(";");
        out.println(";   It extends the OData ABNF Construction Rules Version 4.0");
        out.println(";");
        out.println("; Contents:");
        out.println(";   1. New alternatives for OData ABNF Construction Rules");
        out.println(";   2. System Query Option $apply");
        out.println(";   3. Extensions to $filter ");
        out.println(";");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 1. New alternatives for OData ABNF Construction Rules");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("systemQueryOption =/ apply");
        out.println("");
        out.println("expandOption =/ apply");
        out.println("");
        out.println("boolMethodCallExpr =/ isdefinedExpr");
        out.println("");
        out.println("primitiveProperty =/ expressionAlias / customAggregate");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 2. System Query Option $apply");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("apply      = '$apply' EQ applyExpr");
        out.println("applyExpr  = applyTrafo *( \"/\" applyTrafo )");
        out.println("applyTrafo = aggregateTrafo");
        out.println("           / bottomcountTrafo");
        out.println("           / bottompercentTrafo");
        out.println("           / bottomsumTrafo");
        out.println("           / computeTrafo");
        out.println("           / concatTrafo");
        out.println("           / expandTrafo");
        out.println("           / filterTrafo");
        out.println("           / groupbyTrafo");
        out.println("           / identityTrafo");
        out.println("           / searchTrafo");
        out.println("           / topcountTrafo");
        out.println("           / toppercentTrafo");
        out.println("           / topsumTrafo");
        out.println("           / customFunction");
        out.println("           ");
        out.println("aggregateTrafo  = 'aggregate' OPEN BWS aggregateItem *( BWS COMMA BWS aggregateItem ) BWS CLOSE");
        out.println("aggregateItem   = '$count' asAlias ");
        out.println("                / aggregateExpr");
        out.println("aggregateExpr   = commonExpr aggregateWith [ aggregateFrom ] asAlias");
        out.println("                / pathPrefix primitiveProperty aggregateWith [ aggregateFrom ] asAlias");
        out.println("                / pathPrefix customAggregate [ customFrom asAlias ]");
        out.println("                / pathPrefix pathSegment OPEN aggregateExpr CLOSE ");
        out.println("aggregateWith   = RWS 'with' RWS aggregateMethod        ");
        out.println("aggregateFrom   = RWS 'from' RWS groupingProperty aggregateWith [ aggregateFrom ]");
        out.println("customFrom      = RWS 'from' RWS groupingProperty [ aggregateWith ] [ customFrom ]");
        out.println("aggregateMethod = 'sum' ");
        out.println("                / 'min' ");
        out.println("                / 'max' ");
        out.println("                / 'average' ");
        out.println("                / 'countdistinct' ");
        out.println("                / namespace \".\" odataIdentifier");
        out.println("");
        out.println("asAlias         = RWS 'as' RWS expressionAlias");
        out.println("expressionAlias = odataIdentifier");
        out.println("                ");
        out.println("customAggregate = odataIdentifier");
        out.println("                ");
        out.println("groupingProperty = pathPrefix");
        out.println("                   ( entityNavigationProperty [ \"/\" qualifiedEntityTypeName ] ");
        out.println("                   / primitiveProperty ");
        out.println("                   / complexProperty");
        out.println("                   )");
        out.println("pathPrefix       = [ ( qualifiedEntityTypeName / qualifiedComplexTypeName ) \"/\" ] *( pathSegment \"/\" ) ");
        out.println("pathSegment      = ( complexProperty / complexColProperty ) [ \"/\" qualifiedComplexTypeName ]");
        out.println("                 / navigationProperty [ \"/\" qualifiedEntityTypeName  ] ");
        out.println("                   ");
        out.println("computeTrafo = 'compute' OPEN BWS computeExpr *( BWS COMMA BWS computeExpr ) BWS CLOSE     ");
        out.println("computeExpr  = commonExpr asAlias             ");
        out.println("                           ");
        out.println("bottomcountTrafo   = 'bottomcount'   OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("bottompercentTrafo = 'bottompercent' OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("bottomsumTrafo     = 'bottomsum'     OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("concatTrafo = 'concat' OPEN BWS applyExpr 1*( BWS COMMA BWS applyExpr ) BWS CLOSE");
        out.println("");
        out.println("expandTrafo = 'expand' OPEN BWS expandNavPath BWS COMMA BWS ");
        out.println("              ( expandTrafo *( BWS COMMA BWS expandTrafo )");
        out.println("              / filterTrafo *( BWS COMMA BWS expandTrafo ) ");
        out.println("              ) BWS CLOSE");
        out.println("expandNavPath = [ ( qualifiedEntityTypeName / qualifiedComplexTypeName ) \"/\" ] ");
        out.println("                *( ( complexProperty / complexColProperty ) \"/\" [ qualifiedComplexTypeName \"/\" ] )");
        out.println("                navigationProperty [ \"/\" qualifiedEntityTypeName ]");
        out.println("");
        out.println("filterTrafo = 'filter' OPEN BWS boolCommonExpr BWS CLOSE");
        out.println("");
        out.println("searchTrafo = 'search' OPEN BWS searchExpr BWS CLOSE");
        out.println("");
        out.println("groupbyTrafo   = 'groupby' OPEN BWS groupbyList [ BWS COMMA BWS applyExpr ] BWS CLOSE");
        out.println("groupbyList    = OPEN BWS groupbyElement *( BWS COMMA BWS groupbyElement ) BWS CLOSE");
        out.println("groupbyElement = groupingProperty / rollupSpec");
        out.println("rollupSpec     = 'rollup' OPEN BWS ");
        out.println("                  ( '$all' / groupingProperty )");
        out.println("                  1*( BWS COMMA BWS groupingProperty ) ");
        out.println("                  BWS CLOSE");
        out.println("");
        out.println("identityTrafo = 'identity'");
        out.println("");
        out.println("topcountTrafo   = 'topcount'   OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("toppercentTrafo = 'toppercent' OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("topsumTrafo     = 'topsum'     OPEN BWS commonExpr BWS COMMA BWS commonExpr BWS CLOSE");
        out.println("");
        out.println("customFunction = namespace \".\" ( entityColFunction / complexColFunction / primitiveColFunction ) functionExprParameters");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 3. Extensions to $filter");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("isdefinedExpr = 'isdefined' OPEN BWS ( firstMemberExpr ) BWS CLOSE");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; End of odata-aggregation-abnf");
        out.println(";------------------------------------------------------------------------------");
        out.println(";------------------------------------------------------------------------------");
        out.println("; OData Temporal ABNF Construction Rules Version 4.0");
        out.println(";------------------------------------------------------------------------------");
        out.println(";  Working Draft 01");
        out.println(";  31 January 2019");
        out.println(";------------------------------------------------------------------------------");
        out.println(";");
        out.println("; Technical Committee:");
        out.println(";   OASIS Open Data Protocol (OData) TC");
        out.println(";   https://www.oasis-open.org/committees/odata");
        out.println(";");
        out.println("; Chairs:");
        out.println(";   - Ralf Handl (ralf.handl@sap.com), SAP SE");
        out.println(";   - Michael Pizzo (mikep@microsoft.com), Microsoft");
        out.println(";");
        out.println("; Editors:");
        out.println(";   - Ralf Handl (ralf.handl@sap.com), SAP SE");
        out.println(";   - Hubert Heijkers (hubert.heijkers@nl.ibm.com), IBM");
        out.println(";   - Michael Pizzo (mikep@microsoft.com), Microsoft");
        out.println(";   - Martin Zurmuehl (martin.zurmuehl@sap.com), SAP SE");
        out.println(";");
        out.println("; Additional artifacts: ");
        out.println(";   This grammar is one component of a Work Product which consists of:");
        out.println(";   - OData Extension for Temporal Data Version 4.0");
        out.println(";   - OData Temporal ABNF Construction Rules Version 4.0");
        out.println(";   - OData Temporal ABNF Test Cases");
        out.println(";   - OData Temporal Vocabulary");
        out.println(";");
        out.println("; Related work:");
        out.println(";   This specification is related to:");
        out.println(";   - OData Version 4.01 Part 1: Protocol");
        out.println(";   - OData Version 4.01 Part 2: URL Conventions");
        out.println(";   - OData Common Schema Definition Language (CSDL) JSON Representation Version 4.01");
        out.println(";   - OData Common Schema Definition Language (CSDL) XML Representation Version 4.01");
        out.println(";   - OData JSON Format Version 4.01");
        out.println(";   - OData ABNF Construction Rules Version 4.01");
        out.println(";   This specification replaces or supersedes:");
        out.println(";   - None");
        out.println(";");
        out.println("; Declared XML namespaces:");
        out.println(";   - None");
        out.println(";");
        out.println("; Abstract:");
        out.println(";   This specification defines how to represent and interact with temporal data");
        out.println(";   using the Open Data Protocol (OData).");
        out.println(";");
        out.println("; Overview:");
        out.println(";   This grammar uses the ABNF defined in RFC5234 with one extension: literals ");
        out.println(";   enclosed in single quotes (e.g. '$metadata') are treated case-sensitive. ");
        out.println(";");
        out.println(";   It extends the OData ABNF Construction Rules Version 4.0");
        out.println(";");
        out.println("; Contents:");
        out.println(";   1. New alternatives for OData ABNF Construction Rules");
        out.println(";   2. Temporal System Query Options ");
        out.println(";");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 1. New alternatives for OData ABNF Construction Rules");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("systemQueryOption =/ temporalOption");
        out.println("");
        out.println("expandOption =/ temporalOption");
        out.println("");
        out.println("temporalOption = at-option");
        out.println("               / from ");
        out.println("               / to ");
        out.println("               / systemat");
        out.println("               / systemfrom ");
        out.println("               / systemto");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; 2. Temporal System Query Options");
        out.println(";------------------------------------------------------------------------------");
        out.println("");
        out.println("at-option  = '$at'         EQ temporalExpr");
        out.println("from       = '$from'       EQ temporalExpr");
        out.println("to         = '$to'         EQ temporalExpr");
        out.println("systemat   = '$systemat'   EQ temporalExpr");
        out.println("systemfrom = '$systemfrom' EQ temporalExpr");
        out.println("systemto   = '$systemto'   EQ temporalExpr");
        out.println("");
        out.println("temporalExpr = 'min' ");
        out.println("             / 'max' ");
        out.println("             / dateTimeOffsetValue ");
        out.println("             / dateValue");
        out.println("");
        out.println("");
        out.println(";------------------------------------------------------------------------------");
        out.println("; End of odata-temporal-abnf");
        out.println(";------------------------------------------------------------------------------");
    }
}
