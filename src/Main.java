import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Map<String, String>> notebooks = new HashSet<>();

        notebooks.add(createNotebook("8GB", "500GB", "Windows 10", "Black"));
        notebooks.add(createNotebook("16GB", "1TB", "Windows 10", "Silver"));
        notebooks.add(createNotebook("8GB", "256GB", "Linux", "Black"));
        notebooks.add(createNotebook("32GB", "2TB", "macOS", "Gray"));

        Map<String, String> filters = getFilters();
        Set<Map<String, String>> filteredNotebooks = filterNotebooks(notebooks, filters);

        System.out.println("Filtered Notebooks:");
        for (Map<String, String> notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    private static Map<String, String> createNotebook(String ram, String hdd, String os, String color) {
        Map<String, String> notebook = new HashMap<>();
        notebook.put("RAM", ram);
        notebook.put("HDD", hdd);
        notebook.put("OS", os);
        notebook.put("Color", color);
        return notebook;
    }

    private static Map<String, String> getFilters() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String criteria;
        while (!(criteria = scanner.nextLine()).isEmpty()) {
            switch (criteria) {
                case "1":
                    System.out.print("Введите минимальное значение ОЗУ: ");
                    filters.put("RAM", scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Введите минимальное значение объема ЖД: ");
                    filters.put("HDD", scanner.nextLine());
                    break;
                case "3":
                    System.out.print("Введите операционную систему: ");
                    filters.put("OS", scanner.nextLine());
                    break;
                case "4":
                    System.out.print("Введите цвет: ");
                    filters.put("Color", scanner.nextLine());
                    break;
                default:
                    System.out.println("Некорректный критерий.");
            }
            System.out.println("Введите следующий критерий или оставьте пустым для завершения:");
        }

        return filters;
    }

    private static Set<Map<String, String>> filterNotebooks(Set<Map<String, String>> notebooks, Map<String, String> filters) {
        Set<Map<String, String>> filteredNotebooks = new HashSet<>();

        for (Map<String, String> notebook : notebooks) {
            boolean matches = true;
            for (Map.Entry<String, String> filter : filters.entrySet()) {
                if (!notebook.get(filter.getKey()).equalsIgnoreCase(filter.getValue())) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}
