# ⚡ FIX Initiator · Java + Spring Boot + QuickFIX/J

This repo shows how to spin up a **FIX Initiator** using **Java 21**, **Spring Boot 3.5.5**, and **QuickFIX/J**.  
It’s part of the series _“Building a Trading System with Java and Spring Boot”_ → check the [Medium tutorial](https://medium.com/@achrafhasbi_44380/fix-protocol-building-a-trading-system-using-java-and-spring-boot-part-1-a76254a5f937).

The Initiator handles creating & sending orders to an Acceptor.

For testing we use the Acceptor mock [FIXimulator](http://fiximulator.org/). 🖥️

---

## 🛠 Prereqs

- ☕ **Java 21**
- 📦 **Maven Wrapper** (already included, no need to install Maven)
- 🎛️ **FIXimulator** (grab it from [fiximulator.org](http://fiximulator.org/))

---

## ⚙️ Quickstart

```bash
# 1. Clone the repo
git clone https://github.com/Achraf-Hasbi/quickfixj-initiator.git
cd quickfixj

# 2. Fire up FIXimulator
java -jar ./dist/FIXimulator_0.41.jar

# 3. Launch the Initiator
./mvnw spring-boot:run