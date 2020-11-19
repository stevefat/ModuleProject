package com.ngh.arouter_annotation.bean;

import javax.lang.model.element.Element;

/**
 * 最终路由 要 传递 对象
 * <p>
 * 路由路径Path的最终实体封装类
 * 例如：app分组中的MainActivity对象，这个对象有更多的属性
 */
public class RouterBean {
    private enum TypeEnum {
        ACTIVITY
    }

    private TypeEnum typeEnum; //枚举类型
    private Element element;
    private Class<?> myClass;
    private String path;
    private String group;

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Class<?> getMyClass() {
        return myClass;
    }

    public void setMyClass(Class<?> myClass) {
        this.myClass = myClass;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    private RouterBean(TypeEnum typeEnum, Class<?> myClass, String path, String group) {
        this.typeEnum = typeEnum;
        this.myClass = myClass;
        this.path = path;
        this.group = group;
    }

    public static RouterBean create(TypeEnum typeEnum, Class<?> myClass, String path, String group){
        return new RouterBean(typeEnum,myClass,path,group);
    }

    private RouterBean(Builder builder) {
        this.typeEnum = builder.type;
        this.element = builder.element;
        this.myClass = builder.clazz;
        this.path = builder.path;
        this.group = builder.group;
    }

    public static class Builder{
        // 枚举类型：Activity
        private TypeEnum type;
        // 类节点
        private Element element;
        // 注解使用的类对象
        private Class<?> clazz;
        // 路由地址
        private String path;
        // 路由组
        private String group;

        public TypeEnum getType() {
            return type;
        }
        public Builder addType(TypeEnum type) {
            this.type = type;
            return this;
        }

        public Builder addElement(Element element) {
            this.element = element;
            return this;
        }

        public Builder addClazz(Class<?> clazz) {
            this.clazz = clazz;
            return this;
        }

        public Builder addPath(String path) {
            this.path = path;
            return this;
        }

        public Builder addGroup(String group) {
            this.group = group;
            return this;
        }

        // 最后的build或者create，往往是做参数的校验或者初始化赋值工作
        public RouterBean build() {
            if (path == null || path.length() == 0) {
                throw new IllegalArgumentException("path必填项为空，如：/app/MainActivity");
            }
            return new RouterBean(this);
        }
    }



    @Override
    public String toString() {
        return "RouterBean{" +
                "typeEnum=" + typeEnum +
                ", element=" + element +
                ", myClass=" + myClass +
                ", path='" + path + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
