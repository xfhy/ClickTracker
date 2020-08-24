package com.xfhy.plugin

import com.android.build.api.transform.Transform
import com.xfhy.plugin.base.BaseTransformPlugin
import org.gradle.api.Project

class ClickTrackPlugin extends BaseTransformPlugin {

    @Override
    Transform getCustomTransform(Project project) {
        return new ClickTrackTransform()
    }
}
