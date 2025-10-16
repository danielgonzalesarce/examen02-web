# 🏥 Sistema de Gestión Hospitalaria

Un sistema web moderno y profesional para la gestión integral de pacientes, historias clínicas y antecedentes médicos en entornos hospitalarios.

## ✨ Características

### 🎨 **Diseño Moderno**
- **Interfaz elegante** con colores celestes profesionales
- **Diseño responsive** que se adapta a todos los dispositivos
- **Animaciones sutiles** y efectos visuales modernos
- **Tipografía Inter** para máxima legibilidad

### 🏥 **Módulos del Sistema**
- **Gestión de Pacientes**: Registro y administración de datos personales
- **Historias Clínicas**: Seguimiento médico completo de cada paciente
- **Antecedentes Médicos**: Documentación de alergias, cirugías y enfermedades previas

### 💻 **Tecnologías Utilizadas**
- **Backend**: Spring Boot 3.x
- **Frontend**: Thymeleaf + Bootstrap 5
- **Base de Datos**: H2 (desarrollo) / MySQL (producción)
- **Estilos**: CSS3 con gradientes y efectos modernos
- **Iconos**: Bootstrap Icons

## 🚀 Instalación y Configuración

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+
- Git

### Pasos de Instalación

1. **Clonar el repositorio**
```bash
git clone https://github.com/danielgonzalesarce/examen02-web.git
cd examen02-web
```

2. **Compilar el proyecto**
```bash
mvn clean install
```

3. **Ejecutar la aplicación**
```bash
mvn spring-boot:run
```

4. **Acceder a la aplicación**
- URL: http://localhost:8080
- La aplicación se ejecutará automáticamente

## 📱 Capturas de Pantalla

### Dashboard Principal
- Interfaz moderna con gradientes celestes
- Navegación intuitiva entre módulos
- Diseño responsive para móviles y desktop

### Gestión de Pacientes
- Formularios elegantes con validación
- Lista de pacientes con acciones rápidas
- Estados visuales (activo/inactivo)

### Historias Clínicas
- Registro completo de observaciones médicas
- Vinculación con pacientes existentes
- Seguimiento temporal de consultas

### Antecedentes Médicos
- Documentación de alergias y cirugías
- Clasificación por tipos de antecedentes
- Historial médico completo

## 🛠️ Estructura del Proyecto

```
src/
├── main/
│   ├── java/com/tecsup/hospital_gestion/
│   │   ├── controller/          # Controladores REST
│   │   ├── model/
│   │   │   ├── entities/        # Entidades JPA
│   │   │   ├── daos/           # Repositorios
│   │   │   └── services/       # Lógica de negocio
│   │   └── HospitalGestionApplication.java
│   └── resources/
│       ├── templates/          # Vistas Thymeleaf
│       │   ├── inicio.html
│       │   ├── pacientes/
│       │   ├── historias/
│       │   └── antecedentes/
│       └── application.properties
└── test/                      # Tests unitarios
```

## 🎨 Paleta de Colores

- **Azul Principal**: `#1976d2`
- **Azul Secundario**: `#42a5f5`
- **Azul Claro**: `#1565c0`
- **Fondo**: Gradientes celestes suaves
- **Texto**: Alto contraste para máxima legibilidad

## 📋 Funcionalidades

### ✅ Gestión de Pacientes
- [x] Registro de datos personales
- [x] Validación de formularios
- [x] Estados (activo/inactivo)
- [x] Búsqueda y filtrado
- [x] Edición y eliminación

### ✅ Historias Clínicas
- [x] Creación de historias
- [x] Vinculación con pacientes
- [x] Registro de observaciones
- [x] Fechas de apertura
- [x] Seguimiento temporal

### ✅ Antecedentes Médicos
- [x] Tipos de antecedentes
- [x] Descripciones detalladas
- [x] Vinculación con historias
- [x] Clasificación médica

## 🔧 Configuración de Base de Datos

### H2 (Desarrollo)
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
```

### MySQL (Producción)
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
```

## 🧪 Testing

```bash
# Ejecutar tests unitarios
mvn test

# Ejecutar tests con cobertura
mvn test jacoco:report
```

## 📦 Despliegue

### Docker
```bash
# Construir imagen
docker build -t hospital-gestion .

# Ejecutar contenedor
docker run -p 8080:8080 hospital-gestion
```

### JAR Ejecutable
```bash
# Generar JAR
mvn clean package

# Ejecutar JAR
java -jar target/hospital-gestion-1.0.0.jar
```

## 🤝 Contribución

1. Fork el proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para detalles.

## 👨‍💻 Autor

**Daniel González Arce**
- GitHub: [@danielgonzalesarce](https://github.com/danielgonzalesarce)
- Proyecto: [examen02-web](https://github.com/danielgonzalesarce/examen02-web)

## 📞 Soporte

Si tienes alguna pregunta o sugerencia, no dudes en:
- Abrir un [Issue](https://github.com/danielgonzalesarce/examen02-web/issues)
- Contactar al desarrollador

---

⭐ **¡No olvides darle una estrella al proyecto si te gusta!** ⭐
