// Abstract Product
abstract class Document {
    public abstract void create();
}
// Concrete Product - WordDocument
class WordDocument extends Document {
    @Override
    public void create() {
        System.out.println("Word document created");
    }
}

// Concrete Product - ExcelDocument
class ExcelDocument extends Document {
    @Override
    public void create() {
        System.out.println("Excel document created");
    }
}

// Creator
class Application {
    public Document createDocument(String docType) {
        if (docType.equalsIgnoreCase("word")) {
            return new WordDocument();
        } else if (docType.equalsIgnoreCase("excel")) {
            return new ExcelDocument();
        } else {
            return null;
        }
    }
}

// Usage
public class FactoryMethodPattern {
    public static void main(String[] args) {
        Application app = new Application();
        Document doc = app.createDocument("excel");
        if (doc != null) {
            doc.create();
        }
    }
}

