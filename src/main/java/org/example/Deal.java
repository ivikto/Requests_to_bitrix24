package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Deal {

    private int id;
    private String xmlId;
    private String title;
    private int createdBy;
    private int updatedBy;
    private int movedBy;
    private ZonedDateTime createdTime; // Изменено с LocalDateTime
    private ZonedDateTime updatedTime;
    private ZonedDateTime movedTime;
    private int categoryId;
    private String opened;
    private String stageId;
    private String previousStageId;
    private LocalDateTime begindate;
    private LocalDateTime closedate;
    private int companyId;
    private int contactId;
    private double opportunity;
    private String isManualOpportunity;
    private double taxValue;
    private String currencyId;
    private int mycompanyId;
    private String sourceId;
    private String sourceDescription;
    private int webformId;
    /** Ссылка на образец изделия */
    @JsonProperty("UF_CRM_9_1738915382456")
    private List<String> sampleProductLinks;

    /** Рыночная стоимость */
    @JsonProperty("UF_CRM_9_1738915419932")
    private String marketPrice;

    /** Файлы */
    @JsonProperty("UF_CRM_9_1738915452325")
    private List<FileInfo> files;

    /** Описание */
    @JsonProperty("UF_CRM_9_1738915482959")
    private String description;

    /** Количество */
    @JsonProperty("UF_CRM_9_1738915576536")
    private Integer quantity;

    /** Номер ЗН */
    @JsonProperty("UF_CRM_9_1738933034117")
    private String znNumber;

    /** zn_ref_key */
    @JsonProperty("UF_CRM_9_1740037586148")
    private String znRefKey;

    /** zp_ref_key */
    @JsonProperty("UF_CRM_9_1740639583760")
    private String zpRefKey;

    /** Номер ЗП */
    @JsonProperty("UF_CRM_9_1740639625315")
    private String zpNumber;

    /** Наименование изделия */
    @JsonProperty("UF_CRM_9_1740641906470")
    private String productName;

    /** num_ref_key */
    @JsonProperty("UF_CRM_9_1740647105")
    private String numRefKey;

    /** Создать новый документ */
    @JsonProperty("UF_CRM_9_1740663718587")
    private String createNewDocument;

    /** Номер ЗНП */
    @JsonProperty("UF_CRM_9_1740728655")
    private String znpNumber;

    /** znp_ref_key */
    @JsonProperty("UF_CRM_9_1740738851")
    private String znpRefKey;

    /** ID Чата */
    @JsonProperty("UF_CRM_9_1741588689")
    private String chatId;

    /** spec_ref_key */
    @JsonProperty("UF_CRM_9_1741845938318")
    private String specRefKey;

    /** Дизайн */
    @JsonProperty("UF_CRM_9_1742458017")
    private String design;

    /** Требуется дизайн */
    @JsonProperty("UF_CRM_9_1742458167")
    private String designRequired;

    /** Год ЗН */
    @JsonProperty("UF_CRM_9_1742898726")
    private Integer znYear;

    /** Дедлайн */
    @JsonProperty("UF_CRM_9_1743518582924")
    private ZonedDateTime deadline;

    /** Стадия производства */
    @JsonProperty("UF_CRM_9_1744185533")
    private Integer productionStage;

    /** Изготовлено */
    @JsonProperty("UF_CRM_9_1744188398")
    private String manufactured;

    /** Ссылка на дизайн */
    @JsonProperty("UF_CRM_9_1744192341805")
    private String designLink;

    /** Карточка дизайна */
    @JsonProperty("UF_CRM_9_1744192791")
    private String designCard;

    /** Цена реализации */
    @JsonProperty("UF_CRM_9_1744193641")
    private Object realizationPrice; // Тип может быть String/Double в зависимости от данных

    /** ЗН для окраски */
    @JsonProperty("UF_CRM_9_1744193944")
    private List<String> znForPainting;

    private int assignedById;
    private int lastActivityBy;
    private LocalDateTime lastActivityTime;
    private String utmSource;
    private String utmMedium;
    private String utmCampaign;
    private String utmContent;
    private String utmTerm;
    private List<Integer> observers;
    private List<Integer> contactIds;
    private int entityTypeId;

    public static class FileInfo {
        private int id;
        private String url;
        private String urlMachine;
    }

    public static class TimeInfo {
        private double start;
        private double finish;
        private double duration;
        private double processing;
        private LocalDateTime dateStart;
        private LocalDateTime dateFinish;
    }
}
