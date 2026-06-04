# MiniClinic 社區診所掛號系統

一個以 Spring Boot 實作的社區診所掛號系統，支援醫師登入、病患掛號、
掛號狀態管理等功能。

## 線上 Demo

https://miniclinic-你的帳號.onrender.com

## 技術棧

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Thymeleaf
- SQLite（開發）/ PostgreSQL（部署）
- BCrypt（密碼雜湊）

## 功能清單

- 醫師登入 / 登出
- 醫師個人 Dashboard
- 病患資料管理（CRUD）
- 線上掛號功能
- 掛號狀態變更（booked / completed / cancelled）
- RESTful API（支援第三方整合）

## 本機執行

```bash
git clone https://github.com/wanglulu172/miniclinic.git
cd miniclinic
./mvnw spring-boot:run
```

開啟瀏覽器訪問 http://localhost:8080

預設醫師帳密：

- D001 / pass1234
- D002 / pass1234
- （其他醫師密碼均為 pass1234）

## 資料初始化

第一次啟動時，`data.sql` 會自動插入：
- 5 位虛構醫師
- 3 位虛構病患（TEST00001, TEST00002, TEST00003）
- 3 筆示範掛號

## 專案結構

```
src/
├── main/
│   ├── java/tw/edu/fju/miniclinic/
│   │   ├── controller/     # HTTP 請求處理
│   │   ├── model/          # Entity 與 Repository
│   │   ├── interceptor/    # 登入驗證
│   │   └── config/         # Spring 配置
│   └── resources/
│       ├── templates/      # Thymeleaf 模板
│       ├── static/         # CSS、JS
│       └── application.properties
```
# MiniClinic - 診所掛號管理系統

本專案為基於 Spring Boot 與 Thymeleaf 開發的醫療資訊系統微型原型，提供醫師與管理人員管理每日看診與掛號狀態。

## 🚀 專案核心功能
* **醫師 Dashboard**：即時查看今日掛號清單，支援動態變更掛號狀態。
* **看診完成控制**：支援對 `BOOKED` 狀態的掛號進行「看診完成」與「取消」操作，並即時連動資料庫。
* **數據統計端點**：提供公開的 `GET /api/stats` API，回傳系統內醫生、患者及掛號狀態的即時摘要數據。

## 🛠️ 本地執行步驟

### 前置需求
* Java 17
* Maven 3.x+

### 啟動專案
1. 複製專案至本地端：
   ```bash
   git clone [https://github.com/wanglulu172/miniclinic.git](https://github.com/wanglulu172/miniclinic.git)

## 作者

2026 年 Java 程式設計課程作業

## 聲明

所有病患資料均為虛構，僅供教學使用。
