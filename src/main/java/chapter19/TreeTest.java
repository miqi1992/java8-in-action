package chapter19;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TreeTest {


    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu(0, "根节点", null));
        menuList.add(new Menu(1, "子节点1", 0));
        menuList.add(new Menu(2, "子节点2", 0));
        menuList.add(new Menu(11, "子节点1.1", 1));
        menuList.add(new Menu(12, "子节点1.2", 1));
        menuList.add(new Menu(13, "子节点1.3", 1));
        menuList.add(new Menu(21, "子节点2.1", 2));
        menuList.add(new Menu(22, "子节点2.2", 2));
        menuList.add(new Menu(23, "子节点2.3", 2));

        List<Menu> result = getChildrens(null, menuList);
        System.out.println(result);
    }

    private static List<Menu> getChildrens(Integer parentId, List<Menu> allList) {
        return allList.stream()
                .filter(menu -> Objects.equals(menu.getParentId(), parentId))
                .map(menu -> {
                    menu.setChildList(getChildrens(menu.getId(), allList));
                    return menu;
                }).collect(Collectors.toList());
    }



    static class Menu {
        private Integer id;

        private String name;

        private Integer parentId;

        public List<Menu> childList;

        public Menu(Integer id, String name, Integer parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }

        public Menu(Integer id, String name, Integer parentId, List<Menu> childList) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
            this.childList = childList;
        }

        public Menu() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getParentId() {
            return parentId;
        }

        public void setParentId(Integer parentId) {
            this.parentId = parentId;
        }

        public List<Menu> getChildList() {
            return childList;
        }

        public void setChildList(List<Menu> childList) {
            this.childList = childList;
        }

        @Override
        public String toString() {
            return "Menu{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", parentId=" + parentId +
                    ", childList=" + childList +
                    '}';
        }
    }
}
