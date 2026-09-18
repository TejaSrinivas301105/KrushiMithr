# 🌾 KrushiMithr — Farmer's Friend

> **KrushiMithr** (meaning *Farmer's Friend* in Telugu/Kannada) is a platform that directly connects farmers with buyers, eliminating middlemen and ensuring farmers get the **true market value** for their crops.

---

## 🚜 The Problem — Middleman Exploitation

In traditional agricultural supply chains:

- Farmers sell crops to middlemen at **very low prices**
- Middlemen resell to buyers at **2x to 5x the price**
- Farmers have **no visibility** into real market prices
- Farmers have **no direct access** to buyers
- Most of the profit goes to middlemen, not the farmer who actually grew the crop

### 💡 How KrushiMithr Solves This

| Without KrushiMithr | With KrushiMithr |
|---|---|
| Farmer sells to middleman at ₹10/kg | Farmer lists crop directly at ₹18/kg |
| Buyer buys from middleman at ₹25/kg | Buyer buys directly from farmer at ₹20/kg |
| Farmer earns less, buyer pays more | Farmer earns more, buyer pays less |
| No price transparency | Real-time market prices visible to all |

---

## ✨ Features

- 🔐 **Secure Authentication** — JWT-based login/signup with Google & GitHub OAuth2 support
- 👨‍🌾 **Farmer Registration** — Farmers can list their crops with name, quantity, price, location and image
- 🥦 **Vegetable Catalog** — Browse all available vegetables with images
- 📈 **Real-time Market Prices** — View live market prices across different marketplaces
- 💰 **Direct Price Setting** — Farmers set their own selling price based on real market data
- 🗺️ **Location-based Listings** — Find farmers near your location

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot |
| Security | Spring Security, JWT, OAuth2 (Google, GitHub) |
| Database | PostgreSQL (via Supabase) |
| ORM | Spring Data JPA / Hibernate |
| Storage | Supabase Storage (crop images) |
| Build Tool | Maven |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Maven
- PostgreSQL or Supabase account
- Google OAuth2 credentials
- GitHub OAuth2 credentials

### Setup

**1. Clone the repository**
```bash
git clone https://github.com/TejaSrinivas301105/KrushiMithr.git
cd KrushiMithr
```

**2. Create `src/main/resources/application.yml`**
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: ${GOOGLE_CLIENT_ID}
            client-secret: ${GOOGLE_CLIENT_SECRET}
          github:
            client-id: ${GITHUB_CLIENT_ID}
            client-secret: ${GITHUB_CLIENT_SECRET}
  datasource:
    url: ${DB_URL}
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
```

**3. Set environment variables**
```env
GOOGLE_CLIENT_ID=your-google-client-id
GOOGLE_CLIENT_SECRET=your-google-client-secret
GITHUB_CLIENT_ID=your-github-client-id
GITHUB_CLIENT_SECRET=your-github-client-secret
DB_URL=your-database-url
DB_USERNAME=your-db-username
DB_PASSWORD=your-db-password
```

**4. Run the application**
```bash
mvn spring-boot:run
```

---

## 📡 API Endpoints

### Auth
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| POST | `/auth/signup` | Register new user | No |
| POST | `/auth/login` | Login and get JWT token | No |
| GET | `/oauth2/authorization/google` | Login with Google | No |
| GET | `/oauth2/authorization/github` | Login with GitHub | No |

### Farmers
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| POST | `/Farmers/details` | Register farmer with crop details | Yes |
| GET | `/` | Get all farmers | Yes |
| GET | `/{id}` | Get farmer by ID | Yes |

### Vegetables & Market Prices
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| POST | `/Farmers/Vegetable` | Add a vegetable | Yes |
| GET | `/Vegetables` | Get all vegetables with prices | Yes |
| POST | `/Prices` | Set market price for a vegetable | Yes |

---

## 🔐 Authentication

All protected endpoints require a JWT token in the header:
```
Authorization: Bearer <your-jwt-token>
```

Get the token from `/auth/login` or via OAuth2 login.

---

## 🌱 Impact

KrushiMithr empowers farmers by:
- Giving them **price transparency** — they can see real market rates before selling
- Giving them **direct market access** — no dependency on middlemen
- Letting them **set their own price** based on market data
- Connecting them **directly with buyers** — more profit stays with the farmer

> *"When a farmer prospers, the nation prospers."*

---

## 👨‍💻 Author

**Teja Srinivas**
- GitHub: [@TejaSrinivas301105](https://github.com/TejaSrinivas301105)
