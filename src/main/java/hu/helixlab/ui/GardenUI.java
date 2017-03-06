package hu.helixlab.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import hu.helixlab.ui.garden.Apple;
import hu.helixlab.ui.garden.Plant;
import hu.helixlab.ui.garden.Strawberry;
import hu.helixlab.ui.garden.StrawberryBlue;
import hu.helixlab.ui.garden.Tomato;

/**
 * Main UI class
 * 
 * @author erbalazs
 */
@SpringUI
public class GardenUI extends UI {

	private final Logger logger = LoggerFactory.getLogger(GardenUI.class);

	private VerticalLayout vlInner;

	private GridLayout glGarden;
	private List<Plant> currentPlantList;
	private ChartJs currentChart;

	private void fillGarden() {

		currentPlantList.clear();
		glGarden.removeAllComponents();

		for (int i = 0; i < 42; ++i) { // TODO: magic number

			Button btn = null;
			int r = RandomUtils.nextInt(0, 4);

			switch (r) {
			case 0:
				btn = new Apple();
				break;
			case 1:
				btn = new Strawberry();
				break;
			case 2:
				btn = new StrawberryBlue();
				break;
			case 3:
				btn = new Tomato();
				break;
			default:
				break;
			}

			currentPlantList.add((Plant) btn);
			glGarden.addComponent(btn);

		}

		logger.debug("graden fill succesful");

	}

	private void countAndChart() {

		{

			int aCount = 0;
			int sCount = 0;
			int tCount = 0;

			for (Plant plant : currentPlantList) {

				if (plant instanceof Apple) {
					aCount++;
				} else if (plant instanceof Strawberry) {
					sCount++;
				} else if (plant instanceof Tomato) {
					tCount++;
				}
			}

			logger.trace("plant counts: " + aCount + ", " + sCount + ", " + tCount);

			List<String> l1 = Arrays.asList("Apple", "Strawberry", "Tomato");
			List<Integer> l2 = Arrays.asList(aCount, sCount, tCount);

			ChartJs chart = ChartUtil.buildChart("Garden stats", "piece", l1, l2);
			
			if (currentChart == null) {
				vlInner.addComponent(chart);
			} else {
				vlInner.replaceComponent(currentChart, chart);
			}

			currentChart = chart;

		}

	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		
		VerticalLayout vlWrapper = new VerticalLayout();
		vlWrapper.setSizeFull();

		setContent(vlWrapper);

		vlInner = new VerticalLayout();
		vlInner.setWidth("600px");
		vlInner.setSpacing(true);
		vlInner.setMargin(true);

		vlWrapper.addComponent(vlInner);
		vlWrapper.setComponentAlignment(vlInner, Alignment.TOP_CENTER);

		// ---

		currentPlantList = new ArrayList<>();

		glGarden = new GridLayout();
		glGarden.setSpacing(true);
		glGarden.setColumns(8);
		glGarden.setWidth("100%");
		glGarden.setHeight(null);

		vlInner.addComponent(glGarden);

		// ---
		
		fillGarden();
		countAndChart();
		
		// ---
		
		Button btnRefill = new Button("Refill", new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				fillGarden();
				countAndChart();
			}

		});
		vlInner.addComponent(btnRefill);

	}

}