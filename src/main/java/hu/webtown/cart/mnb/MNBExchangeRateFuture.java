package hu.webtown.cart.mnb;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import hu.webtown.cart.domain.Cart;

public class MNBExchangeRateFuture {
	
	private Cart cart;
	
	public MNBExchangeRateFuture(Cart cart) {
		this.cart = cart;
	}

	public void compute() {
		MNBCallable callable = new MNBCallable();

		FutureTask<String> futureTask = new FutureTask<String>(callable);

		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(futureTask);

		while (true) {
			try {
				if (futureTask.isDone()) {
					//cart.setEurRate(futureTask.get());
					executor.shutdown();
					return;
				}

				if (!futureTask.isDone()) { 
					System.out.println("FutureTask output=" + futureTask.get());
				}

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
}