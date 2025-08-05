package com.tharindu.oodp2.Interpreter;

interface Expression_SmartHome {
    void interpret(Context context);
}

class Context {
    public void TurnONDevice(String device, String location) {
        System.out.println(device + " in " + location + " Turning ON");
    }

    public void TurnOFFDevice(String device, String location) {
        System.out.println(device + " in " + location + " Turning OFF");
    }

    public void increaseTemperature(int value) {
        System.out.println("Increasing temperature by " + value + " degrees");
    }

    public void decreaseTemperature(int value) {
        System.out.println("Decreasing temperature by " + value + " degrees");
    }
}

class DeviceCommand implements Expression_SmartHome {
    String command;
    String device;
    String location;

    public DeviceCommand(String command, String device, String location) {
        this.command = command;
        this.device = device;
        this.location = location;
    }

    @Override
    public void interpret(Context context) {
        if (command.equalsIgnoreCase("on")) {
            context.TurnONDevice(device, location);
        } else if (command.equalsIgnoreCase("off")) {
            context.TurnOFFDevice(device, location);
        } else {
            System.out.println("Unknown command: " + command);
        }
    }
}

class TemperatureCommand implements Expression_SmartHome {
    String action;
    int value;

    public TemperatureCommand(String action, int value) {
        this.action = action;
        this.value = value;
    }

    @Override
    public void interpret(Context context) {
        if (action.equalsIgnoreCase("increase")) {
            context.increaseTemperature(value);
        } else if (action.equalsIgnoreCase("decrease")) {
            context.decreaseTemperature(value);
        } else {
            System.out.println("Unknown temperature action: " + action);
        }
    }
}

class CommandParser {
    public static Expression_SmartHome parse(String input) {
        String[] parts = input.trim().split(" ");
        if (parts[0].equalsIgnoreCase("turn")) {
            String command = parts[1];
            String device = parts[2];
            String location = parts.length > 3 ? parts[3] : "default location";

            return new DeviceCommand(command, device, location);
        } else if (parts[0].equalsIgnoreCase("increase") || parts[0].equalsIgnoreCase("decrease")) {
            if (parts.length == 4 && parts[2].equalsIgnoreCase("by")) {
                String action = parts[0];
                try {
                    int value = Integer.parseInt(parts[3]);
                    return new TemperatureCommand(action, value);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number: " + parts[3]);
                }
            } else {
                System.err.println("Invalid temperature command format: " + input);
            }
            return null;
        } else {
            System.err.println("Unknown command: " + input);
            return null;
        }
    }
}

public class SmartHome_main {
    public static void main(String[] args) {
        Context context = new Context();

        Expression_SmartHome expression = CommandParser.parse("turn on kitchen light");
        if (expression != null) {
            expression.interpret(context);
        }
        System.out.println("---------------------------------");
        expression = CommandParser.parse("turn off living room fan");
        if (expression != null) {
            expression.interpret(context);
        }
        System.out.println("---------------------------------");
        expression = CommandParser.parse("increase temperature by 5");
        if (expression != null) {
            expression.interpret(context);
        }
        System.out.println("---------------------------------");
        expression = CommandParser.parse("decrease temperature by 3");
        if (expression != null) {
            expression.interpret(context);
        }
        System.out.println("---------------------------------");
        expression = CommandParser.parse("turn on bedroom heater");
        if (expression != null) {
            expression.interpret(context);
        }
        System.out.println("---------------------------------");
        expression = CommandParser.parse("turn off bathroom light");
        if (expression != null) {
            expression.interpret(context);
        }
        System.out.println("---------------------------------");
        expression = CommandParser.parse("unknown command");
        if (expression != null) {
            expression.interpret(context);
        }
    }
}
