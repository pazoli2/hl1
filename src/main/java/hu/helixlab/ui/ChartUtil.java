package hu.helixlab.ui;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.byteowls.vaadin.chartjs.data.BarDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;

/**
 * Sample charts...
 * 
 * @author erbalazs
 */
public class ChartUtil {

	public static ChartJs buildChart(String title, String valueTypeLabel, List<String> labels, List<Integer> values) {

		BarChartConfig config = new BarChartConfig();

		config
				.data()
				.labels(labels.toArray(new String[labels.size()]))
				.addDataset(new BarDataset().type().label(valueTypeLabel).backgroundColor("rgba(220,220,220,0.8)"))
				.and();

		config.options().scales()
				.add(Axis.Y, new LinearScale().display(true).position(Position.RIGHT).gridLines().drawOnChartArea(false).and())
				.and();

		config.options()
				.responsive(true)
				.title()
				.display(true)
				.position(Position.LEFT)
				.text(title)
				.and()
				.done();

		for (Dataset<?, ?> ds : config.data().getDatasets()) {

			List<Double> data = new ArrayList<>();

			for (int i = 0; i < values.size(); i++) {
				data.add((double) values.get(i));
			}

			data.add(0d);
			
			if (ds instanceof BarDataset) {
				BarDataset bds = (BarDataset) ds;
				bds.dataAsList(data);
			}
		}

		ChartJs chart = new ChartJs(config);
		chart.setJsLoggingEnabled(false);

		chart.setWidth("100%");

		return chart;

	}

}
