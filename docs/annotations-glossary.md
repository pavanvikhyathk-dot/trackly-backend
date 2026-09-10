# Annotations glossary

Plain-English, one line each. Added to as we go.

## Lombok
- **`@Builder`** — lets you make an object like `JobApplication.builder().company("Google").build()`, step by step.
- **`@Getter`** — auto-makes `getCompany()`, `getRole()`, etc. for every field. You don't write them by hand.
- **`@Setter`** — auto-makes `setCompany()`, `setRole()`, etc. Same idea, but for changing values.
- **`@NoArgsConstructor`** — auto-makes an empty constructor: `new JobApplication()` with nothing inside the brackets.

## Spring Data MongoDB
- **`@Document(collection = "applications")`** — tells Spring "this class = one row (document) in the `applications` collection in MongoDB."
- **`@Id`** — tells Spring "this field is the unique ID for this document" (like a primary key).
- **`@CreatedDate`** — tells Spring "fill this field automatically with the current time, only once, when the document is first saved."
- **`@LastModifiedDate`** — tells Spring "update this field automatically with the current time, every time the document is saved again."
- **`@EnableMongoAuditing`** — the on-switch, placed on a `@Configuration` class (not on the model). Without this somewhere, `@CreatedDate` and `@LastModifiedDate` do nothing at all.
- **`findById` returns `Optional<T>`, not `T`.** `Optional` is a box that either has a value or is empty — forces you to handle "not found" instead of getting a `null` you might forget to check. `.orElseThrow(...)` unwraps it: gives you the value, or throws if empty. This method isn't written in your own repository — it's inherited from `CrudRepository`, which `MongoRepository` extends under the hood (`MongoRepository` → `PagingAndSortingRepository` → `CrudRepository`). `Ctrl+Click` on any inherited method in IntelliJ to jump to where it's actually declared.

## Exception handling
- **Custom exceptions** extend `RuntimeException` (unchecked — callers aren't forced to catch it or declare `throws`) rather than `Exception` (checked). Constructor just builds a message and passes it to `super(...)`. Always name them ending in `Exception`.
- **`@RestControllerAdvice`** — a class that catches exceptions thrown anywhere across every controller in the app, in one central place, instead of try/catch in every method.
- **`@ExceptionHandler(SomeException.class)`** — on a method inside that class, says "when `SomeException` is thrown, run this method instead of letting it bubble up into a 500." Return a `ResponseEntity` with the right HTTP status (e.g. `404 Not Found`) and a clean message, instead of a stack trace leaking to the client.

## Gotchas
- **Spring Boot 4 renamed the Mongo URI property.** `spring.data.mongodb.uri` (Boot 2/3) silently does nothing in Boot 4 — the key is now `spring.mongodb.uri`. No error, no warning: it just falls back to the driver's default `localhost:27017/test`, so your data saves to the wrong database and looks "missing." Always double check the property prefix matches your actual Boot version.
