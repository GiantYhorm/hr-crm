# Generated by Django 2.0.6 on 2018-06-27 09:13

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
        ('requests', '0001_initial'),
        ('interviews', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='interview',
            name='request',
            field=models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='requests.Request'),
        ),
    ]
