package io.github.mazaytsev.jcst;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import io.github.mazaytsev.jcst.enums.ProjectType;

public class ProjectInstance {
    private static ProjectInstance projectInstance;
    private static ActiveXComponent activeXComponent;
    private static Dispatch document;

    private ProjectInstance(String projectType){
        activeXComponent = new ActiveXComponent("CSTStudio.Application");
        document = activeXComponent.invoke(projectType).getDispatch();
    }

    public Dispatch getDocument(){
        return document;
    }

    public ActiveXComponent getActiveXComponent(){
        return activeXComponent;
    }

    public static ProjectInstance getProjectInstance(ProjectType type){
        if (projectInstance ==null) {
            projectInstance = new ProjectInstance(type.getType());
        }
        return projectInstance;
    }

    public static void closeProject(){
        if (projectInstance !=null){
            activeXComponent.invoke("Quit");
            projectInstance =null;
        }
    }
}
