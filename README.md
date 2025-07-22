## **README.md for J2EE Design Patterns Demo (OODP1 Package)**

# 🏗️ J2EE Design Patterns Showcase (OODP1)

> A hands-on collection of foundational Object-Oriented Design Patterns implemented in Java. Each pattern features a real-world scenario, UML-conformant code, and execution output.

---

## 📑 Table of Contents

1. [✨ Project Overview](#-project-overview)
2. [📂 OODP1 Package Structure](#-oodp1-package-structure)
3. [🚀 How to Run Demos](#-how-to-run-demos)
4. [🔍 Pattern Demonstrations](#-pattern-demonstrations)

   * [Adapter](#adapter)
   * [Command](#command)
   * [Facade](#facade)
   * [Factory](#factory)
   * [Iterator](#iterator)
   * [Observer](#observer)
   * [Proxy](#proxy)
   * [Singleton](#singleton)
   * [State](#state)
   * [Strategy](#strategy)
   * [Template Method](#template-method)
5. [📝 Exercises & Extensions](#-exercises--extensions)
6. [📌 OODP2 Package (Upcoming)](#-oodp2-package-upcoming)
7. [🤝 Contribution](#-contribution)
8. [📜 License](#-license)

---

## ✨ Project Overview

The **OODP1** package illustrates **11 key design patterns** with:

* **Real-world scenarios** and **benefits** drawn from the domain (e.g., printing, home theater, legal services).
* **Java implementations** following standard UML structures.
* **Demo runners** showing console output for each pattern.

All examples reside under **`java/com/tharindu/oodp1/`**, ready to compile and execute.

---

## 📂 OODP1 Package Structure

```
java/com/tharindu/oodp1/
├── Adapter/
    ├── LaptopAdapter.java
│   └── MainAdapter.java
├── Command/
│   └── CommandPatternDemo.java
├── Facade/
│   └── MovieNightFacade.java
├── Factory/
│   └── MyLegalFactory.java
├── Iterator/
│   └── IteratorDemo.java
├── Observer/
│   └── ObserverDemo.java
├── Proxy/
│   └── MainProxy.java
├── Singleton/
│   └── OfficeSingleton.java
├── State/
│   └── StatePatternDemo.java
├── Strategy/
    ├── Navigation_Strategy.java
    ├── OnlineStoreStrategy.java
│   └── Payment_Strategy.java
└── Template/
    └── TemplateMethodDemo.java
```

---

## 🚀 How to Run Demos

1. **Compile** the project with Maven or your IDE.
2. **Execute** a demo’s `main()` method. For Maven:

   ```bash
   mvn compile exec:java -Dexec.mainClass="com.tharindu.oodp1.Adapter.MainAdapter"
   ```
3. **Review** console output illustrating pattern behavior.

---

## 🔍 Pattern Demonstrations

Here is the complete `README.md` converted from your **Design Pattern Scenarios.docx**, formatted in Markdown:

---

# 🎨 Design Pattern Scenarios

Explore real-world inspired examples of popular design patterns in software development. Each scenario includes a short narrative, the key design concept, and output behavior.

---

## 🔒 Singleton Design Pattern: **Printer Spooler**

### 📘 Scenario

In an office network with multiple computers, direct simultaneous access to the printer would cause conflicts.
A **Printer Spooler**:

* Queues the print jobs
* Sends them one at a time
* Must be a single instance

### ✅ Real-World Benefit

* Centralized control
* Prevents duplicate access
* Improves reliability

<p align="center"><img width="261" height="133" alt="singleton" src="https://github.com/user-attachments/assets/8f72b24e-34ab-42c4-97be-d550b929a59e" /></p>

### 🖨️ Output

```
Printer Spooler Initialized
Printing: Employee Report.pdf
Printing: Annual Budget.xlsx
```

---

## 🎭 Facade Design Pattern: **🍿 Home Theater System**

### 📘 Scenario

To watch a movie, users have to:

* Turn on TV & Sound System
* Adjust input/volume
* Dim lights
* Start DVD

Too complex? The **Facade** simplifies it.

<p align="center"><img width="515" height="266" alt="facade" src="https://github.com/user-attachments/assets/44759187-9002-4b3c-9b4c-daaa2c031eea" /></p>

### 🎬 Output

```
Get ready to watch a movie...
Lights dimmed
TV turned on
TV input set to HDMI
Sound system on
Volume set to 10
DVD Player on
Playing movie: Avengers: Endgame

Shutting down the theater...
```

---

## 🎯 Strategy Design Pattern: **🏦 Online Payment System**

### 📘 Scenario

Users can pay via:

* 💳 Credit Card
* 💸 PayPal
* 💰 Cryptocurrency

Each has its own logic.

### ❌ Problem

A single `PaymentProcessor` with if-else becomes unmaintainable.

### 💡 Solution

Use a common interface and plug in a strategy at runtime.

<p align="center"><img width="483" height="342" alt="Strategy" src="https://github.com/user-attachments/assets/22ab646c-4bb6-4276-9c65-f34fbea1b389" /></p>

### 💵 Output

```
Paid Rs. 1500.0 using Credit Card.
Paid Rs. 5000.0 using PayPal.
Paid Rs. 12000.0 using Cryptocurrency.
```

---

## 🔌 Adapter Design Pattern: **⚡ Charging a Phone in Europe**

### 📘 Scenario

You're in Europe with a US laptop charger or phone charger.

* ⚡ Europe uses Type C plugs (2 round pins).
* 🔌Your charger has a Type A plug (2 flat pins).

You can’t plug it directly — so you use a plug adapter.

👉The adapter converts the interface (plug type) so the device (your charger) can work with the existing system (European socket).

Use a **Plug Adapter** to convert interfaces.

### 🔧 Design Mapping

| Element        | Role             |
| -------------- | ---------------- |
| Phone          | Client           |
| EuropeanSocket | Target Interface |
| USCharger      | Adaptee          |
| PlugAdapter    | Adapter          |

<p align="center"><img width="376" height="217" alt="Adapter" src="https://github.com/user-attachments/assets/205f050c-7977-4ba3-9b3c-3fd4149d122f" /></p>

### 🔋 Output

```
Phone starts charging...
Adapting plug...
Power supplied using US standard plug.
```

---

## 🏭 Factory Design Pattern: **🎮 Battle Sim VR**

### 📘 Scenario

A military VR sim equips recruits using a `GunFactory`. You ask, it delivers:

#### 🔧 Missions

* **Urban Ambush** → Pistol
* **Frontline Warzone** → Rifle + Shotgun
* **Jungle Siege** → AK47 + Sniper Rifle

<p align="center"><img width="656" height="343" alt="Factory" src="https://github.com/user-attachments/assets/49078240-4cd3-47b1-a3da-c210ad217f7c" /></p>

### 🔫 Output

```
=== Weapon Test Firing ===
1️⃣ Firing Pistol:
̸̸̱͂ ̸͆̿͞ ̄̿̄͞ ̿̅͞ ̿̅͞ ̄̚

2️⃣ Firing Rifle:
▄︻デ╦═一━

3️⃣ Firing Shotgun:
⌐╦╦═─

4️⃣ Firing AK47:
▄︻╦芫≡══--

5️⃣ Firing Sniper Rifle:
︻╦̵̵̿╤━─

=== All weapons fired! ===
```
---

## 🌐 Proxy Design Pattern: **🔐 Secure Vault Operator**

### 📘 Scenario

In a high-tech research facility, there's a secure vault that stores classified information. Only a trusted operator named Tharindu knows how to safely interact with the vault's delicate system (insert, update, delete, read).

However, allowing everyone to directly touch the vault system is risky. What if someone enters the wrong command? Or worse — tries to steal data?

To solve this, the facility appoints a gatekeeper — a Proxy Operator. The gatekeeper looks like a regular operator to others, but before doing anything, he asks for a username and password.

> If you give the correct credentials, the proxy lets you through to the real vault system and performs the operation.

> If not, the proxy denies access and logs the intrusion attempt.

So now, people can ask to insert, update, delete, or query the database, but only if they go through the proxy. The real vault stays hidden and safe behind this protective layer.


### 🛡️ Mapping

| Story Element     | Java Component   |
| ----------------- | ---------------- |
| Real vault system | `RealDatabase`   |
| Proxy             | `ProxyDatabase`  |
| Auth check        | `authenticate()` |

<p align="center"><img width="413" height="537" alt="Proxy" src="https://github.com/user-attachments/assets/69266c52-f980-4a8e-b896-2251dfb14bf0" /></p>

### 🔑 Output

```
=== Attempt with valid credentials ===
[ProxyDatabase] Authenticated. Delegating insert().
[RealDatabase] Inserting data into the database.

[ProxyDatabase] Authenticated. Delegating update().
[RealDatabase] Updating data in the database.

[ProxyDatabase] Authenticated. Delegating delete().
[RealDatabase] Deleting data from the database.

[ProxyDatabase] Authenticated. Delegating select().
[RealDatabase] Selecting data with query: SELECT * FROM users

=== Attempt with invalid credentials ===
[ProxyDatabase] Authentication failed. Access denied.
[ProxyDatabase] Authentication failed. Access denied.
[ProxyDatabase] Authentication failed. Access denied.
[ProxyDatabase] Authentication failed. Access denied.
```

---

## 🏢 Template Method Pattern: **Realm Defenders Ritual**

### 📘 Scenario

Heroes follow a fixed battle ritual:

1. Prepare
2. Engage
3. Defend
4. Celebrate

Different hero types (Warrior, Mage, Archer) override only the parts that differ—in exactly the order defined by the ritual.

<p align="center"><img width="511" height="315" alt="TemplateMethod" src="https://github.com/user-attachments/assets/75acfc32-484e-4be8-b8b5-0447f64b9203" /></p>

### 🛡️ Output

```
=== Warrior’s Ritual ===
[Warrior] Donning heavy armor and readying sword.
[Warrior] Charges forward with a battle cry!
[Warrior] Raises shield to block incoming blows.
[Warrior] Roars victoriously and pounds chest.

=== Mage’s Ritual ===
[Mage] Chanting incantations and gathering mana.
[Mage] Hurls a blazing fireball at the enemy!
[Mage] Conjures a shimmering magical barrier.

=== Archer’s Ritual ===
[Archer] Nocking arrow and adjusting quiver.
[Archer] Fires a volley of arrows with deadly precision.
[Archer] Dodges and keeps distance from foes.
[Archer] Salutes enemy before vanishing into the trees.
```

---

## 🔁 Iterator Design Pattern: **🎧 DJ Mixer Playlist**

### 📘 Scenario

* A DJ’s application manages multiple playlists (e.g. “House Classics”, “Chill Vibes”).
* Internally each playlist may store songs in different ways (array, ArrayList, etc.), but the DJ just wants to step through each song in order—no matter how it’s stored.
* The Iterator pattern gives you a uniform way to traverse any playlist without exposing its internal structure.

<p align="center"><img width="412" height="250" alt="Iterator" src="https://github.com/user-attachments/assets/67220b7f-75eb-4323-8677-5c824a990fa8" /></p>

### 🎵 Output

```
=== DJ Playlist ===
Now playing: "Levels" by Avicii
Now playing: "Strobe" by deadmau5
```

---

## 🔍 Observer Design Pattern: **🕵️‍♂️ The Whistling Typewriter**

### 📘 Scenario

In Victorian London, Detective Marlowe is hunting a ghost who types cryptic messages on an antique typewriter in an abandoned manor. 
Every time the phantom strikes a new key, three specialists swarm in:

* 🧪 Forensic Analyst
* 🔮 Psychic Medium
* 💻 Tech Geek

<p align="center"><img width="271" height="531" alt="Observer" src="https://github.com/user-attachments/assets/db32677d-cc43-41f7-927e-e7041322e342" /></p>

### 🧾 Output

```
[CrimeScene] New clue discovered: "MURDER AT MIDNIGHT"
🧪 ForensicAnalyst: Dusting the keys for prints on clue → MURDER AT MIDNIGHT
🔮 PsychicMedium: I hear whispers chanting 'MURDER AT MIDNIGHT'!
💻 TechGeek: Arduino logged keystroke sequence: [MURDER AT MIDNIGHT]

[CrimeScene] New clue discovered: "LOOK UNDER THE FLOORBOARD"
🧪 ForensicAnalyst: Dusting the keys for prints on clue → LOOK UNDER THE FLOORBOARD
🔮 PsychicMedium: I hear whispers chanting 'LOOK UNDER THE FLOORBOARD'!
💻 TechGeek: Arduino logged keystroke sequence: [LOOK UNDER THE FLOORBOARD]

[CrimeScene] New clue discovered: "THE BUTLER DID IT"
🧪 ForensicAnalyst: Dusting the keys for prints on clue → THE BUTLER DID IT
🔮 PsychicMedium: I hear whispers chanting 'THE BUTLER DID IT'!
💻 TechGeek: Arduino logged keystroke sequence: [THE BUTLER DID IT]
```

---

## 📊 State Design Pattern: **🎮 Shadow Ops — Stealth Guard AI**

### 📘 Scenario

Drones switch states on the fly:

* **Patrol** → scan area
* **Alert** → investigate threat
* **Attack** → shoot at intruder

As events happen—“seeEnemy”, “hearNoise”, “loseEnemy”, “enemyInRange”—the drone switches its internal state and its behavior changes accordingly. 
The State Pattern lets us encapsulate each mode’s logic in its own class and switch at runtime without huge if/else chains.

<p align="center"><img width="408" height="374" alt="State" src="https://github.com/user-attachments/assets/aba4fc7e-855a-4f2d-88c2-0bf854cb6c12" /></p>

### 🧠 Output

```
[PatrolState] Guard is patrolling the area.
[PatrolState] Intruder spotted! Switching to ALERT state.
[AlertState] Guard is taking cover and surveying the area.

[AlertState] Target in range! Switching to ATTACK state.
[AttackState] Guard is engaging the enemy aggressively.

[AttackState] Target escaped! Switching to PATROL state.
[PatrolState] Guard is patrolling the area.
```

---

## ⚜️ Command Design Pattern: **🦸🏻‍♀️ Crisis at Metropolis**

### 📘 Scenario

The Justice League Command Center has a Control Panel (Invoker) with buttons for different mission types. Each button stores a Command object encapsulating 
the action and the target hero (Receiver). When a crisis hits, the panel simply “presses” the appropriate button, and the corresponding hero executes their mission.

<p align="center"><img width="403" height="515" alt="Command" src="https://github.com/user-attachments/assets/d7bb8f5b-4c20-4d7a-bb1a-509a1543971d" /></p>

### 🧨 Output

```
=== Crisis: Alien Drone Attack ===
[ControlPanel] Activating command...
[Superman] Flying at hypersonic speed to Metropolis!
[Superman] Rescuing civilians from collapsing buildings!

=== Crisis: Joker’s Drone Swarm ===
[ControlPanel] Activating command...
[Batman] Launching Batarang to disable the drone swarm!

=== Crisis: Collapsed Subway Tunnel ===
[ControlPanel] Activating command...
[Flash] Speed-blur rescuing victims in seconds!
```
---

## 📝 Exercises & Extensions

* Implement **OODP2** patterns in the `java/com/tharindu/oodp2/` package.
* Add JEE interceptors to log demo executions automatically.

---

## 📌 OODP2 Package (Upcoming)

```
java/com/tharindu/oodp2/
├── Builder/
├── Decorator/
├── Composite/
├── ChainOfResponsibility/
├── Flyweight/
├── Prototype/
└── Visitor/
```

Patterns to be documented once implementations complete.

---

## 🤝 Contribution

Fork, branch, commit, and send a pull request. Follow Java conventions and include tests.

---

## 📜 License

MIT © 2025 Tharindu714

---

> Learn by doing—master design patterns with real code examples! 🚀
