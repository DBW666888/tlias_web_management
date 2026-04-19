# TLIAS 智能办公管理系统 (Tlias Web Management)

## 📖 项目简介
TLIAS (Tlias Web Management) 是一个基于 Spring Boot + MyBatis + MySQL 构建的企业级员工与部门管理系统。项目采用了典型的 RESTful API 设计架构，实现了灵活的员工信息维护、部门架构管理、岗位经历追踪、JWT 安全认证以及阿里云 OSS 云存储集成，是一个功能完备的后台管理系统。

> [!IMPORTANT]
> **安全声明**：为了保护隐私，本项目已进行脱敏处理。所有敏感配置（如数据库密码、密钥、云存储凭证等）均已替换为占位符或建议通过环境变量注入。

## 🛠️ 技术栈
*   **后端核心**: Java 17, Spring Boot 4.0.2
*   **持久层**: MyBatis, PageHelper (分页插件)
*   **数据库**: MySQL
*   **安全认证**: JWT (JSON Web Token), Filter, Interceptor
*   **文件存储**: 阿里云 OSS (Object Storage Service)
*   **日志系统**: SLF4J, Logback (记录员工操作日志)
*   **工具库**: Lombok, JAXB (支持 OSS SDK)
*   **前端交互**: RESTful 风格接口 (可通过 Postman/Apifox 测试)

## ✨ 核心功能
*   **🏢 部门管理**: 实现部门的增、删、改、查，支持部门结构的动态维护。
*   **👤 员工管理**:
    *   **分页查询**: 支持按姓名、性别、入职日期等多种条件的复合查询。
    *   **信息维护**: 包括员工基本信息、职位、薪资、头像等。
    *   **岗位经历**: 关联维护员工的历史工作经历。
*   **🔐 安全认证**:
    *   **统一登录**: 基于 JWT 实现无状态登录，提高系统安全性。
    *   **访问控制**: 通过 Filter 或 Interceptor 进行令牌校验，防止非法访问。
*   **☁️ 文件上传**: 集成阿里云 OSS，支持员工头像的高效云端存储与访问。
*   **📊 统计报表**: 提供员工性别分布、职位分布等数据的统计分析接口。
*   **🛡️ 全局异常处理**: 统一定义 `Result` 返回对象，优雅地捕获并处理全局异常。
*   **📜 操作审计**: 自动记录员工的关键操作日志，便于追溯。

## 📁 项目结构
```text
tlias_web_management
├── src/main/java/com/tlias
│   ├── config/            # 配置类 (WebMvc, Interceptor 等)
│   ├── controller/        # 控制层 (REST 接口定义)
│   │   └── filter/        # 过滤器 (安全校验)
│   ├── exception/         # 全局异常处理
│   ├── interceptor/       # 拦截器 (登录鉴权)
│   ├── mapper/            # 数据访问层 (MyBatis 接口)
│   ├── pojo/              # 实体类 (Entity, DTO, Properties)
│   ├── service/           # 业务逻辑层 (接口与实现)
│   ├── utils/             # 工具类 (JWT, OSS 操作)
│   └── TliasWebManagementApplication.java  # 启动类
├── src/main/resources
│   ├── com/tlias/mapper/  # MyBatis XML 映射文件
│   ├── static/            # 静态资源 (前端测试页面)
│   ├── application.yml    # 系统核心配置
│   └── logback.xml        # 日志输出配置
└── pom.xml                # Maven 依赖管理
```

## 🚀 快速开始

### 1. ⚙️ 配置说明 (必须修改的信息)
在运行项目前，请务必根据您的环境修改以下配置：

#### A. 数据库配置
修改 `src/main/resources/application.yml` 中的数据库连接：
- `url`: 修改为您的数据库地址和端口。
- `username`: 您的 MySQL 用户名。
- `password`: 您的 MySQL 密码（建议通过环境变量 `MYSQL_PASSWORD` 设置，默认值为 `123`）。

#### B. 阿里云 OSS 配置
本系统集成了阿里云文件存储，请在 `application.yml` 中配置：
- `endpoint`: 您的 OSS 地域节点。
- `bucketName`: 您的 Bucket 名称（建议通过环境变量 `OSS_BUCKET_NAME` 设置）。
- `region`: 您的 OSS 区域。

**凭证安全**：请设置以下环境变量（不要直接写在代码或配置中）：
- `OSS_ACCESS_KEY_ID`: 您的阿里云 AccessKey ID。
- `OSS_ACCESS_KEY_SECRET`: 您的阿里云 AccessKey Secret。

#### C. JWT 安全密钥
出于安全考虑，项目中 [JwtUtils.java](file:///e:/back-end%20development/JAVA+AI/web_ai_project02/tlias_web_management/src/main/java/com/tlias/utils/JwtUtils.java) 的签名密钥已设为占位符。
- **操作**: 修改 `JwtUtils.java` 中的 `signKey` 静态变量，或者将其重构为从配置文件中读取。

### 2. 环境准备
*   **JDK**: 17+
*   **Maven**: 3.6+
*   **MySQL**: 8.0+
*   **阿里云 OSS 账号**: 需开通 OSS 服务并获取 AccessKey。

### 3. 编译与运行
在项目根目录下执行以下命令：
```bash
# 编译并运行
mvn spring-boot:run
```
系统默认启动端口为 `8080`。

## 🧪 测试
*   **接口测试**: 推荐使用 Postman 导入接口文档进行测试。
*   **单元测试**: 核心业务代码已编写 JUnit 5 测试用例，位于 `src/test` 目录下。

---
*本项目遵循 Java 最佳实践进行开发。*
