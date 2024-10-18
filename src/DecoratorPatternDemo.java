// Component
interface Text {
    String render();
}

// Concrete Component
class BasicText implements Text {
    @Override
    public String render() {
        return "Basic Text";
    }
}
// Decorator
abstract class TextDecorator implements Text {
    protected Text decoratedText;
    public TextDecorator(Text text) {
        this.decoratedText = text;
    }
    public String render() {
        return decoratedText.render();
    }
}

// Concrete Decorators
class BoldDecorator extends TextDecorator {
    public BoldDecorator(Text text) {
        super(text);
    }
    @Override
    public String render() {
        return "<b>" + super.render() + "</b>";
    }
}

class ItalicDecorator extends TextDecorator {
    public ItalicDecorator(Text text) {
        super(text);
    }
    @Override
    public String render() {
        return "<i>" + super.render() + "</i>";
    }
}

// Usage
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Text text = new BasicText();
        System.out.println("Basic: " + text.render());

        Text boldText = new BoldDecorator(text);
        System.out.println("Bold: " + boldText.render());

        Text italicBoldText = new ItalicDecorator(boldText);
        System.out.println("Italic and Bold: " + italicBoldText.render());

    }
}

