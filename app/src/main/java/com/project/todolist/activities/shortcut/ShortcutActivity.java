package com.project.todolist.activities.shortcut;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.project.todolist.R;

public class ShortcutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        Intent shortcutActivity = new Intent(this, CreateEditShortcut.class);
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutActivity);
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.add_reminder));
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.mipmap.ic_launcher));
        setResult(RESULT_OK, intent);

        finish();
    }
}